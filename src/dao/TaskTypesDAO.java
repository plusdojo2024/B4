package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TaskTypes;

public class TaskTypesDAO {
	//タスクの検索
	public List<TaskTypes> select(TaskTypes taskType) {
		Connection conn = null;
		List<TaskTypes> TaskTypes = new ArrayList<TaskTypes>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM TASK_TYPES";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
			// 結果表をコレクションにコピーする
				TaskTypes recordt = new TaskTypes(
				rs.getInt("id"),
				rs.getString("task"),
				rs.getString("created_at"),
				rs.getString("updated_at")
				);
				TaskTypes.add(recordt);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			TaskTypes = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			TaskTypes = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					TaskTypes = null;
				}
			}
		}

		// 結果を返す
		return TaskTypes;
	}
}
