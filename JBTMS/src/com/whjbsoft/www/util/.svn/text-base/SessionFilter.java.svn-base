package com.whjbsoft.www.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {
	private static final String[] NoFilter_Pages = { "/JBTMS/error.jsp",
			"/JBTMS/logout.jsp", "/JBTMS/index.jsp", "/JBTMS/login.do"};

	private static final String Login_Page = "/JBTMS/index.jsp";

	public void destroy() {

	}
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		String path = request.getRequestURI();
		for(int i=0;i<NoFilter_Pages.length;i++){
			if (path.equals(NoFilter_Pages[i])) {
				chain.doFilter(req, res);
				return;
			}	
		}
		if (session.getAttribute("userName") == null) {
			response.sendRedirect(Login_Page);
			return;
		}
		chain.doFilter(req, res);
		return;
	}

	public void init(FilterConfig config) throws ServletException {

	}

}
