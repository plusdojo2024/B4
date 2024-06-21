package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TargetWeightsDao;
import model.TargetWeights;
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

		// 運動逆算ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/exerciseThink.jsp");

				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		//String user_id = request.getParameter("user_id");
		// 目標体重
		Double target_weight = Double.valueOf(request.getParameter("target_weight")) ;
		String exercise_period_str = request.getParameter("exercise_period");
		Date exercise_period = Date.valueOf(exercise_period_str);
		// 現在体重
	//	Double weight = Double.valueOf(request.getParameter("weight"));
		// 運動経過時間、運動の種類
		 //elapsedTime
		//String exercise_name =request.getParameter("exercise_pulldown");
		// グラフ プルダウン
		//String graph_menu =request.getParameter("graph_menu");
		// 病気リスト


		//セッションスコープのデータを取得する
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("id");
		String user_id = user.getUser_id();

		// 登録処理を行う
		TargetWeightsDao TWDao = new TargetWeightsDao();
		if (TWDao.insert(new TargetWeights(0,user_id,target_weight,exercise_period,true,"",
				""))) {	// 登録成功
		}
		else {				// 登録失敗
		}



		// 運動逆算ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/exerciseThink.jsp");

		dispatcher.forward(request, response);





	}


}
