package com.qingke.tag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {

	public HelloTag() {
		
	}
	public void doTag() {
		JspWriter  out = getJspContext().getOut();
		try {
			out.print("Hello this is my first tag");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
