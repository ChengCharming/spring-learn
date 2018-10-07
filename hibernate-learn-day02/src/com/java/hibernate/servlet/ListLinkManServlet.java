package com.java.hibernate.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.java.hibernate.bean.LinkMan;
import com.java.hibernate.service.LinkManService;
import com.java.hibernate.service.LinkManServiceImpl;

/**
 * Servlet implementation class ListLinkManServlet
 */
public class ListLinkManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LinkManService linkManService = new LinkManServiceImpl();

    public ListLinkManServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lkm_name = request.getParameter("lkm_name");
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		if(lkm_name != null &&!"".equals(lkm_name)) {
			dc.add(Restrictions.like("lkm_name", lkm_name));
		}
		
		List<LinkMan> list = linkManService.getLinkMan(dc);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/linkman/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
