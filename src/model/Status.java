package model;
import java.io.Serializable;

public class Status implements Serializable {
	private int id;
	private	 String user_id;
	private	 int keizoku;
	private	 String keizoku_rank;
	//ここから下をデータベースのuser_statusテーブルを参考に作る
	private int shusei;
	private String shusei_rank;
	private int jikan;
	private	 String jikan_;
	private	 int chokin;
	private	 String chokin_rank;
	private int tairyoku;
	private	 String tairyoku_rank;
	private	 int kouken;
	private	 String kouken_rank;

	// 引数がないコンストラクタ
	public Status() {

	}

}
