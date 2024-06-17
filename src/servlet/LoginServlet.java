package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDao;
import model.LoginUser;
import model.Users;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String sid = request.getParameter("sid");
		String spw = request.getParameter("spw");
		String spw2 = request.getParameter("spw2");
		String lid = request.getParameter("lid");
		String lpw = request.getParameter("lpw");
		UsersDao iDao = new UsersDao();

        if (sid != null && !sid.isEmpty()) {
        	if (iDao.isLoginOK(new Users(0,lid, lpw,"","","",0,0))) {	// ログイン成功
    			// セッションスコープにIDを格納する
    			HttpSession session = request.getSession();
    			session.setAttribute("id", new LoginUser(id));

    			// メニューサーブレットにリダイレクトする
    			response.sendRedirect("/simpleBC/InHomeServlet");
    		}
    		else {									// ログイン失敗
    			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
    			request.setAttribute("result",
    			new Result("ログイン失敗！", "IDまたはPWに間違いがあります。", "/simpleBC/HomeServlet"));

    			// 結果ページにフォワードする
    			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
    			dispatcher.forward(request, response);
    		}
        }
		// ログイン処理を行う
		if (iDao.isLoginOK(new Users(0,id, pw))) {	// ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("id", new LoginUser(id));

			// メニューサーブレットにリダイレクトする
			response.sendRedirect("/simpleBC/InHomeServlet");
		}
		else {									// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result",
			new Result("ログイン失敗！", "IDまたはPWに間違いがあります。", "/simpleBC/HomeServlet"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		}
	}
}
