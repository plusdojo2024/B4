package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TargetSavings;

public class TargetSavingDao {

	public List<TargetSavings> allList() {
		Connection conn = null;
		List<TargetSavings> usedsAllList = new ArrayList<TargetSavings>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する
			//String sql = "SELECT * FROM Bc WHERE company LIKE ? AND department LIKE ? 'position' LIKE ? AND name LIKE ? zipcode LIKE ? AND address LIKE ? phone LIKE ? AND fax LIKE ? email LIKE ? AND remarks LIKE ? ORDER BY number";
			String sql = "SELECT * FROM TargetSavings";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				TargetSavings record = new TargetSavings(
						rs.getInt("id"),
						rs.getString("user_id"),
						rs.getInt("Target_Saving"),
						rs.getInt("period"),
						rs.getString("saving_period"),
						rs.getString("created_at"),
						rs.getString("updated_at")
						);
				usedsAllList.add(record);
			}
	}
	catch (SQLException e) {
		e.printStackTrace();
		usedsAllList = null;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		usedsAllList = null;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				usedsAllList = null;
			}
		}
	}
		return usedsAllList;
	}

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
			String sql = "INSERT INTO target_savings VALUES (NULL, ?, ?, ?,  CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// タスク名が空かどうかの判定
			if (ts.getUser_id() != null && !ts.getUser_id().equals("")) {
				pStmt.setString(1, ts.getUser_id());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}
			pStmt.setInt(2, ts.getTarget_saving());

			if (ts.getSaving_period() != null && !ts.getSaving_period().equals("")) {
				pStmt.setString(3, ts.getSaving_period());
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
}