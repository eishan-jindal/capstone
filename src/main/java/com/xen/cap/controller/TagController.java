package com.xen.cap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xen.cap.entity.Account;
import com.xen.cap.entity.Tag;
import com.xen.cap.services.TagService;

@Controller
@RequestMapping(value = "/tag")
public class TagController {

	@Autowired
	private TagService tagService;

	@RequestMapping(method = RequestMethod.GET)
	public String userHome(Model theModel) {
		theModel.addAttribute("theDate", new java.util.Date());
		return "home";
	}

	@RequestMapping("/list")
	public String listUsers(Model theModel) {
		List<Tag> tags = tagService.findAll();
		theModel.addAttribute("tags", tags);
		return "listTags";
	}

	@RequestMapping("/form")
	public String saveTag(Model theModel) {
		Tag newTag = new Tag();
		theModel.addAttribute("tag", newTag);
		return "NewTag";
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public String TagSaveRedirect(@ModelAttribute("tag") Tag tag) {

		tagService.save(tag);
		return "redirect:/tag/list";
	}

}
