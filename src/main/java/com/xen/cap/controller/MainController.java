package com.xen.cap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xen.cap.dto.AndroidDto;
import com.xen.cap.dto.PaymentDto;
import com.xen.cap.dto.TagDto;
import com.xen.cap.dto.UserDto;
import com.xen.cap.services.PaymentService;
import com.xen.cap.services.TagService;
import com.xen.cap.services.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class MainController {

	private static Logger logger = LoggerFactory.getLogger(MainController.class);
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private TagService tagService;
    
    @Autowired
    private PaymentService paymentService;
    
    
	@GetMapping("/adminDetails")
	public UserDto getUser() {

		return userService.getUserDto("1");
	}
	
	@PostMapping("/userDetails")
	public UserDto getUserDetails(@ModelAttribute UserDto userdto) {
		
		return userService.getUserDtoByCredentials(userdto.getUsername(), userdto.getPassword());
	}
	
	@PostMapping("/makePayment")
	public PaymentDto validateAndSavePayment(@ModelAttribute AndroidDto androidDto) {
		
		PaymentDto errorDto = new PaymentDto();
		errorDto.setCustomer("error");
		errorDto.setMerchant("error");
		errorDto.setMoney("error");
		
		UserDto merchant = userService.getUserDtoByCredentials(androidDto.getUsername(), androidDto.getPassword());
		logger.info("****" + androidDto.getUsername() + " ** " 
						+  androidDto.getPassword() + " ** " 
						+ androidDto.getUin() + " ** "
						+ merchant.getRole());
		
		if(merchant.getRole().equals("MERCHANT")) {
			TagDto tagDto = tagService.getTagDto(androidDto.getUin());
			if(!tagDto.getUsername().equals("tag not found") && !tagDto.getLock().equals("yes") && !tagDto.getValid().equals("no")) {
				
				UserDto customer = userService.getUserDto(tagDto.getUsername());
				
				int limit = Integer.parseInt(tagDto.getLimit());
				int transaction = Integer.parseInt(androidDto.getMoney());
				int customerBalance = Integer.parseInt(customer.getBalance());
				int merchantBalance = Integer.parseInt(merchant.getBalance());
				
				if(transaction<=customerBalance && transaction <= limit) {
					String newCustomerBalance = Integer.toString(customerBalance-transaction);
					String newMerchantBalance = Integer.toString(merchantBalance+transaction);
					
					userService.saveUser(userService.getUserId(customer),newCustomerBalance, customer.getRole(), customer.getPassword(), customer.getUsername());
					userService.saveUser(userService.getUserId(merchant), newMerchantBalance, merchant.getRole(), merchant.getPassword(), merchant.getUsername());
					
					return paymentService.savePayment(paymentService.createNewPayment(merchant.getUsername(), customer.getUsername(), androidDto.getMoney()));
				}
				else {
					errorDto.setMoney("balance/limit error");
					return errorDto;
				}
			}
			else {
				errorDto.setCustomer("customer tag not found");
				errorDto.setMerchant("merchant ok");
				return errorDto;
			}
		}
		else{
			return errorDto;
		}
	}
    
	/*
	@RequestMapping(path="/getUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> getUser() {

		return new ResponseEntity<UserDto>(userService.getUserDto("1"),HttpStatus.OK);
	}*/

}
