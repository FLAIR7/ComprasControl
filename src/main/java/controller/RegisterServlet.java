package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entities.User;
import model.exceptions.UserExistException;
import model.service.UserService;
import model.validation.UserValidation;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	
	private UserService service = new UserService();
	
	public RegisterServlet() {
		super();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
        	String name = request.getParameter("name");
        	String username = request.getParameter("username");
        	String password = request.getParameter("password");
        	String password2 = request.getParameter("password2");
        	RequestDispatcher dispatcher = null;
        	response.setContentType("text/plain");
        	response.setCharacterEncoding("UTF-8");
        	boolean usernameExists = UserValidation.usernameExistRegister(username);
        	if(usernameExists) {
        		request.setAttribute("status", "exists");
        		dispatcher = request.getRequestDispatcher("register.jsp");
        		dispatcher.forward(request, response);
        	} else {
	        	boolean isPasswordValid = UserValidation.isPasswordValid(password, password2);
	        	boolean isFieldValid = UserValidation.isFieldValid(password);
	        	if(isFieldValid) {
	        		if(isPasswordValid) {
	        			try {
		        			User user = new User(null, name, username, password);
		        			service.signUp(user);
		        			request.setAttribute("status", "done");
		            		dispatcher = request.getRequestDispatcher("register.jsp");
		            		dispatcher.forward(request, response);
	        			} catch(UserExistException e) {
	        				setResponse(response, HttpServletResponse.SC_CONFLICT, e.getMessage());
	        			}
	        		} else {
	            		request.setAttribute("status", "not");
	            		dispatcher = request.getRequestDispatcher("register.jsp");
	            		dispatcher.forward(request, response);
	        		}
	        	} else {
	        		request.setAttribute("status", "invalid");
	        		dispatcher = request.getRequestDispatcher("register.jsp");
	        		dispatcher.forward(request, response);
	        	}
        	}
        } catch(Exception e) {
        	setResponse(response, HttpServletResponse.SC_CONFLICT, "Something went wrong");
        	e.printStackTrace();
        }
        
	}
	
	private void setResponse(HttpServletResponse response, int codigo, String msg) throws IOException {
        response.setStatus(codigo);
        response.getWriter().write(msg);
    }
	
}
