/*package event.servlet.entertainmentbooking;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.dao.EntertainmentsBookingDao;





@WebServlet("/newUserEntertainmentBook")
public class UserAddEntertainmentBookingServlet extends HttpServlet {
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
		Cookie c1[] = request.getCookies();

		System.out.println("Cookies get for Entertainment Booking ");
		System.out.println(c1[0].getValue());
		String loginuser = c1[0].getValue();
		System.out.println("Request");
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("EntertainmentAddBookUser.jsp");
		request.setAttribute("user", loginuser);
		dispatcher.forward(request, response);
	}

	
}
*/