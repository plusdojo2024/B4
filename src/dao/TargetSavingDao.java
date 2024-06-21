package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.TargetSavings;

public class TargetSavingDao {

	//目標金額、期間を登録
	public boolean insert(TargetSavings ts){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO target_savings VALUES (NULL, ?, ?, ?, TRUE, CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// タスク名が空かどうかの判定
			if (ts.getUser_id() != null && !ts.getUser_id().equals("")) {
				pStmt.setString(1, ts.getUser_id());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}
			pStmt.setDouble(2, ts.getTarget_saving());

			if (ts.getSaving_period() != null && !ts.getSaving_period().equals("")) {
				pStmt.setDate(3, ts.getSaving_period());
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