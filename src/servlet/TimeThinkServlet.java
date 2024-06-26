package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PurposeDao;
import dao.TaskTypesDao;
import dao.TasksDao;
import dao.UsersDao;
import dao.api;
import model.Purpose;
import model.TaskTypes;
import model.Tasks;
import model.Users;

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

		// タスク一覧検索処理を行う
		TasksDao tSerchDao = new TasksDao();
		List<Tasks> Tasks = tSerchDao.select(new Tasks(0,user_id,0,"", 0, false, "", ""));
		request.setAttribute("myTask", Tasks);

		// タスク種類検索処理を行う
		TaskTypesDao ttSerchDao = new TaskTypesDao();
		List<TaskTypes> TaskTypes = ttSerchDao.select(new TaskTypes(0,"", "", ""));
		request.setAttribute("taskTypes", TaskTypes);

		// 住所検索処理を行う
		UsersDao uSerchDao = new UsersDao();
		String address = uSerchDao.selectAdress(new Users(0,user_id,"","", "",0,"", ""));
		request.setAttribute("address", address);

		//目的検索処理
		PurposeDao purDao = new PurposeDao();
		List<String> purpose = purDao.select(user_id);
		request.setAttribute("purpose", purpose);

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
		String user_id = "yazima_go";

		// タスク登録または削除を行う
		TasksDao tDao = new TasksDao();
		if (request.getParameter("submit").equals("マイタスクに追加")) {
			int task_id = Integer.parseInt(request.getParameter("task-id"));
			int time = Integer.parseInt(request.getParameter("time"));
			tDao.insert(new Tasks(0, user_id, task_id, time, false, "", ""));
		}
		else if (request.getParameter("submit").equals("×")){
			int task_id = Integer.parseInt(request.getParameter("task-id"));
			tDao.delete(user_id, task_id);
		}

		//  タスク種類登録または削除を行う
		TaskTypesDao ttDao = new TaskTypesDao();
		if (request.getParameter("submit").equals("タスク追加")){
			String task = request.getParameter("task-name");
			ttDao.insert(new TaskTypes(0,  task, "", ""));
		}
		else if (request.getParameter("submit").equals("タスク削除")){
			int task_id = Integer.parseInt(request.getParameter("task-id"));
			ttDao.delete(task_id);
		}

		//住所更新
		UsersDao uDao = new UsersDao();
		if (request.getParameter("submit").equals("変更")){
			String address = request.getParameter("address");
			uDao.updateAddress(new Users(0,user_id,"","", address,0,"", ""));
		}

		String nowAddress = request.getParameter("now-address");
		String destination = request.getParameter("destination");
		//目的更新
		if (request.getParameter("submit").equals("検索")){
			PurposeDao purDao = new PurposeDao();
			purDao.insert(new Purpose(0,user_id,nowAddress,destination,"", ""));
		}

		//逆算
		//目的検索処理
		PurposeDao pSerchDao = new PurposeDao();
		List<String> purpose = pSerchDao.select(user_id);
		request.setAttribute("purpose", purpose);
			api api = new api();
			int time = api.naviApi(api.latApi(nowAddress),api.latApi(destination));
			System.out.println("時間" +time);


			String arrival = request.getParameter("arrival");
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			try {
				Date arrivalDate = sdf.parse(arrival);
				Calendar arrivalCale = Calendar.getInstance();
				arrivalCale.setTime(arrivalDate);
				System.out.println("到着時間"+sdf.format(arrivalCale.getTime()));

				//Date型の持つ時間のn分前を表示(日時の加算)
				Calendar goOut =  Calendar.getInstance();
				goOut.setTime(arrivalDate);
				goOut.add(Calendar.MINUTE, -time);
				System.out.println("家出る時間" +goOut.getTime());

				//Task時間を減らす
				TasksDao tTimeDao = new TasksDao();
				List<Integer> tTime = tTimeDao.selectTime(new Tasks(0,user_id,0,"", 0, false, "", ""));
				int sumTime = 0;
				//ここから減らす処理
				for(int i = 0 ; i < tTime.size() ; i++) {
					sumTime += tTime.get(i);
				}
				System.out.println("sumTime" +sumTime);
				Calendar wakeUp =  Calendar.getInstance();
				wakeUp.setTime(goOut.getTime());
				wakeUp.add(Calendar.MINUTE, -sumTime);
				System.out.println("起床時間" +wakeUp.getTime());

				Calendar sleep =  Calendar.getInstance();
				sleep.setTime(wakeUp.getTime());
				sleep.add(Calendar.MINUTE, -(60*7));
				System.out.println("睡眠時間" +sleep.getTime());

				String goOutTime = sdf.format(goOut.getTime());
				request.setAttribute("goOut", goOutTime);
				String wakeUpTime = sdf.format(wakeUp.getTime());
				request.setAttribute("wakeUp", wakeUpTime);
				String sleepTime = sdf.format(sleep.getTime());
				request.setAttribute("sleep", sleepTime);

				 } catch (ParseException e) {
	            e.printStackTrace();
				 }

	// タスク一覧検索処理を行う
	TasksDao tSerchDao = new TasksDao();
	List<Tasks> Tasks = tSerchDao.select(new Tasks(0,user_id,0,"", 0, false, "", ""));
	request.setAttribute("myTask", Tasks);

	//タスク種類 検索処理を行う
	TaskTypesDao ttSerchDao = new TaskTypesDao();
	List<TaskTypes> TaskTypes = ttSerchDao.select(new TaskTypes(0,"", "", ""));
	request.setAttribute("taskTypes", TaskTypes);

	// 住所検索処理を行う
	UsersDao uSerchDao = new UsersDao();
	String address = uSerchDao.selectAdress(new Users(0,user_id,"","", "",0,"", ""));
	request.setAttribute("address", address);



	// 時間逆算ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/timeThink.jsp");
		dispatcher.forward(request, response);

	//リダイレクト
//	response.sendRedirect("/B4/TimeThinkServlet");
//	return;
}

}

