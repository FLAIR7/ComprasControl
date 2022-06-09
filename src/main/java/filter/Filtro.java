package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entities.User;

@WebFilter(urlPatterns = {"/account.jsp", "/account", "/home.jsp", "/home", "/products.jsp", "/products"})
public class Filtro implements Filter{
	
	private ServletContext context;
	
	@Override
	public void init(FilterConfig filterConfig) {
		this.context = filterConfig.getServletContext();
		this.context.log("AutenticationFilter initialized");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		User user = (User) req.getSession().getAttribute("user");
		HttpSession session = req.getSession(false);
		if(session == null || user == null) {
			this.context.log("Unautorized acess request");
			res.sendRedirect(req.getContextPath() + "/login.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}

}
