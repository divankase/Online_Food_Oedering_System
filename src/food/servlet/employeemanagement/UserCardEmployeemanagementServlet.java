package food.servlet.employeemanagement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.dao.EmployeemanagementDao;
import food.model.EmployeeManagement;


@WebServlet("/listcardemployeemanagement")
public class UserCardEmployeemanagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeemanagementDao EmployeemanagementDao;

	public void init() {
		EmployeemanagementDao = new EmployeemanagementDao();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		List<EmployeeManagement> listEmployees = EmployeemanagementDao.selectAllEmployees();
		// System.out.print(listUser);
		request.setAttribute("listcardemployeemanagement", listEmployees);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserEmployeementmanagementCardList.jsp");
		dispatcher.forward(request, response);
		
	}

	
}