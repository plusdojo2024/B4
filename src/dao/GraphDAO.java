package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Momentums;
import java.time.*;
public class GraphDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Momentums> allList() {
		Connection conn = null;
		List<Momentums> momentAllList = new ArrayList<Momentums>();
		List<Double> momentList = new ArrayList<Double>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B4", "sa", "");

			// SQL文を準備する
			//String sql = "SELECT * FROM Bc WHERE company LIKE ? AND department LIKE ? 'position' LIKE ? AND name LIKE ? zipcode LIKE ? AND address LIKE ? phone LIKE ? AND fax LIKE ? email LIKE ? AND remarks LIKE ? ORDER BY number";
			String sql = "SELECT * FROM Momentums where ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Momentums record = new Momentums(
						rs.getInt("id"),
						rs.getString("user_id"),
						rs.getDouble("momentum")
						);
				momentAllList.add(record);
			}
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
		momentAllList = null;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		momentAllList = null;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				momentAllList = null;
			}
		}
	}
}

public List<Momentums> yearList(List<Momentums> momentAllList) {
int count = 0;
for(int i=0;i<12;i++) {
	double sum=0;
	for(int j = count;j < momentAllList.size();j++) {
		int month = momentAllList.getHUHUHU().;
		if( i+1 == month) {
			sum = sum + momentAllList.getMomentum();
		}else if(i+1 < month) {
			break;
		}
	}
	momentList.add(sum);
}

// 結果を返す
return momentList;
}

public List<Momentums> weekList(List<Momentums> momentAllList) {
// 今日の日付を取得
LocalDate today = LocalDate.now();

// 今日の曜日を取得
DayOfWeek todayDayOfWeek = today.getDayOfWeek();

// 週の最初の日 (月曜日) を計算
LocalDate startOfWeekDate = today.minusDays(todayDayOfWeek.getValue() - DayOfWeek.MONDAY.getValue());
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.JAPANESE);
LocalDate nextDay = startOfWeekDate.plusDays(1);
String search = startOfWeekDate.format(formatter);

int count = 0;
for(int i=0;i<7;i++) {
	double sum=0;
	for(int j = count;j < momentAllList.size();j++) {
		if(search .equals(momentAllList[j].getHUHUU)) {
			sum = sum + momentAllList[j].getMomentum();
		}
	}
	momentList.add(sum);
	search = nextDay.format(formatter);
	nextDay = nextDay.plusDays(1);
}

// 結果を返す
return momentList;
}

public List<Momentums> dayList(List<Momentums> momentAllList) {
	// 今日の日付を取得
	LocalDate today = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd", Locale.JAPANESE);
	String search = today.format(formatter);
	int count = 0;

	for(int i=0;i<24;i++) {
		double sum=0;
		for(int j = count;j < momentAllList.size();j++) {
			if(search.equals(momentAllList[j].getHUHUU)) {
				if(i == momentAllList[j].getHUHUU().cutsuru) {
					sum = sum + momentAllList[j].getMomentum();
				}
			}
		}
		momentList.add(sum);
	}
	// 結果を返す
	return momentList;
}

//ここまで



}