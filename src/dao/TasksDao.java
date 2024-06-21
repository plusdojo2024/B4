package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TaskTypes;
import model.Tasks;



public class TasksDAO {

	//タスクの検索
	public List<Tasks> select(Tasks task) {
		Connection conn = null;
		List<Tasks> Tasks = new ArrayList<Tasks>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM TASKS WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			if (task.getUser_id() != null) {
				pStmt.setString(1, task.getUser_id());
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Tasks recordt = new Tasks(
				rs.getInt("id"),
				rs.getString("user_id"),
				rs.getInt("task_id"),
				rs.getInt("time"),
				rs.getBoolean("show"),
				rs.getString("created_at"),
				rs.getString("updated_at")
				);
				Tasks.add(recordt);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			Tasks = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			Tasks = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					Tasks = null;
				}
			}
		}

		// 結果を返す
		return Tasks;
	}


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