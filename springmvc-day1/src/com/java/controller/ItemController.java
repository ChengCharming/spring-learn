package com.java.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.pojo.Items;

@Controller
public class ItemController {

	@RequestMapping(value ="/item/itemlist.action")
	public ModelAndView itemList() {
		List<Items> list = new ArrayList<>();
		list.add(new Items(1, "1华为 荣耀8", 2399f, new Date(0), "质量好！1"));
		list.add(new Items(2, "2华为 荣耀8", 2399f, new Date(0), "质量好！2"));
		list.add(new Items(3, "3华为 荣耀8", 2399f, new Date(0), "质量好！3"));
		list.add(new Items(4, "4华为 荣耀8", 2399f, new Date(0), "质量好！4"));
		list.add(new Items(5, "5华为 荣耀8", 2399f, new Date(0), "质量好！5"));
		list.add(new Items(6, "6华为 荣耀8", 2399f, new Date(0), "质量好！6"));

		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList", list);
		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		return mav;
	}
	
}
