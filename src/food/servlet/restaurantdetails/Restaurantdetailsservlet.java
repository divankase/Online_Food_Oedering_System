package food.servlet.restaurantdetails;
//package event.servlet.catering;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import hotel.dao.UserDAO;
//import hotel.model.Caterings;
//
//@WebServlet("/m")
//public class Cateringservlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private UserDAO userDAO;
//
//	public void init() {
//		userDAO = new UserDAO();
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String action = request.getServletPath();
//
//		try {
//			switch (action) {
//			case "/newcatering":
//				showNewForm(request, response);
//				break;
//			case "/insertcatering":
//				insertUser(request, response);
//				break;
//			case "/deletecatering":
//				deleteUser(request, response);
//				break;
//			case "/editcatering":
//				showEditForm(request, response);
//				break;
//			case "/updatecatering":
//				updateUser(request, response);
//				break;
//			case "/listcatering":
//				listUser(request, response);
//				break;
//			}
//		} catch (SQLException ex) {
//			throw new ServletException(ex);
//		}
//	}
//
//	private void listUser(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, IOException, ServletException {
//		List<Caterings> listCaterings = userDAO.selectAllCaterings();
//		// System.out.print(listUser);
//		request.setAttribute("listCaterings", listCaterings);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("cateringlist.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher("Newcatering.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, ServletException, IOException {
//		int id = Integer.parseInt(request.getParameter("id"));
//		Caterings catering = userDAO.selectCatering(id);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("Newcatering.jsp");
//		request.setAttribute("user", catering);
//		dispatcher.forward(request, response);
//
//	}
//
//private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//
//	String cateringmenu = request.getParameter("cateringmenu");
//
//	String cateringmenudetails = request.getParameter("cateringmenudetails");
//	String workingdays = request.getParameter("workingdays");
//	String location = request.getParameter("location");
//
//	caterings catering = new caterings(cateringmenu, cateringmenudetails, workingdays, location);
//	userDAO.insertcaterings(catering);
//	response.sendRedirect("listcatering");
//}
//
//private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//	int id = Integer.parseInt(request.getParameter("id"));
//
//	String cateringmenu = request.getParameter("cateringmenu");
//
//	String cateringmenudetails = request.getParameter("cateringmenudetails");
//	String workingdays = request.getParameter("workingdays");
//	String location = request.getParameter("location");
//
//	caterings catering = new caterings(id,cateringmenu, cateringmenudetails, workingdays, location);
//	userDAO.updatecaterings(catering);
//	response.sendRedirect("listcatering");
//}
//
//private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//	int id = Integer.parseInt(request.getParameter("id"));
//	userDAO.deletecatering(id);
//	response.sendRedirect("listcatering");
//
//}
//
//}