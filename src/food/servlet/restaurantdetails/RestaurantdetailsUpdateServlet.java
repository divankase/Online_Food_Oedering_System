/*package food.servlet.restaurantdetails;

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

/*
@WebServlet("/updaterestaurantdetails")
public class RestaurantdetailsUpdateServlet extends HttpServlet {
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
		String restaurantname = request.getParameter("restaurantname");
		String phone = request.getParameter("phone");
		String workingdays = request.getParameter("workingdays");
		String location = request.getParameter("location");
		

		Restaurantdetails Restaurantdetails = new Restaurantdetails(id,restaurantname, phone, workingdays, location);
		try {
			RestaurantdetailsDao.updateRestaurantdetails(Restaurantdetails);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listrestaurantdetails");
		
	}

	

}*/
package food.servlet.restaurantdetails;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.dao.RestaurantdetailsDao;
import food.model.Restaurantdetails;

@WebServlet("/updaterestaurantdetails")
public class RestaurantdetailsUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RestaurantdetailsDao restaurantdetailsDao;

    public void init() {
        restaurantdetailsDao = new RestaurantdetailsDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String action = request.getServletPath();
        int id = Integer.parseInt(request.getParameter("id"));
        String restaurantname = request.getParameter("restaurantname");
        String phone = request.getParameter("phone");
        String workingdays = request.getParameter("workingdays");
        String location = request.getParameter("location");
        String filename = request.getParameter("filename");
        String path = request.getParameter("path");

        Restaurantdetails restaurantdetails = new Restaurantdetails(id, restaurantname, phone, workingdays, location, filename, path);
        try {
            restaurantdetailsDao.updateRestaurantdetails(restaurantdetails);
        } catch (SQLException e) {
        	// TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.sendRedirect("listrestaurantdetails");
    }
}