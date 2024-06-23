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

import dao.AmountUsedsDao;
import dao.IncomesDao;
import dao.TargetSavingDao;
import model.AmountUseds;
import model.Incomes;
import model.Length;
import model.TargetSavings;
import model.Users;
/**
 * Servlet implementation class MoneyThinkServlet
 */
@WebServlet("/MoneyThinkServlet")
public class MoneyThinkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// 予算逆算ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/moneyThink.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 金額と期間のリクエストパラメータを取得する
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		Users user = (Users)session.getAttribute("id");
		String user_id = user.getUser_id();
		Double target_saving = Double.valueOf(request.getParameter("target_saving")) ;
		String saving_period_str = request.getParameter("saving_period");
		Date saving_period = Date.valueOf(saving_period_str);
		String length=request.getParameter("length");
		//TargetSavings TS = new TargetSavings()
		// 登録処理を行う
		TargetSavingDao TSDao = new TargetSavingDao();
		if (TSDao.insert(new TargetSavings(0,user_id,target_saving,saving_period,true,"",
				""))) {	// 登録成功
			//リクエストスコープ「current」にtarget_saving,lengthを格納する
			//モデルを新規に作るそのモデルには、target_savingとlengthを入れることができる
			Length lg = new Length();
			//作ったモデルに実際に上記のデータを入れる
			lg.setLength(length);
			lg.setTarget_savings(target_saving);
			//モデルをリクエストスコープにいれる

			request.setAttribute("current",lg);



			//moneyThink.jspを開く
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/moneyThink.jsp");
			dispatcher.forward(request, response);


		}
		else {												// 登録失敗
		}

		// リクエストパラメータを取得する
		HttpSession session2 = request.getSession();
		request.setCharacterEncoding("UTF-8");
		Users user2 = (Users)session2.getAttribute("id");
		String user_id2 = user2.getUser_id();
		int income = Integer.parseInt(request.getParameter("income"));

		IncomesDao IDao = new IncomesDao();
		if (IDao.insert(new Incomes(0,user_id2,income,"",
				""))) {	// 登録成功
			//モデルをリクエストスコープにいれる

			request.setAttribute("Incomes",income);



			//moneyThink.jspを開く
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/moneyThink.jsp");
			dispatcher.forward(request, response);



		}
		else {												// 登録失敗
		}
		// リクエストパラメータを取得する
		HttpSession session3 = request.getSession();
		request.setCharacterEncoding("UTF-8");
		Users user3 = (Users)session3.getAttribute("id");
		String user_id3 = user3.getUser_id();
		int amount_used = Integer.parseInt(request.getParameter("amount_used"));
		//
		AmountUsedsDao ADao = new AmountUsedsDao();
		if (ADao.insert(new AmountUseds(0,user_id3,amount_used,"",
				""))) {

			//モデルをリクエストスコープにいれる
//これだと、入れられたものを返すだけで、合計を返せていない？
			//request.setAttribute("AmountUseds",amount_used);
//ここで、sumを返せれば解決？
			//AmountUsedsDao dao = new AmountUsedsDao();
			//int sum = dao.sum;
			//request.setAttribute("AmountUsedsDao", sum);

			//moneyThink.jspを開く
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/moneyThink.jsp");
			dispatcher.forward(request, response);

		}}}