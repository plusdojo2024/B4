package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskTypesDAO;
import dao.TasksDAO;
import model.TaskTypes;
import model.Tasks;

/**
 * Servlet implementation class TimeThinkServlet
 */
@WebServlet("/TimeThinkServlet")
public class TimeThinkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("B4/LoginServlet");
//			return;
//		}
		// リクエストパラメータを取得する
//		request.setCharacterEncoding("UTF-8");
//		HttpSession session = request.getSession();
//		Object id = session.getAttribute("user_id");
//		String user_id = (String)id;
		String user_id = "yazima_go";

		// 検索処理を行う
		TasksDAO tDao = new TasksDAO();
		List<Tasks> Task = tDao.select(new Tasks(0,user_id,2, 0, false, "", ""));
		request.setAttribute("task", Task);

		//検索処理
		TaskTypesDAO ttDao = new TaskTypesDAO();
		List<TaskTypes> TaskTypes = ttDao.select(new TaskTypes(0,"","", ""));
		request.setAttribute("taskType", TaskTypes);

		// 時間逆算ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/timeThink.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
