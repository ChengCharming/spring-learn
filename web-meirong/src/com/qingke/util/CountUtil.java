package com.qingke.util;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class CountUtil {
	public static void  getCount(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookies[]=request.getCookies();
		Cookie counter =null;
		if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals("counter")) {
					counter=c;
					break;
				}
			}
		}
		if(counter==null) {
			counter=new Cookie("counter","1");
		}else {
			Integer count = Integer.parseInt(counter.getValue());
			count++;
			counter.setValue(count.toString());
		}
		response.addCookie(counter);
		request.setAttribute("count", counter.getValue());
	}
	public static void  getCount(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("count")!=null) {
			int count =(Integer)session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
		}else {
			session.setAttribute("count", 1);
		}
		
		

		ServletContext context = request.getServletContext();
		if(context.getAttribute("allcount")!=null) {
			int count = (Integer) context.getAttribute("allcount");
			count++;
			context.setAttribute("allcount", count);
		}else {
			context.setAttribute("allcount", 1);
		}
	
	}

}
