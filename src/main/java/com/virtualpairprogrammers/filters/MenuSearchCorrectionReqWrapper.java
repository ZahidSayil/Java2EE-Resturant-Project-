package com.virtualpairprogrammers.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MenuSearchCorrectionReqWrapper extends HttpServletRequestWrapper {

	private String newSearchTerm;
	
	public void setNewSearchTerm(String newSearchTerm) {
		this.newSearchTerm = newSearchTerm;
	}

	public MenuSearchCorrectionReqWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String key) {
		
		if(key.equals("searchTerm")) {
			
			return newSearchTerm;
		}else {
			return super.getParameter(key);
		}
	}
}
