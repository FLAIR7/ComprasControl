package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserDAO;
import model.entities.Product;
import model.entities.User;
import model.service.ProductService;

@WebServlet("/list")
public class ListServlet extends HttpServlet{
	
	private ProductService service = null;
	private User user = null;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.user = (User) request.getSession().getAttribute("user");	
			startService(request, response);
			request.getSession().setAttribute("products", service.findAll());
			String action = request.getParameter("action");
			if(action != null) {
				if(action.equals("delete")) {
					Long id =  Long.parseLong(request.getParameter("idProduct"));
					service.deleteById(id);
				}
			}
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.user = (User) request.getSession().getAttribute("user");
			String action = request.getParameter("action");
			if(action != null) {
				if(action.equals("update")) {
					String id = request.getParameter("idProduct");
					String name = request.getParameter("name");
					Double price = Double.parseDouble(request.getParameter("price"));
					String purchase = request.getParameter("purchase");
					startService(request, response);
					Product p = new Product(!id.isEmpty() ? Long.parseLong(id) : null, name, price, 
							purchase == null || purchase.equals("false") ? false : true);
					if(p.getProductId() == null) {
						service.save(p);
					} else {
						service.update(p);
					}
				}
			}
		} catch(RuntimeException e) {
			e.printStackTrace();
		}
	}
	
    private void startService(HttpServletRequest request, HttpServletResponse response) {	
    	HttpServletRequest req = (HttpServletRequest) request;
    	HttpSession session = req.getSession();
    	this.user = (User) session.getAttribute("user");
    	service = new ProductService(user);
    }
}
