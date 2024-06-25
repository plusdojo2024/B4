package servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DiseaseListDao;
import dao.MomentumsDao;
import dao.TargetWeightsDao;
import dao.WeightsDao;
import model.Dates;
import model.DiseaseList;
import model.Momentums;
import model.TargetWeights;
import model.Weights;

/**
 * Servlet implementation class ExerciseThinkServlet
 */
@WebServlet("/ExerciseThinkServlet")
public class ExerciseThinkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExerciseThinkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションスコープのデータを取得する
//		request.setAttrubute("yazima_go");
//		HttpSession session = request.getSession();
//		Users user = (Users)session.getAttribute("id");
//		String user_id = user.getUser_id();
		String user_id ="yazima_go";

		//現在体重を取得する
		WeightsDao wDao = new WeightsDao();
		Double weight= wDao.select(user_id);
		request.setAttribute("weight", weight);

		//運動の必要時間
			//ユーザの目標体重を取得する
		TargetWeightsDao twDao = new  TargetWeightsDao();
		double target_weight = (double)twDao.select(user_id);


	    //ユーザの目標期間（一日単位）を取得する　exercise_periodは、例、2026-06-21の形で入っている Date→String→Int
// 	    Date exercise_period = twList.get(0).getExercise_period();
// 	    var dt = new Date();
//         var target_date = exercise_period - dt;
	    TargetWeightsDao periodDao = new  TargetWeightsDao();
        double target_period =(double)periodDao.period(user_id);

  // String をintに変える
//       int num = Integer.parseInt(str);



	    //計算
		double weight_loss= weight - target_weight ;
		double required_calories = weight_loss * 7200;
		double end_calories = required_calories + 2400 - 1300;
		double required_exercise = end_calories / weight;
		double daily_required_exercise = required_exercise / target_period;
		double time_by_exercise = daily_required_exercise / 3.5;

		//1日に必要な運動量 歩きの必要運動量をリクエストスコープに格納する
		request.setAttribute("daily_required_exercise", time_by_exercise);
		request.setAttribute("time_by_exercise", time_by_exercise);



		//病気リストを取得する
		DiseaseListDao dlDao = new DiseaseListDao();
		List<DiseaseList>  dl = dlDao.selectAll();
		//一日の運動量を取得する
		MomentumsDao mDao = new MomentumsDao();
		List<Momentums> mList = mDao.selectAll(user_id);

//		for(Momentums m: mList) {System.out.println(m.getMomentum());
//		}

		Double sum = mDao.calcList(mList);
		request.setAttribute("sum", sum);
		// 病気リストをリクエストスコープに格納する
		request.setAttribute("dlList", dl);

		for(int i=0;i<dl.size();i++) {
			double standard = dl.get(i).getStandard();
				double rank ;
				double lack_exercise = (3.3 - sum) / 3.3;
				double increased_risk = standard * lack_exercise;
				rank = standard	+ increased_risk * 100;

			dl.get(i).setRank(rank);
		}

 		// 病気リストの確率をリクエストスコープに格納する
 		request.setAttribute("dlList", dl);

		//グラフ
 		LocalDate today = LocalDate.now();

		List<Double> yearList = mDao.yearList(mList,2024);
		List<Double> weekList = mDao.weekList(mList);
		List<Double> dayList = mDao.dayList(mList,today);

		request.setAttribute("yearList", yearList);
		request.setAttribute("weekList", weekList);
		request.setAttribute("dayList", dayList);
		request.setAttribute("sum", sum);




		// 運動逆算ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/exerciseThink.jsp");

				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		//セッションスコープのデータを取得する
//		HttpSession session = request.getSession();
//		Users user = (Users)session.getAttribute("id");
//		String user_id = user.getUser_id();

		String user_id ="yazima_go";

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		//String user_id = request.getParameter("user_id");
		// 目標体重
		Double target_weight = Double.valueOf(request.getParameter("target_weight")) ;
		String exercise_period_str = request.getParameter("exercise_period");
		Date exercise_period = Date.valueOf(exercise_period_str);
		String length=request.getParameter("length");

		// 登録処理を行う
		TargetWeightsDao TwDao = new TargetWeightsDao();
		if (TwDao.insert(new TargetWeights(0,user_id,target_weight,exercise_period,true,"",
				""))) {	// 登録成功
			//リクエストスコープ「current」にtarget_saving,lengthを格納する
			//モデルを新規に作るそのモデルには、target_savingとlengthを入れることができる
			Dates lg = new Dates();
			//作ったモデルに実際に上記のデータを入れる
			lg.setLength(length);
			lg.setTarget_weight(target_weight);
			//モデルをリクエストスコープにいれる

			request.setAttribute("current",lg);

			//exerciseThink.jspを開く
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/exerciseThink.jsp");
			dispatcher.forward(request, response);

		}
		else {				// 登録失敗
		}




		// 現在体重を登録する
		Double weight = Double.valueOf(request.getParameter("weight"));
		WeightsDao wDao = new WeightsDao();
		if (wDao.insert(new Weights(0,user_id,weight,"" ,""))) {	// 登録成功
			request.setAttribute("weight",weight);


			//exerciseThink.jspを開く
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/exerciseThink.jsp");
		    dispatcher.forward(request, response);


		}
		else {												// 登録失敗

		}


		// 運動経過時間、運動の種類を受け取る
		int exercise_name =Integer.parseInt(request.getParameter("exercise_pulldown"));

		double laptime = Double.parseDouble(request.getParameter("laptime"));
		// String→double 計算のため

		double time = laptime /1000 / 60 / 60;
		double momentum = time * exercise_name;

		// 運動量を登録する

		MomentumsDao mDao = new MomentumsDao();
		if (mDao.insert(new Momentums(0, user_id, momentum,"",""))) {	// 登録成功
			request.setAttribute("momentum",momentum);


			//exerciseThink.jspを開く
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/exerciseThink.jsp");
		    dispatcher.forward(request, response);


		}
		else {												// 登録失敗

		}

//		// タスク登録または削除を行う
//		TasksDao tDao = new TasksDao();
//		if (request.getParameter("submit").equals("マイタスクに追加")) {
//			int task_id = Integer.parseInt(request.getParameter("task-id"));
//			int time = Integer.parseInt(request.getParameter("time"));
//			tDao.insert(new Tasks(0, user_id, task_id, time, false, "", ""));
//		}
//		else if (request.getParameter("submit").equals("×")){
//			int task_id = Integer.parseInt(request.getParameter("task-id"));
//			tDao.delete(user_id, task_id);
//		}

//		// グラフ プルダウン
//		String graph_menu =request.getParameter("graph_menu");





		// 運動逆算ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/exerciseThink.jsp");

		dispatcher.forward(request, response);





	}


}
