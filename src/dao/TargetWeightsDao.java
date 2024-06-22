package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TargetWeights;

public class TargetWeightsDao {

	// user_idを受け取り、最新の目標体重、目標期間を返す

	public List<TargetWeights> select(String user_id) {
		Connection conn = null;
		List<TargetWeights> twList = new ArrayList<TargetWeights>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
			String sql = "SELECT target_weight,exercise_period FROM target_weights where user_id='?' order by created_at limit 1";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {

				//引数が空のコンストラクターを実行
				TargetWeights record = new TargetWeights();

				//setterでrsのtarget_weight,exercise_periodをrecordの
				//フィールドに入れる

				record.setTarget_weight(rs.getDouble("target_weight"));
				record.setExercise_period(rs.getDate("exercise_period"));

				twList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			twList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			twList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					twList = null;
				}
			}
		}

		// 結果を返す
		return twList;
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
				pStmt.setDate(3, tw.getExercise_period());
			}
			else {
				pStmt.setDate(3, null);
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
