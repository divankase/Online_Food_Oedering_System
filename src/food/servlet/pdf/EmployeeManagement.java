package food.servlet.pdf;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.dao.EmployeemanagementDao;
@WebServlet("/employeemanagementpdf")
public class EmployeeManagement extends HttpServlet {
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("ExportemployeemanagementPdf.jsp");
		dispatcher.forward(request, response);
	}

	
}