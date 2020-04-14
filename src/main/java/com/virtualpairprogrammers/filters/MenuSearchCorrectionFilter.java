package com.virtualpairprogrammers.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/searchResults.html")
public class MenuSearchCorrectionFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String searchTerm = request.getParameter("searchTerm");
		if(searchTerm.toLowerCase().equals("chook")) {
			MenuSearchCorrectionReqWrapper wrapper = new MenuSearchCorrectionReqWrapper((HttpServletRequest) request);
			wrapper.setNewSearchTerm("chicken");
			chain.doFilter(wrapper, response);
		}else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {

	}

}
