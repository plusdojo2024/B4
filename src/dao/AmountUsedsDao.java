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

import model.AmountUseds;
public class AmountUsedsDao {
	/*public static void main(String[] args) {
		AmountUsedsDao aDao = new AmountUsedsDao();
		List<AmountUseds> al = aDao.allList();
        for (AmountUseds au : al) {
             String  amount= au.getUpdated_at();
            System.out.println(amount);
        }
		List<Integer> year = aDao.yearList(al,2024);

		LocalDate today = LocalDate.now();

		List<Integer> week = aDao.weekList(al);
		List<Integer> day = aDao.dayList(al,today);
		int calc = aDao.calcList(al);

		System.out.println("year::"+year);
		System.out.println("week::"+week);
		System.out.println("day::"+day);
		System.out.println("calc::"+calc);
		aDao.insert(new AmountUseds(0,"",0,"",""));
	}*/

	public List<AmountUseds> allList() {
		Connection conn = null;
		List<AmountUseds> usedsAllList = new ArrayList<AmountUseds>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する
			//String sql = "SELECT * FROM Bc WHERE company LIKE ? AND department LIKE ? 'position' LIKE ? AND name LIKE ? zipcode LIKE ? AND address LIKE ? phone LIKE ? AND fax LIKE ? email LIKE ? AND remarks LIKE ? ORDER BY number";
			String sql = "SELECT * FROM Amount_Useds";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				AmountUseds record = new AmountUseds(
						rs.getInt("id"),
						rs.getString("user_id"),
						rs.getInt("amount_used"),
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

	//サーブレットで使用金額が数値かのエラー処理行う
	public boolean insert(AmountUseds au) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する（AUTO_INCREMENTのNUMBER列にはNULLを指定する）
			String sql = "INSERT INTO Amount_Useds (user_id, amount_used) VALUES (?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
				pStmt.setString(1, au.getUser_id());

			//サーブレットで使用金額が数値かのエラー処理行う
				pStmt.setInt(2, au.getAmount_used());


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
/**	public List<AmountUseds> weekList(AmountUseds au) {
		List<AmountUseds> weekList = new ArrayList<AmountUseds>();

		// 結果を返す
		return dayList;
	}

	public List<AmountUseds> dayList(AmountUseds au) {
		Connection conn = null;
		List<AmountUseds> dayList = new ArrayList<AmountUseds>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する
			//String sql = "SELECT * FROM Bc WHERE company LIKE ? AND department LIKE ? 'position' LIKE ? AND name LIKE ? zipcode LIKE ? AND address LIKE ? phone LIKE ? AND fax LIKE ? email LIKE ? AND remarks LIKE ? ORDER BY number";
			String sql = "SELECT * FROM Bc WHERE ? ? ORDER BY number";
			au.getUser_id();
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				AmountUseds record = new AmountUseds(
						rs.getInt("id"),
						rs.getString("user_id"),
						rs.getDouble("saving_period"),
						rs.getBoolean("now"),
						rs.getString("created_at"),
						rs.getString("updated_at")
						);
				dayList.add(record);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			dayList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			dayList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					dayList = null;
				}
			}
		}
		// 結果を返す
		return dayList;
	}
*/
	public int calcList(List<AmountUseds> allList){
		int sum =0;
		LocalDate today = LocalDate.now();
		int day = today.getDayOfMonth();
		int month = today.getMonthValue();
		 int year = today.getYear();
		List<AmountUseds> dayList = new ArrayList<AmountUseds>();
		for(AmountUseds au:allList) {
			if(au.getYear() == year && au.getMonth() ==month && au.getDay() == day) {
				dayList.add(au);
			}
		}
		for(AmountUseds au:dayList) {
			sum = sum + au.getAmount_used();
		}
		return sum;
	}


	public List<Integer> yearList(List<AmountUseds> allList,int year) {
		List<Integer> calcYearList = new ArrayList<Integer>();
		List<AmountUseds> yearList = new ArrayList<AmountUseds>();

		for(AmountUseds au:allList) {
			if(au.getYear() == year) {
				yearList.add(au);
			}
		}

		for(int i=0;i<12;i++) {
			int sum=0;
			for(AmountUseds au:yearList) {
				int month = au.getMonth();
				if( i+1 == month) {
					sum = sum + au.getAmount_used();
				}
			}
			calcYearList.add(sum);
		}
		// 結果を返す
		return calcYearList;
		}

	public List<Integer> weekList(List<AmountUseds> allList) {
			List<Integer> calcWeekList = new ArrayList<Integer>();
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
			int sum=0;
			for(AmountUseds au:allList) {
				if(au.getYear() == judgeYear && au.getMonth() == judgeMonth && au.getDay() == judgeDay) {
					sum = sum + au.getAmount_used();
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

	public List<Integer> dayList(List<AmountUseds> allList, LocalDate today) {
			// 今日の日付を取得
			int day = today.getDayOfMonth();
			int month = today.getMonthValue();
			int year = today.getYear();

			List<Integer> calcDayList = new ArrayList<Integer>();
			List<AmountUseds> dayList = new ArrayList<AmountUseds>();

			for(AmountUseds au:allList) {
				if(au.getYear() == year && au.getMonth() == month && au.getDay() == day) {
					dayList.add(au);
				}
			}

			for(int i=0;i<24;i++) {
				int sum=0;
				for(AmountUseds au:dayList) {
					if(i == au.getTime()) {
						sum = sum + au.getAmount_used();
					}
				}
				calcDayList.add(sum);
			}
			// 結果を返す
			return calcDayList;
		}

}