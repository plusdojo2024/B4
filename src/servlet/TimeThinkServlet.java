package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskTypesDao;
import dao.TasksDao;
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

		// リクエストパラメータを取得する
//		request.setCharacterEncoding("UTF-8");
//		HttpSession session = request.getSession();
//		Users user = (Users)session.getAttribute("id");
//		String user_id = user.getUser_id();
		String user_id = "yazima_go";

		// 検索処理を行う
		TasksDao tDao = new TasksDao();
		List<Tasks> Tasks = tDao.select(new Tasks(0,user_id,0,"", 0, false, "", ""));
		request.setAttribute("myTask", Tasks);

		// 検索処理を行う
		TaskTypesDao ttDao = new TaskTypesDao();
		List<TaskTypes> TaskTypes = ttDao.select(new TaskTypes(0,"", "", ""));
		request.setAttribute("taskTypes", TaskTypes);


		// 時間逆算ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/timeThink.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("B4/LoginServlet");
//			return;
//		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
//		HttpSession session = request.getSession();
//		Users user = (Users)session.getAttribute("id");
//		String user_id = user.getUser_id();

		int task_id = Integer.parseInt(request.getParameter("task-id"));
		int time = Integer.parseInt(request.getParameter("time"));
		String task = request.getParameter("task-name");

		String user_id = "yazima_go";

		// 登録または削除を行う
		TasksDao tDao = new TasksDao();
		if (request.getParameter("submit").equals("マイタスクに追加")) {
			tDao.insert(new Tasks(0, user_id, task_id, time, false, "", ""));
		}
		else if (request.getParameter("submit").equals("×")){
			tDao.delete(user_id, task_id);
		}

		// 登録または削除を行う
		TaskTypesDao ttDao = new TaskTypesDao();
		if (request.getParameter("submit").equals("タスク追加")){
			ttDao.insert(new TaskTypes(0,  task, "", ""));
		}
		else if (request.getParameter("submit").equals("タスク削除")){
			ttDao.delete(task_id);
		}

			// 時間逆算ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/timeThink.jsp");
		dispatcher.forward(request, response);
		}



	}
