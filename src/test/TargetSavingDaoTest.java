package test;
import dao.TargetSavingDao;
import model.TargetSavings;

public class TargetSavingDaoTest {
	public static void main(String[] args) {
		TargetSavingDao dao = new TargetSavingDao();
//insertメソッドのテスト
		System.out.println("<< insertメソッドのテスト（1件のレコードを登録します）>>");
		TargetSavings insRec = new TargetSavings(0, "挿入",100000.0,null, true,"挿入",
				"挿入");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
		} else {
			System.out.println("登録失敗！");
		}
		System.out.println();
	}}