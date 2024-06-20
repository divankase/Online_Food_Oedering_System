package food.servlet.userfeedbacks;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import food.dao.UserfeedbacksDao;
import food.model.Userfeedbacks;


@WebServlet("/edituserfeedbacks")
public class UserfeedbacksEditServlet extends HttpServlet {
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
		Userfeedbacks Userfeedbacks = UserfeedbacksDao.selectFeedback(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Newuserfeedbacks.jsp");
		request.setAttribute("user", UserfeedbacksDao);
		dispatcher.forward(request, response);
		
	}

	

}