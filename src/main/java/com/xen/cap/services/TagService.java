package com.xen.cap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xen.cap.dao.TagRepository;
import com.xen.cap.entity.Tag;


@Service
public class TagService {
	
	@Autowired
	private TagRepository tagRepository;
	
	
	public List<Tag> findAll(){
		return tagRepository.findAll();
	}
	
	public void save(Tag tag) {
		tagRepository.save(tag);
	}
}
