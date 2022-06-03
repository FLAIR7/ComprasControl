package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entities.User;
import model.validation.UserValidation;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
		
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
        	boolean isPasswordValid = UserValidation.isPasswordValid(password, password2);
        	boolean isFieldValid = UserValidation.isFieldValid(password);
        	System.out.println("senha: " + isPasswordValid + ", Field: " + isFieldValid);
        	if(isFieldValid) {
        		if(isPasswordValid) {
        			User user = new User(null, name, username, password);
        		} else {
        			setResponse(response, HttpServletResponse.SC_BAD_REQUEST, "As senhas não correspondem");
        		}
        	}
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
        
	}
	
	private void setResponse(HttpServletResponse response, int codigo, String msg) throws IOException {
        response.setStatus(codigo);
        response.getWriter().write(msg);
    }
	
}
