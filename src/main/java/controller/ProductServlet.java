package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entities.Product;
import model.entities.User;
import model.service.ProductService;

@WebServlet("/products")
public class ProductServlet extends HttpServlet{
	
	private ProductService service = null;
	private User user = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			startService(request, response);
			request.getSession().setAttribute("products", service.findAll());
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("products.jsp").forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("products.jsp").forward(request, response);
	}
	
    private void startService(HttpServletRequest request, HttpServletResponse response) {	
    	HttpServletRequest req = (HttpServletRequest) request;
    	HttpSession session = req.getSession();
    	this.user = (User) session.getAttribute("user");
    	service = new ProductService(user);
    }
}
