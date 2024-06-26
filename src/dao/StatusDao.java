package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Status;

public class StatusDao {

	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public Status select(String user_id) {
			Connection conn = null;
			Status st = new Status();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

				// SQL文を準備する
				String sql = "SELECT * FROM user_status WHERE user_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる

				pStmt.setString(1, user_id);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				rs.next();
			 st.setId(rs.getInt("id"));
			 st.setUser_id(rs.getString("user_id"));
			 st.setKeizoku(rs.getInt("keizoku"));
			 st.setKeizoku_rank(rs.getString("keizoku_rank"));
			st.setShusei(rs.getInt("shusei"));
			st.setShusei_rank(rs.getString("shusei_rank"));
			st.setJikan(rs.getInt("jikan"));
			st.setJikan_rank(rs.getString("jikan_rank"));
			st.setChokin(rs.getInt("chokin"));
			st.setChokin_rank(rs.getString("chokin_rank"));
			st.setTairyoku(rs.getInt("tairyoku"));
			st.setTairyoku_rank(rs.getString("tairyoku_rank"));
			st.setKouken(rs.getInt("kouken"));
			st.setKouken_rank(rs.getString("kouken_rank"));


			}
			catch (SQLException e) {
				e.printStackTrace();
				st = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				st = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						st = null;
					}
				}
			}

			// 結果を返す
			return st;
		}

}
