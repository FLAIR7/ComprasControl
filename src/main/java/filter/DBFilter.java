package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import db.DB;

@WebFilter(urlPatterns = {"/*"})
public class DBFilter implements javax.servlet.Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			chain.doFilter(request, response);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		DB.getConnection();
	}
	
	@Override
	public void destroy() {
		
	}

}
