package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Costs;
public class CostsDao {
	public List<Costs> allList() {
		Connection conn = null;
		List<Costs> usedsAllList = new ArrayList<Costs>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する
			//String sql = "SELECT * FROM Bc WHERE company LIKE ? AND department LIKE ? 'position' LIKE ? AND name LIKE ? zipcode LIKE ? AND address LIKE ? phone LIKE ? AND fax LIKE ? email LIKE ? AND remarks LIKE ? ORDER BY number";
			String sql = "SELECT * FROM Costs";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Costs record = new Costs(
						rs.getInt("id"),
						rs.getString("user_id"),
						rs.getString("fixed_id"),
						rs.getInt("fixed_money"),
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
}
