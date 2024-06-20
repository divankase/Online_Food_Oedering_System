/*package event.servlet.venuebooking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.dao.VenuesBookingDao;
import event.model.VenueBooking;




@WebServlet("/insertVenueBook")
public class VenueBookingAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VenuesBookingDao VenuesBookingDao;
	
	public void init() {
		VenuesBookingDao = new VenuesBookingDao();
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
		String additionalservices = (request.getParameter("additionalservices"));
		int noofguests = Integer.parseInt(request.getParameter("noofguests"));
		int advancedpayment = Integer.parseInt(request.getParameter("advancedpayment"));
		
		VenueBooking ven = new VenueBooking( user, nic, mobile,email,bookingdate,additionalservices,noofguests,advancedpayment);
		try {
			VenuesBookingDao.insertVenuesBook(ven);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listVenueBook");
	
	}

	

}
*/