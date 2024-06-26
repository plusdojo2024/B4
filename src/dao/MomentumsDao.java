package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Momentums;

public class MomentumsDao {

	// user_idを受け取り、一日の運動量を返す

	public List<Momentums> select(String user_id) {
		Connection conn = null;
		List<Momentums> momentumsList = new ArrayList<Momentums>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4","sa","");
			// SQL文を準備する
			String sql = "SELECT momentum FROM momentums where user_id=? AND created_at = CURRENT_DATE";
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

	// user_idを受け取り、全データを持ってきて、リストで返す(グラフ用)

	public static void main (String args[]) {
		MomentumsDao mDao = new MomentumsDao();
		List<Momentums> mList= mDao.selectAll("yazima_go");
		for(Momentums m:mList) {
			System.out.println(m.getMomentum());
		}
	}

	public List<Momentums> selectAll(String user_id) {
		Connection conn = null;
		List<Momentums> momentumsList = new ArrayList<Momentums>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM momentums where user_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
						pStmt.setString(1, user_id);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {

				Momentums record = new Momentums(
				rs.getInt("id"),
				rs.getString("user_id"),
				rs.getDouble("momentum"),
				rs.getString("created_at"),
				rs.getString("updated_at")
				);
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

//
	public double calcList(List<Momentums> allList){
		double sum =0;
		LocalDate today = LocalDate.now();
		int day = today.getDayOfMonth();
		int month = today.getMonthValue();
		 int year = today.getYear();
		List<Momentums> dayList = new ArrayList<Momentums>();
		for(Momentums au:allList) {
			if(au.getYear() == year && au.getMonth() ==month && au.getDay() == day) {
				dayList.add(au);
			}
		}
		for(Momentums au:dayList) {
			sum = sum + au.getMomentum();
		}
		return sum;
	}

	public List<Double> yearList(List<Momentums> allList,int year) {
		List<Double> calcYearList = new ArrayList<Double>();
		List<Momentums> yearList = new ArrayList<Momentums>();

		for(Momentums au:allList) {
			if(au.getYear() == year) {
				yearList.add(au);
			}
		}

		for(int i=0;i<12;i++) {
			double sum=0;
			for(Momentums au:yearList) {
				int month = au.getMonth();
				if( i+1 == month) {
					sum = sum + au.getMomentum();
				}
			}
			calcYearList.add(sum);
		}
		// 結果を返す
		return calcYearList;
		}
	public List<Double> weekList(List<Momentums> allList) {
		List<Double> calcWeekList = new ArrayList<Double>();
	// 今日の日付を取得
	LocalDate today = LocalDate.now();

	// 今日の曜日を取得
	DayOfWeek todayDayOfWeek = today.getDayOfWeek();

	// 週の最初の日 (月曜日) を計算
	LocalDate startOfWeekDate = today.minusDays(todayDayOfWeek.getValue() - DayOfWeek.MONDAY.getValue());

	int judgeDay = startOfWeekDate .getDayOfMonth();
	int judgeMonth = startOfWeekDate.getMonthValue();
	 int judgeYear = startOfWeekDate.getYear();
	//LocalDate startOfWeekDate = today.with(DayOfWeek.MONDAY);
	//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	LocalDate nextDay = startOfWeekDate.plusDays(1);
	//String search = startOfWeekDate.format(formatter);
	for(int i=0;i<7;i++) {
		double sum=0;
		for(Momentums au:allList) {
			if(au.getYear() == judgeYear && au.getMonth() == judgeMonth && au.getDay() == judgeDay) {
				sum = sum + au.getMomentum();
			}
		}
		calcWeekList.add(sum);
		judgeDay = nextDay.getDayOfMonth();
		judgeMonth = nextDay.getMonthValue();
		judgeYear = nextDay.getYear();
		nextDay = nextDay.plusDays(1);
	}
	// 結果を返す
	return calcWeekList;
}

public List<Double> dayList(List<Momentums> allList, LocalDate today) {
		// 今日の日付を取得
		int day = today.getDayOfMonth();
		int month = today.getMonthValue();
		int year = today.getYear();

		List<Double> calcDayList = new ArrayList<Double>();
		List<Momentums> dayList = new ArrayList<Momentums>();

		for(Momentums au:allList) {
			if(au.getYear() == year && au.getMonth() == month && au.getDay() == day) {
				dayList.add(au);
			}
		}

		for(int i=0;i<24;i++) {
			double sum=0;
			for(Momentums au:dayList) {
				if(i == au.getTime()) {
					sum = sum + au.getMomentum();
				}
			}
			calcDayList.add(sum);
		}
		// 結果を返す
		return calcDayList;
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
				pStmt.setDouble(2, mt.getMomentum());

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


