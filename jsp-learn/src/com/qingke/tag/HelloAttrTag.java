package com.qingke.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloAttrTag extends SimpleTagSupport{
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public void doTag()throws IOException, JspException {
		if(message!=null) {
			JspWriter out = getJspContext().getOut();
			out.print(message);
		}else {
			StringWriter sw =new StringWriter();
			if(getJspBody()!=null) {
				getJspBody().invoke(sw);
				getJspContext().getOut().println(sw.toString());;
			}
			
		}
	}
	
}
