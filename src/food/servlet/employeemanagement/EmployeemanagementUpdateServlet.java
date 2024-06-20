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


@WebServlet("/updateemployeemanagement")
public class EmployeemanagementUpdateServlet extends HttpServlet {
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
		int id = Integer.parseInt(request.getParameter("id"));
		String employeename = request.getParameter("employeename");
		String employeephone = request.getParameter("employeephone");
		String jobrole = request.getParameter("jobrole");
		String email = request.getParameter("email");
		String filename = request.getParameter("filename");
		String path = request.getParameter("path");
	

		EmployeeManagement Employeemanagement = new EmployeeManagement(id,employeename, employeephone, jobrole, email, filename, path);
		try {
			EmployeemanagementDao.updateEmployee(Employeemanagement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listemployeemanagement");
		
	}

	

}