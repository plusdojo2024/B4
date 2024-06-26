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
	private	 String jikan_rank;
	private	 int chokin;
	private	 String chokin_rank;
	private int tairyoku;
	private	 String tairyoku_rank;
	private	 int kouken;
	private	 String kouken_rank;

	// 引数がないコンストラクタ
	public Status() {

	}
	// 引数があるコンストラクタ

	public Status(int id, String user_id, int keizoku, String keizoku_rank, int shusei, String shusei_rank, int jikan,
			String jikan_rank, int chokin, String chokin_rank, int tairyoku, String tairyoku_rank, int kouken,
			String kouken_rank) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.keizoku = keizoku;
		this.keizoku_rank = keizoku_rank;
		this.shusei = shusei;
		this.shusei_rank = shusei_rank;
		this.jikan = jikan;
		this.jikan_rank = jikan_rank;
		this.chokin = chokin;
		this.chokin_rank = chokin_rank;
		this.tairyoku = tairyoku;
		this.tairyoku_rank = tairyoku_rank;
		this.kouken = kouken;
		this.kouken_rank = kouken_rank;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getKeizoku() {
		return keizoku;
	}

	public void setKeizoku(int keizoku) {
		this.keizoku = keizoku;
	}

	public String getKeizoku_rank() {
		return keizoku_rank;
	}

	public void setKeizoku_rank(String keizoku_rank) {
		this.keizoku_rank = keizoku_rank;
	}

	public int getShusei() {
		return shusei;
	}

	public void setShusei(int shusei) {
		this.shusei = shusei;
	}

	public String getShusei_rank() {
		return shusei_rank;
	}

	public void setShusei_rank(String shusei_rank) {
		this.shusei_rank = shusei_rank;
	}

	public int getJikan() {
		return jikan;
	}

	public void setJikan(int jikan) {
		this.jikan = jikan;
	}

	public String getJikan_rank() {
		return jikan_rank;
	}

	public void setJikan_rank(String jikan_rank) {
		this.jikan_rank = jikan_rank;
	}

	public int getChokin() {
		return chokin;
	}

	public void setChokin(int chokin) {
		this.chokin = chokin;
	}

	public String getChokin_rank() {
		return chokin_rank;
	}

	public void setChokin_rank(String chokin_rank) {
		this.chokin_rank = chokin_rank;
	}

	public int getTairyoku() {
		return tairyoku;
	}

	public void setTairyoku(int tairyoku) {
		this.tairyoku = tairyoku;
	}

	public String getTairyoku_rank() {
		return tairyoku_rank;
	}

	public void setTairyoku_rank(String tairyoku_rank) {
		this.tairyoku_rank = tairyoku_rank;
	}

	public int getKouken() {
		return kouken;
	}

	public void setKouken(int kouken) {
		this.kouken = kouken;
	}

	public String getKouken_rank() {
		return kouken_rank;
	}

	public void setKouken_rank(String kouken_rank) {
		this.kouken_rank = kouken_rank;
	}

}
