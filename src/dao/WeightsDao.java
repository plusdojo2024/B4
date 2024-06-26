package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Weights;

public class WeightsDao {

	// user_idを受け取り、最新の現在体重で返す
	public Double select(String user_id) {
		Connection conn = null;
		double weight=0.0;
		Double weight_w = 0.0;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する
			String sql = "SELECT weight  FROM WEIGHTS where user_id=? order by created_at limit 1;"; //ユーザごとの最新の体重をもってくる
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user_id);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			// 結果(1行)をコピーする
			rs.next();

			//SQLの結果のWEIGHT列のデータを変数weightに代入
			weight = rs.getDouble("weight");
			weight_w = Double.valueOf(weight);


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
		return weight_w;
	}








	// 現在体重を登録する
	public boolean insert(Weights kg) {
		Connection conn = null;
		boolean result = false;


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO Weights VALUES (NULL,?,?, CURRENT_TIMESTAMP ,CURRENT_TIMESTAMP);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる user_id,現在体重が空かどうかの判定
			if (kg.getUser_id() != null && !kg.getUser_id().equals("")) {
				pStmt.setString(1, kg.getUser_id());
			}
			else {
				pStmt.setString(1, "（未設定）");
			}
			pStmt.setDouble(2, kg.getWeight());

		//	if (kg.getWeight() != null && !kg.getWeight()==("")) {
//				pStmt.setDouble(2, kg.getWeight());
//			}
//			else {
//				pStmt.setString(2, "（未設定）");
//			}




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
