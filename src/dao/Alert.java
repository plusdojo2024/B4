package dao;
public class Alert{
	public static String loginError() {
		return "ログインに失敗しました。";
	}

	public static String signError() {
		return "ユーザーIDが重複または確認用パスワードが一致しません。";
	}

	public static String success() {
		return "成功しました！！";
	}

}

