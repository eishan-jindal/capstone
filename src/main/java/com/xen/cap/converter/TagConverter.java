package com.xen.cap.converter;

import com.xen.cap.dto.TagDto;
import com.xen.cap.entity.Tag;


public class TagConverter {
	
	public static TagDto convertToDto(Tag tag) {
		
		TagDto dto = new TagDto();
		
		if(tag == null) {
			
			dto.setUsername("tag not found");
			return dto;
		}
		
		dto.setUin(tag.getUin());
		dto.setUsername(tag.getUsername());
		dto.setLimit(tag.getLimit());
		dto.setLock(tag.getLock());
		dto.setPin(tag.getPin());
		dto.setValid(tag.getValid());
		
		return dto;
	}



}
