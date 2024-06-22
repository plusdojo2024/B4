package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Exercises;

public class ExercisesDao {

	//運動名により、運動名と運動強度を参照


	public List<Exercises> select(String exercise_name) {
		Connection conn = null;
		List<Exercises> metsList = new ArrayList<Exercises>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
			String sql = "SELECT mets,exercise_name FROM exercises where exercise_name='?'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1,exercise_name );

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {

				//引数が空のコンストラクターを実行
				Exercises record = new Exercises();

				//setterでrsのmets,exercise_nameをrecordの
				//フィールドに入れる

				record.setMets(rs.getDouble("mets"));
				record.setExercise_name(rs.getString("exercise_name"));

				metsList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			metsList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			metsList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					metsList = null;
				}
			}
		}

		// 結果を返す
		return metsList;
	}


}

