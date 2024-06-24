package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DiseaseListDao;
import dao.WeightsDao;
import model.DiseaseList;
import model.Users;

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
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("id");
		String user_id = user.getUser_id();

		//現在体重を取得する
		WeightsDao wDao = new WeightsDao();
		Double weight= wDao.select(user_id);
		request.setAttribute("weight", weight);



		//病気リストを取得する
		DiseaseListDao dlDao = new DiseaseListDao();
		List<DiseaseList>  dl = dlDao.selectAll();
		//一日の運動量を取得する
//		Momentums mDao = new Momentums();
//		double daily_momentum =mDao.

		// 病気リストをリクエストスコープに格納する
		request.setAttribute("dlList", dl);
//
//		for(int i=0;i<dl.size();i++) {
//			double standard = dl.get(i).getStandard();
//				double rank ;
//				double lack_exercise = (3.3 - 1日の実際の運動量) / 3.3;
//				double increased_risk = standard * lack_exercise;
//				rank = standard	+ increased_risk * 100;
//
//			dl.get(i).setRank(rank);
//		}
//
 		// 病気リストの確率をリクエストスコープに格納する
 		request.setAttribute("dlList", dl);


		// 運動逆算ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/exerciseThink.jsp");

				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションスコープのデータを取得する
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("id");
		String user_id = user.getUser_id();

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		//String user_id = request.getParameter("user_id");
		// 目標体重
		Double target_weight = Double.valueOf(request.getParameter("target_weight")) ;
		String exercise_period_str = request.getParameter("exercise_period");
		Date exercise_period = Date.valueOf(exercise_period_str);
		String length=request.getParameter("length");

//		// 登録処理を行う
////		TargetWeightsDao TWDao = new TargetWeightsDao();
////		if (TWDao.insert(new TargetWeights(0,user_id,target_weight,exercise_period,true,"",
//				""))) {	// 登録成功
//			//リクエストスコープ「current」にtarget_saving,lengthを格納する
//			//モデルを新規に作るそのモデルには、target_savingとlengthを入れることができる
//			Length lg = new Length();
//			//作ったモデルに実際に上記のデータを入れる
//			lg.setLength(length);
//			lg.setTarget_savings(target_weight);
//			//モデルをリクエストスコープにいれる
//
//			request.setAttribute("current",lg);
//		}
//		else {				// 登録失敗
//		}
//
//
//		// 現在体重
//		Double weight = Double.valueOf(request.getParameter("weight"));
//		WeightDao wDao = new WeightDAO();
//		if (wDao.insert(new kg(weight))) {	// 登録成功
//			request.setAttribute("",
//
//
//
//
//		}
//		else {												// 登録失敗
//			request.setAttribute("result",
//			new Result("登録失敗！", "レコードを登録できませんでした。", "/simpleBC/MenuServlet"));
//		}
//
//
		// 運動経過時間、運動の種類
		 //elapsedTime
		String exercise_name =request.getParameter("exercise_pulldown");
		String laptime = request.getParameter("laptime");
		// グラフ プルダウン
		String graph_menu =request.getParameter("graph_menu");





		// 運動逆算ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/exerciseThink.jsp");

		dispatcher.forward(request, response);





	}


}
