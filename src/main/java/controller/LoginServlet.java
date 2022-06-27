package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.DaoFactory;
import model.entities.User;
import model.exceptions.LoginException;
import model.service.UserService;
import model.validation.UserValidation;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	private UserService service = new UserService();
	
	public LoginServlet() {
		
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			User user = service.login(username, password);	
			if(user != null) {
				HttpSession oldSession = request.getSession(false);
				if(oldSession != null) {
					oldSession.invalidate();
				}
				HttpSession session = request.getSession(true);
				session.setAttribute("user", user);
				response.sendRedirect("home");
			} else {
				request.setAttribute("status", "incorrect");
		        request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch(LoginException e) {
			e.printStackTrace();
		}
	}

}
