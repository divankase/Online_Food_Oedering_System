package food.servlet.restaurantdetails;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.dao.RestaurantdetailsDao;
import food.model.Restaurantdetails;


@WebServlet("/editrestaurantdetails")
public class RestaurantdetailsEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantdetailsDao RestaurantdetailsDao;

	public void init() {
		RestaurantdetailsDao = new RestaurantdetailsDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		int id = Integer.parseInt(request.getParameter("id"));
		Restaurantdetails Restaurantdetails = RestaurantdetailsDao.selectRestaurantdetails(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Newrestaurant.jsp");
		request.setAttribute("user", Restaurantdetails);
		dispatcher.forward(request, response);
		
	}

	

}