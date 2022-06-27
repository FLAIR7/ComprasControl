package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entities.User;
import model.exceptions.LoginException;
import model.service.UserService;
import model.validation.UserValidation;

@WebServlet("/account")
public class AccountServlet extends HttpServlet{
	
	private UserService service = new UserService();
	
	public AccountServlet() {
		
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("account.jsp").forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			if(action != null) {
				response.setContentType("text/plain");
				response.setCharacterEncoding("UTF-8");
				Long userId = Long.parseLong(request.getParameter("idUser"));
				String name = request.getParameter("name");
				String username = request.getParameter("username");
				if(action.equals("edit")) {
					if(userAlreadyModified(name, username, request)) {
						if(service.update(userId, name, username)) {
							User user = service.findById(userId);
							request.getSession().setAttribute("user", user);
						} else {
							System.out.println("Erro no update");
						}
					} else {
						System.out.println("Usuário já mudado");
						request.setAttribute("status", "changed");
					}
				} else if(action.equals("change-pass")) {
					changePassword(request, response);
				}
			}
		} catch(LoginException e) {
			e.printStackTrace();
		}
	}
	
	public boolean userAlreadyModified(String name, String username, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		try {
			return !(user.getName().equals(name) && user.getUsername().equals(username));
		} catch(NullPointerException e) {
			return true;
		}
	}
	
	private void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String oldPassword = request.getParameter("old");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		if(UserValidation.isPasswordValid(password1, password2)) {
			try {
				User user = (User) request.getSession().getAttribute("user");
				user = service.changePassword(user, oldPassword, password2);
				request.getSession().setAttribute("user", user);
			} catch(LoginException e) {
				e.printStackTrace();
			}
		}
	}
	
}
