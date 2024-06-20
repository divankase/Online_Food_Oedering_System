/*package event.servlet.entertainmentbooking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.dao.EntertainmentsBookingDao;
import event.model.EntertainmentBooking;




@WebServlet("/insertEntertainmentBook")
public class EntertainmentBookingAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntertainmentsBookingDao EntertainmentsBookingDao;
	
	public void init() {
		EntertainmentsBookingDao = new EntertainmentsBookingDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		String user = request.getParameter("User");
		String nic = request.getParameter("nic");
		int mobile = Integer.parseInt(request.getParameter("mobile"));
		String email = request.getParameter("email");
		String bookingdate = (request.getParameter("bookingdate"));
		String additionalneeds = (request.getParameter("additionalneeds"));
		int noofguests = Integer.parseInt(request.getParameter("noofguests"));
		int advancedpayment = Integer.parseInt(request.getParameter("advancedpayment"));
		
		EntertainmentBooking ent = new EntertainmentBooking( user, nic, mobile,email,bookingdate,additionalneeds,noofguests,advancedpayment);
		try {
			EntertainmentsBookingDao.insertEntertainmentsBook(ent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listEntertainmentBook");
	
	}

	

}
*/