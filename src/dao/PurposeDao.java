package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Purpose;

public class PurposeDao {
	//検索
	public List<String> select(String user_id) {
		Connection conn = null;
		List<String> purpose = new ArrayList<String>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する
			String sql = "SELECT ARRIVAL,destination FROM PURPOSE WHERE user_id = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			if (user_id != null) {
				pStmt.setString(1, user_id);
		}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				purpose.add(rs.getString("ARRIVAL"));
				purpose.add(rs.getString("DESTINATION"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			purpose = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			purpose = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					purpose = null;
				}
			}
		}

		// 結果を返す
		return purpose;
	}


	// 登録し、成功したらtrueを返す
	public boolean insert(Purpose pro) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			PurposeDao purDao = new PurposeDao();
			List<String> user = purDao.select(pro.getUser_id());

			if(user.get(0) == "" || user.get(0) == null) {
				// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
				String sql = "INSERT INTO PURPOSE VALUES (NULL, ?,?,?, CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (pro.getUser_id() != null && !pro.getUser_id().equals("")) {
					pStmt.setString(1, pro.getUser_id());
				}else {
					pStmt.setString(1, "（未設定）");
				}
				if (pro.getArrival() != null && !pro.getArrival().equals("")) {
					pStmt.setString(2, pro.getArrival());
				}else {
					pStmt.setString(2, "（未設定）");
				}
				if (pro.getDestination() != null && !pro.getDestination().equals("")) {
					pStmt.setString(3, pro.getDestination());
				}else {
					pStmt.setString(3, "（未設定）");
				}

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}else
			{
				// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
				String sql = "UPDATE PURPOSE SET ARRIVAL = ? , destination = ? ,UPDATED_AT  = CURRENT_TIMESTAMP  WHERE user_id = ?;)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (pro.getUser_id() != null && !pro.getUser_id().equals("")) {
					pStmt.setString(3, pro.getUser_id());
				}else {
					pStmt.setString(3, "（未設定）");
				}
				if (pro.getArrival() != null && !pro.getArrival().equals("")) {
					pStmt.setString(1, pro.getArrival());
				}else {
					pStmt.setString(1, "（未設定）");
				}
				if (pro.getDestination() != null && !pro.getDestination().equals("")) {
					pStmt.setString(2, pro.getDestination());
				}else {
					pStmt.setString(2, "（未設定）");
				}
				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}

			}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
}
