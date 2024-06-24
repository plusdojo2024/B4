package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StatusServlet
 */
@WebServlet("/StatusServlet")
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String user_id = '1';


		//user_statusテーブルからuser_idをもとにしてデータを取得する
		//このために必要なStatusDAOの中にselect文を実行するメソッドを書く。
		//(select(user_id)メソッドを作る。
		//戻ってくるのは、user_statusに関連するデータ一式なので、それらをいれる
		//JavaBeansをstatus.java内に作る。


		//返ってきた、statusモデルをリクエストスコープ「status」に格納する。











		// status.jspを表示
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/status.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
