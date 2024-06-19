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
        	Users us = new Users(0,lid, lpw,"","",0,"","");
        	if (iDao.isLoginOK(us)) {	// ログイン成功
    			// セッションスコープにIDを格納する
    			HttpSession session = request.getSession();
    			session.setAttribute("id", us);

    			// メニューサーブレットにリダイレクトする
    			response.sendRedirect("/simpleBC/StatusServlet");
    		}
    		else {									// ログイン失敗

    		}
        }
        if(sid != null && !sid.isEmpty()) {
        	Users us = new Users(0,sid,spw,"","",0,"","");
        	if(!spw.equals(spw2)) {//重複

        	}else if (iDao.sign(us)) {	// 登録成功
        		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        		dispatcher.forward(request, response);
        	}else {									// 登録失敗
        		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        		dispatcher.forward(request, response);
        	}
        }
	}
}