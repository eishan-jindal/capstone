package com.xen.cap.converter;

import com.xen.cap.dto.PaymentDto;
import com.xen.cap.dto.UserDto;
import com.xen.cap.entity.Payment;
import com.xen.cap.entity.User;

public class PaymentConverter {

	public static PaymentDto convertToDto(Payment payment) {
		
		PaymentDto dto = new PaymentDto();
		
		if(payment==null) {

			dto.setCustomer("payment failed");
			dto.setMerchant("payment failed");
			dto.setMoney("payment failed");
			return dto;
		}
		
		dto.setCustomer(payment.getCustomer());
		dto.setMerchant(payment.getMerchant());
		dto.setMoney(payment.getMoney());
		
		return dto;
	}
	

}
