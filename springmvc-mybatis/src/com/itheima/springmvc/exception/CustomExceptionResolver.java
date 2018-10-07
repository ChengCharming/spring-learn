package com.itheima.springmvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver{

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception e) {
		ModelAndView mav = new ModelAndView();
		if(e instanceof MessageException) {
			MessageException me = (MessageException)e;
			mav.addObject("error",me.getMessage());
		}
		else {
			mav.addObject("error","出现未知异常");
		}
		mav.setViewName("error");
		return mav;
	}

}
