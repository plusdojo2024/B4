package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Momentums;

public class MomentumsDao {

	// user_idを受け取り、運動量を返す

	public List<Momentums> select(String user_id) {
		Connection conn = null;
		List<Momentums> momentumsList = new ArrayList<Momentums>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
			String sql = "SELECT momentum FROM momentums where user_id='?'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {

				//引数が空のコンストラクターを実行
				Momentums record = new Momentums();

				//setterでrsのmomentumをrecordの
				//フィールドに入れる

				record.setMomentum(rs.getDouble("momentum"));

				momentumsList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			momentumsList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			momentumsList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					momentumsList = null;
				}
			}
		}

		// 結果を返す
		return momentumsList;
	}


	//運動量を登録
	public boolean insert(Momentums mt){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO momentums VALUES (NULL, ?, ?, CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SOL文を完成させる
				pStmt.setString(1, mt.getUser_id());
				pStmt.setDouble(1, mt.getMomentum());

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


