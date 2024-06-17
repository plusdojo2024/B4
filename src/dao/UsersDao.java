package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Users;

public class UsersDao {
	// ログインできるならtrueを返す
	public boolean isLoginOK(Users idpw) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SELECT文を準備する
			String sql = "SELECT COUNT(*) FROM Users WHERE id = ? AND pw = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, idpw.getUser_id());
			pStmt.setString(2,idpw.getPassword());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("COUNT(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}

	public boolean sign(Users idpw) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "SELECT id FROM idpw WHERE id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, idpw.getUser_id());
			ResultSet resultSet = preparedStatement.executeQuery();
			// IDが存在しない場合は挿入する
			if (!resultSet.next()) {
			    // IDが存在しないので挿入操作を行う
			    String insertSql = "INSERT INTO Users VALUES (NULL,?,?,NULL,NULL,NULL,NULL,NULL)";
			    PreparedStatement insertStatement = conn.prepareStatement(insertSql);
			    insertStatement.setString(1, idpw.getUser_id());
			    insertStatement.setString(2, idpw.getPassword());

				if (insertStatement.executeUpdate() == 1) {
					result = true;
				}

			    // 必要なパラメータを設定する
			} else {
			    // IDがすでに存在する場合の処理
			    System.out.println("このIDは既に存在します。または、パスワードが同一ではありません。");
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
