package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DiseaseList;

public class DiseaseListDao {

	//病気名により金額と基準確率をもってくる
	public List<DiseaseList> select(String disease) {
		Connection conn = null;
		List<DiseaseList> dlList = new ArrayList<DiseaseList>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
			String sql = "SELECT disease_money,standard FROM disease_list where disease='?'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1,disease );

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {

				//引数が空のコンストラクターを実行
				DiseaseList record = new DiseaseList();

				//setterでrsのmets,exercise_nameをrecordの
				//フィールドに入れる

				record.setDisease_money(rs.getInt("disease_money"));
				record.setStandard(rs.getDouble("standard"));

				dlList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			dlList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			dlList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					dlList = null;
				}
			}
		}

		// 結果を返す
		return dlList;
	}

	// データを持ってきて、リストで返す

	public List<DiseaseList> selectAll() {
		Connection conn = null;
		List<DiseaseList> dlList = new ArrayList<DiseaseList>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM disease_List ";//?病名、病気の確率のための値、お金をもってくる
			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {

				DiseaseList record = new DiseaseList(
				rs.getInt("id"),
				rs.getString("disease"),
				rs.getInt("disease_money"),
				rs.getInt("standard"),
				rs.getDouble("rank"),
				rs.getString("created_at"),
				rs.getString("updated_at")
				);
				dlList.add(record);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
			dlList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			dlList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					dlList = null;
				}
			}
		}

		// 結果を返す
		return dlList;
	}

}
