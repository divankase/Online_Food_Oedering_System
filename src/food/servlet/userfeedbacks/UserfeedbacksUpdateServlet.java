package food.servlet.userfeedbacks;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.dao.UserfeedbacksDao;
import food.model.Userfeedbacks;


@WebServlet("/updateuserfeedbacks")
public class UserfeedbacksUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserfeedbacksDao UserfeedbacksDao;

	public void init() {
		UserfeedbacksDao = new UserfeedbacksDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		int id = Integer.parseInt(request.getParameter("id"));
		String customername = request.getParameter("customername");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
	

		Userfeedbacks Userfeedbacks = new Userfeedbacks(id,customername, email, subject, message);
		try {
			UserfeedbacksDao.updateFeedback(Userfeedbacks);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("listuserfeedbacks");
		
	}

	

}