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

@WebServlet("/samServlet")
@MultipartConfig(
	    location = "C://pleiades//workspace//simpleBC//WebContent//img",
	    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	    maxFileSize = 1024 * 1024 * 10,      // 10MB
	    maxRequestSize = 1024 * 1024 * 50    // 50MB
	)   // 50MB


public class FileUploadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/b.jsp");
		dispatcher.forward(request, response);
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // アップロードされたファイルを取得
        Part filePart = request.getPart("imageFile");

        // アップロードされたファイル名を取得
        String fileName = getSubmittedFileName(filePart);

        // アップロード先のディレクトリを設定（適宜変更する）
        String uploadDir = "/pleiades/workspace/meikan2/WebContent/img/";  // 保存先のディレクトリを指定

        // 保存先のディレクトリが存在しない場合は作成
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // ファイルのフルパス
        String filePath = uploadDir + fileName;
        String fileFullPath = "/simpleBC/img/"+fileName;
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

        // 画像の表示ページにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/b.jsp");
        dispatcher.forward(request, response);
    }

    // Partからファイル名を取得するヘルパーメソッド
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
