/*package event.servlet.photographybooking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.dao.PhotographyBookingDao;
import event.model.PhotographyBooking;


@WebServlet("/listUserPhotographyBook")
public class UserPhotographyBookingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhotographyBookingDao PhotographyBookingDao;
	
	public void init() {
		PhotographyBookingDao = new PhotographyBookingDao();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	Cookie c1[] = request.getCookies();
		
		System.out.println("Cookies get");
		System.out.println(c1[0].getValue());
		String loginuser=c1[0].getValue();
		System.out.println("Request");	
		
		String action = request.getServletPath();
		List<PhotographyBooking> listPhotographyBooking = PhotographyBookingDao.selectAllPhotographyBookingsByUser(loginuser);
		//System.out.print(listUser);
		request.setAttribute("listPhotographyBooking", listPhotographyBooking);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserPhotographyBookList.jsp");
		dispatcher.forward(request, response);
		
	}

	

}
*/