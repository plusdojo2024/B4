package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.TargetWeights;

public class TargetWeightsDao {

	// user_idを受け取り、最新の目標体重、目標期間を返す

	public double select(String user_id) {
		Connection conn = null;
		double weight =0.0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する
			String sql = "SELECT target_weight FROM target_weights where user_id=? order by created_at limit 1";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			rs.next();

			//SQLの結果のWEIGHT列のデータを変数weightに代入
			weight = rs.getDouble("target_weight");



		}
		catch (SQLException e) {
			e.printStackTrace();
			 weight = 0;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			weight = 0;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				weight = 0;
				}
			}
		}

		// 結果を返す
		return weight;
	}



	//目標体重、期間を登録
	public boolean insert(TargetWeights tw){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO target_weights VALUES (NULL, ?, ?, ?, TRUE, CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// タスク名が空かどうかの判定
			if (tw.getUser_id() != null && !tw.getUser_id().equals("")) {
				pStmt.setString(1, tw.getUser_id());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}
			    pStmt.setDouble(2, tw.getTarget_weight());

			if (tw.getExercise_period() != null && !tw.getExercise_period().equals("")) {
				pStmt.setString(3, tw.getExercise_period());
			}
			else {
				pStmt.setString(3, null);
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


		// 目標期間を一日換算に変える
	public int period(String user_id) {
		Connection conn = null;
		int period = 0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する
			String sql = "SELECT datediff(day,current_date,exercise_period) as diff FROM TARGET_WEIGHTS where user_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			// 結果(1行)をコピーする
			rs.next();

			//SQLの結果のWEIGHT列のデータを変数weightに代入
			period = rs.getInt("diff");

		}
		catch (SQLException e) {
			e.printStackTrace();
			period = 0;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			period = 0;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					period = 0;
				}
			}
		}

		// 結果を返す
		return period;
	}
}
