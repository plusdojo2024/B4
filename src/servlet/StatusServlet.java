package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.StatusDao;
import model.Status;

/**
 * Servlet implementation class StatusServlet
 */
@WebServlet("/StatusServlet")
@MultipartConfig(
	    location = "C://pleiades//workspace//B4//WebContent//img",
	    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	    maxFileSize = 1024 * 1024 * 10,      // 10MB
	    maxRequestSize = 1024 * 1024 * 50    // 50MB
	)   // 50MB

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

				request.setCharacterEncoding("UTF-8");


				String user_id = "1";




		//user_statusテーブルからuser_idをもとにしてデータを取得する
		//このために必要なStatusDAOの中にselect文を実行するメソッドを書く。
		//(select(user_id)メソッドを作る。
		//戻ってくるのは、user_statusに関連するデータ一式なので、それらをいれる
		//JavaBeansをstatus.java内に作る。
				Status status = new Status();
				StatusDao sDao = new StatusDao();

				status = sDao.select(user_id);


		//返ってきた、statusモデルをリクエストスコープ「status」に格納する。
				request.setAttribute("status", status);

		// status.jspを表示
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/status.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Part filePart = request.getPart("imageFile");

	        // アップロードされたファイル名を取得
	        String fileName = getSubmittedFileName(filePart);

	        // アップロード先のディレクトリを設定（適宜変更する）
	        String uploadDir = "/pleiades/workspace/B4/WebContent/img/";  // 保存先のディレクトリを指定

	        // 保存先のディレクトリが存在しない場合は作成
	        File dir = new File(uploadDir);
	        if (!dir.exists()) {
	            dir.mkdirs();
	        }

	        // ファイルのフルパス
	        String filePath = uploadDir + fileName;
	        String fileFullPath = "/B4/img/"+fileName;
	        System.out.println(filePath);
	        // ファイルを保存
	        try (InputStream input = filePart.getInputStream();
	             OutputStream output = new FileOutputStream(filePath)) {
	            byte[] buffer = new byte[1024];
	            int length;
	            while ((length = input.read(buffer)) > 0) {
	                output.write(buffer, 0, length);
	            }
	        }

	        // 保存したファイル名をリクエストスコープに設定
	        request.setAttribute("filePath", fileFullPath);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/status.jsp");
	        dispatcher.forward(request, response);
	}
	private String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);
            }
        }
        return null;
    }
}
