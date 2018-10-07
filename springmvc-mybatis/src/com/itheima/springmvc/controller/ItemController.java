package com.itheima.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.springmvc.exception.MessageException;
import com.itheima.springmvc.pojo.Items;
import com.itheima.springmvc.pojo.QueryVo;
import com.itheima.springmvc.service.ItemService;

/**
 * 商品管理
 * 
 * @author lx
 *
 */
@Controller
public class ItemController {
	
/*	Controller层返回值
	1.ModelAndView 无敌的 带着数据，带着视图
	2.String 返回视图路径 model带着数据 官方推荐此种， 解耦 数据视图分离 符合mvc
	3.void ajax  请求 合适
	
	*/
	public String test1(Model model) {
		List<Items> list = itemService.selectItemsList();
		model.addAttribute("items", list);
		return "itemList";
	}
	public void test2(Model model,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		List<Items> list = itemService.selectItemsList();
		model.addAttribute("items", list);
		request.getRequestDispatcher("itemList").forward(request, response);
		
	}
	
	
	@Autowired
	private ItemService itemService;
	//入门程序 第一   包类 + 类包 + 方法名
	@RequestMapping(value = "/item/itemlist.action")
	public ModelAndView itemList() throws MessageException{
		//Integer i =1/0;
		//从Mysql中查询
		List<Items> list = itemService.selectItemsList();
	//	if(null==null) {
	//		throw new MessageException("列表为空");
	//	}
		ModelAndView mav = new ModelAndView();
		//数据
		mav.addObject("itemList", list);
		mav.setViewName("itemList");
		return mav;
	}
	//去修改页面 入参 id
	@RequestMapping(value = "/itemEdit.action")
//	public ModelAndView toEdit(@RequestParam(value = "id",required = false,defaultValue = "1") Integer idaaq,
	public ModelAndView toEdit(Integer id,
			HttpServletRequest request,HttpServletResponse response
			,HttpSession session,Model model){
		
		//Servlet时代开发
//		String id = request.getParameter("id");
		
		//查询一个商品
//		Items items = itemService.selectItemsById(Integer.parseInt(id));
		Items items = itemService.selectItemsById(id);
		ModelAndView mav = new ModelAndView();
		//数据
		mav.addObject("item", items);
		mav.setViewName("editItem");
		return mav;
		
	}
	//提交修改页面 入参  为 Items对象  
	@RequestMapping(value = "/updateitem.action")
//	public ModelAndView updateitem(Items items){
	public String updateitem(QueryVo vo ,MultipartFile pictureFile) throws Exception{
		String name = UUID.randomUUID().toString() .replaceAll("-", "");
		String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
		pictureFile.transferTo(new File("E:\\upload\\"+name+"."+ext));
		vo.getItems().setPic(name+"."+ext);
		//修改
		itemService.updateItemsById(vo.getItems());
		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("success");
		return "redirect:/itemEdit.action?id="+vo.getItems().getId();
	}
	//删除多个items
	@RequestMapping(value="/deletes.action")
	public ModelAndView deletes(QueryVo vo) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
	
	
}
