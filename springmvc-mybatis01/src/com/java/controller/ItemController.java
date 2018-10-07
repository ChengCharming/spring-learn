package com.java.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.pojo.Items;
import com.java.service.ItemsService;
import com.java.service.ItemsServiceImpl;

@Controller
public class ItemController {
	@Autowired
	private ItemsService itemsService ;
	
	/** 
	* 处理空字符串 
	* 
	* @param binder 
	*/ 
	@InitBinder 
	public void initBinder(WebDataBinder binder) { 
	binder.registerCustomEditor(String.class, new StringTrimmerEditor(true)); 
	} 

	@RequestMapping(value ="/item/itemlist.action")
	public ModelAndView itemList() {
		List<Items> list = itemsService.selectAllItems();

		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList", list);
		mav.setViewName("itemList.jsp");
		return mav;
	}
	@RequestMapping(value="/itemEdit.action")
	public ModelAndView toEdit(HttpServletRequest request,HttpServletResponse response,Model model,HttpSession session) {
		String id = request.getParameter("id");
		Items item = itemsService.selectByid(Integer.parseInt(id));
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", item);
		mav.setViewName("editItem.jsp");
		return mav;
	}
	@RequestMapping(value="/updateitem.action")
	public ModelAndView editItems(Items items) {
	
		itemsService.updateItems(items);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success.jsp");
		return mav;
	
	}
}
