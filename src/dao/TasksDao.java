package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.TaskTypes;
import model.Tasks;

public class TasksDao {

	//タスクの登録
	public boolean insert(TaskTypes tt,Tasks t) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO task_types VALUES (NULL, ?, CURRENT_TIMESTAMP , CURRENT_TIMESTAMP);"
					+ "INSERT INTO tasks VALUES (NULL,NULL,NULL,?,NULL, CURRENT_TIMESTAMP , CURRENT_TIMESTAMP);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// タスク名が空かどうかの判定
			if (tt.getTask() != null && !tt.getTask().equals("")) {
				pStmt.setString(1, tt.getTask());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}
			pStmt.setInt(2, t.getTime());
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

	// 引数idで指定されたタスクを削除
	public boolean delete(int id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する
			String sql = "DELETE FROM tasks WHERE id=?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, id);

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