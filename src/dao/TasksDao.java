package dao;
	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tasks;

	public class TasksDao {

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
				String sql = "SELECT t.id,t.user_id,t.task_id,tt.task,t.time,t.show,t.created_at,t.updated_at FROM TASKS as t INNER JOIN TASK_TYPES as tt ON t.TASK_ID = tt.ID WHERE t.user_id = ?;";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる
						if (task.getUser_id() != null) {
							pStmt.setString(1, task.getUser_id());
					}else {
						pStmt.setString(1, "%");
					}
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Tasks recordt = new Tasks(
					rs.getInt("id"),
					rs.getString("user_id"),
					rs.getInt("task_id"),
					rs.getString("task"),
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

		// タスクを登録し、成功したらtrueを返す
		public boolean insert(Tasks task) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

				// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
				String sql = "INSERT INTO TASKS VALUES (NULL, ?, ?, ?, false, CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (task.getUser_id() != null && !task.getUser_id().equals("")) {
					pStmt.setString(1, task.getUser_id());
				}
				else {
					pStmt.setString(1, "（未設定）");
				}
				if (task.getTask_id() != 0) {
					pStmt.setInt(2, task.getTask_id());
				}
				else {
					pStmt.setString(2, "（未設定）");
				}
				if (task.getTime() != 0) {
					pStmt.setInt(3, task.getTime());
				}
				else {
					pStmt.setString(3, "0");
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

		// 引数idで指定されたレコードを削除し、成功したらtrueを返す
		public boolean delete(String user_id,int task_id) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

				// SQL文を準備する
				String sql = "DELETE FROM tasks WHERE user_id=? AND task_id = ?;";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, user_id);
				pStmt.setInt(2, task_id);

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
