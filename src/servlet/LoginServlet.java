package servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDao;
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

        if (lid != null && !lid.isEmpty()) {
        	Users us = new Users(0,lid, lpw,"","",0,LocalDateTime.now(),LocalDateTime.now());
        	if (iDao.isLoginOK(us)) {	// ログイン成功
    			// セッションスコープにIDを格納する
    			HttpSession session = request.getSession();
    			session.setAttribute("id", us);

    			// メニューサーブレットにリダイレクトする
    			response.sendRedirect("/simpleBC/StatusServlet");
    		}
    		else {									// ログイン失敗
    			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
    			//request.setAttribute("result",
    			//new Result("ログイン失敗！", "IDまたはPWに間違いがあります。", "/simpleBC/HomeServlet"));

    			// 結果ページにフォワードする
    			//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
    			//dispatcher.forward(request, response);

    		}
        }

        if(sid != null && !sid.isEmpty()) {
        	Users us = new Users(0,sid,spw,"","",0,LocalDateTime.now(),LocalDateTime.now());
        if(!spw.equals(spw2)) {
			//request.setAttribute("result",
			//new Result("新規登録に失敗しました", "IDが重複しています。または、パスワードが同一ではありません。", "/simpleBC/LoginServlet"));


		}else if (iDao.sign(us)) {	// ログイン成功
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			//request.setAttribute("result",
			//new Result("新規登録に成功しました", "ログインページに戻ってください", "/simpleBC/LoginServlet"));

//			// 結果ページにフォワードする
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
//			dispatcher.forward(request, response);
		}
		else {									// ログイン失敗
			//request.setAttribute("result",
			//new Result("新規登録に失敗しました", "IDが重複しています。または、パスワードが同一ではありません。", "/simpleBC/LoginServlet"));

//			// 結果ページにフォワードする
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
//			dispatcher.forward(request, response);
		}
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
        }
	}
}
