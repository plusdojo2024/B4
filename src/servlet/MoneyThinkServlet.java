package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AmountUsedsDao;
import dao.IncomesDao;
import model.AmountUseds;
import model.Incomes;
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

		request.setCharacterEncoding("UTF-8");
		String user_id2 = "yazima_go";
		IncomesDao IDao = new IncomesDao();
		AmountUsedsDao ADao = new AmountUsedsDao();
		if (request.getParameter("submit").equals("登録")) {
			int income = Integer.parseInt(request.getParameter("income"));
			if (IDao.insert(new Incomes(0,user_id2,income,"",
				""))) {	// 登録成功

			request.setAttribute("Incomes",income);
		}
			else { 												// 登録失敗
			}
		}
		if (request.getParameter("submit").equals("追加")) {
			int amount_used = Integer.parseInt(request.getParameter("amount_used"));
		if (ADao.insert(new AmountUseds(0,user_id2,amount_used,"",
				""))) {}}

			//モデルをリクエストスコープにいれる
//これだと、入れられたものを返すだけで、合計を返せていない？
			//request.setAttribute("AmountUseds",amount_used);
//ここで、sumを返せれば解決？

			LocalDate today2 = LocalDate.now();
			List<AmountUseds> al  =ADao.allList();
			int sum = ADao.calcList(al);
			List<Integer> yearList = ADao.yearList(al,2024);
			List<Integer> weekList = ADao.weekList(al);
			List<Integer> dayList = ADao.dayList(al,today2);

			request.setAttribute("yearList", yearList);
			request.setAttribute("weekList", weekList);
			request.setAttribute("dayList", dayList);
			request.setAttribute("sum", sum);

			//moneyThink.jspを開く
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/moneyThink.jsp");
			dispatcher.forward(request, response);

		}}