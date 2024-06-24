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
			String sql = "SELECT user_id FROM Users WHERE user_id = ?";
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


	//住所検索
		public String selectAdress(Users users) {
		Connection conn = null;
		String address = null;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する
			String sql = "SELECT Address FROM Users WHERE user_id = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
					if (users.getUser_id() != null) {
						pStmt.setString(1, users.getUser_id());
				}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				address = rs.getString("address");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			address = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			address = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					address = null;
				}
			}
		}

		// 結果を返す
		return address;
	}
		// 住所を更新し、成功したらtrueを返す
		public boolean updateAddress(Users users) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

				// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
				String sql = "UPDATE Users SET address=? WHERE user_id=?;";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (users.getAddress() != null && !users.getAddress().equals("")) {
					pStmt.setString(1, users.getAddress());
				}
				else {
					pStmt.setString(1, null);
				}
				if (users.getUser_id() != null && !users.getUser_id().equals("")) {
					pStmt.setString(2, users.getUser_id());
				}
				else {
					pStmt.setString(2, null);
				}

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
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
