package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TargetSavingDao;
import model.TargetSavings;

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
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String user_id = request.getParameter("user_id");
				Double target_saving = Double.valueOf(request.getParameter("target_saving")) ;
				String saving_period_str = request.getParameter("saving_period");
				Date saving_period = Date.valueOf(saving_period_str);

				// 登録処理を行う
				TargetSavingDao TSDao = new TargetSavingDao();
				if (TSDao.insert(new TargetSavings(0,user_id,target_saving,saving_period,true,"",
						""))) {	// 登録成功
				}
				else {												// 登録失敗
				}
	}

}
