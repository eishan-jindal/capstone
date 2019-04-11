package com.xen.cap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xen.cap.dto.UserDto;
import com.xen.cap.entity.User;
import com.xen.cap.services.UserService;

@RestController
@RequestMapping("/api")
public class MainController {
	
    @Autowired
    private UserService userService;
    
    
	@GetMapping("/adminDetails")
	public UserDto getUser() {

		return userService.getUserDto("1");
	}
	
	@PostMapping("/userDetails")
	public UserDto getUserDetails(@ModelAttribute UserDto userdto) {
		
		return userService.getUserDtoByCredentials(userdto.getUsername(), userdto.getPassword());
	}
    
	/*
	@RequestMapping(path="/getUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> getUser() {

		return new ResponseEntity<UserDto>(userService.getUserDto("1"),HttpStatus.OK);
	}*/

}
