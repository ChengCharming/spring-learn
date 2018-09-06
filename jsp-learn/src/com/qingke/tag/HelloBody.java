package com.qingke.tag;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloBody extends SimpleTagSupport{
	
	public HelloBody() {
		
	}
	public void doTag() throws JspException, IOException {
		StringWriter sw =new StringWriter();
		getJspBody().invoke(sw);
		Date d =new Date();
		getJspContext().getOut().println(sw.toString()+"  "+d.toString());
	}
}
