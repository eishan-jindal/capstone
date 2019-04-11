package com.xen.cap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xen.cap.converter.TagConverter;
import com.xen.cap.dao.TagDao;
import com.xen.cap.dto.TagDto;
import com.xen.cap.entity.Tag;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TagService {
	
	@Autowired TagDao tagDao;

	public TagDto getTagDto(String uin) {
		
		Tag tag = tagDao.getTagByUin(uin);
		return TagConverter.convertToDto(tag);
	}

}
