package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
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
import model.DiseaseList;
import model.Momentums;
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
		Double daily_required_exercise = required_exercise / target_period;
		Double time_by_exercise = daily_required_exercise / 3.5 * 60;

		daily_required_exercise = ((double)Math.round(daily_required_exercise * 10))/10;
		time_by_exercise = ((double)Math.round(time_by_exercise * 10))/10;

		//1日に必要な運動量 歩きの必要運動量をリクエストスコープに格納する
		request.setAttribute("daily_required_exercise", daily_required_exercise);
		request.setAttribute("time_by_exercise", time_by_exercise);

// System.out.println(target_period);
// System.out.println(weight_loss);
// System.out.println(required_calories);
// System.out.println(required_exercise);
// System.out.println(time_by_exercise);



		//病気リストを取得する
		DiseaseListDao dlDao = new DiseaseListDao();
		List<DiseaseList>  dl = dlDao.selectAll();
		//一日の運動量を取得する
		MomentumsDao mDao = new MomentumsDao();
		List<Momentums> mList = mDao.selectAll(user_id);

//		for(Momentums m: mList) {System.out.println(m.getMomentum());
//		}

		Double sum = mDao.calcList(mList);
		sum = ((double)Math.round(sum * 10))/10;
		request.setAttribute("sum", sum);
		// 病気リストをリクエストスコープに格納する
		request.setAttribute("dlList", dl);
		DiseaseListDao dDao = new DiseaseListDao();
		List<Double> dis = dDao.select();

		List<Double> rank=new ArrayList<Double>();
		for(int i=0;i<dis.size();i++) {
			double standard = dis.get(i);

				double lack_exercise = (3.3 - sum) / 3.3;
				double increased_risk = standard * lack_exercise;
				double risk = (standard	+ increased_risk) * 100;
				risk = ((double)Math.round(risk * 10))/10;
			rank.add(risk);
		}

 		// 病気リストの確率をリクエストスコープに格納する
 		request.setAttribute("rank", rank);

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
//




		// 登録処理を行う
//		TargetWeightsDao TwDao = new TargetWeightsDao();
//		if (request.getParameter("submit").equals("設定")){
//		Double target_weight = Double.valueOf(request.getParameter("target_weight")) ;
//		int se = Integer.parseInt(request.getParameter("target"));
//		LocalDate today = LocalDate.now();
//		LocalDate finalDay = today.plusDays(se);
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String dateString = finalDay.format(formatter);

//		String exercise_period_str = request.getParameter("exercise_period");
//		Date exercise_period = Date.valueOf(exercise_period_str);
//		String length=request.getParameter("length");


//		if (TwDao.insert(new TargetWeights(0,user_id,target_weight,dateString,true,"",
//				""))) {	// 登録成功
//			//リクエストスコープ「current」にtarget_saving,lengthを格納する
//			//モデルを新規に作るそのモデルには、target_savingとlengthを入れることができる
//			Dates lg = new Dates();
//			//作ったモデルに実際に上記のデータを入れる
//			lg.setLength(length);
//			lg.setTarget_weight(target_weight);
//			//モデルをリクエストスコープにいれる
//
//			request.setAttribute("current",lg);
//
//
//
//
//			//exerciseThink.jspを開く
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/exerciseThink.jsp");
//			dispatcher.forward(request, response);
//
//		}
//		else {				// 登録失敗
//		}
//		}



		// 現在体重を登録する
		WeightsDao wDao = new WeightsDao();

		MomentumsDao mDao = new MomentumsDao();

		if (request.getParameter("submit").equals("変更")){
			String weight_s = request.getParameter("target_weight");
			double weight = Double.parseDouble(weight_s);
			wDao.insert(new Weights(0,user_id,weight,"" ,""));



		// 運動量を登録する


		}else if (request.getParameter("submit").equals("登録")){

			// 運動経過時間、運動の種類を受け取る
			String excise_value=request.getParameter("exercise_pulldown");
			double exercise_name =Double.parseDouble(excise_value);

			double laptime = Double.parseDouble(request.getParameter("laptime"));
			// String→double 計算のため

			double time = laptime /1000 / 60 / 60;
			double momentum = time * exercise_name;

			if (mDao.insert(new Momentums(0, user_id, momentum,"",""))) {	// 登録成功
//			request.setAttribute("momentum",momentum);


response.sendRedirect("/B4/ExerciseThinkServlet");
return;

			}
			else {												// 登録失敗

			}
		}



//		// グラフ プルダウン
//		String graph_menu =request.getParameter("graph_menu");






		response.sendRedirect("/B4/ExerciseThinkServlet");
		return;



	}


}
