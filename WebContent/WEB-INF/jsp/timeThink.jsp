<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>時間逆算</title>
		<link rel="stylesheet" href="css/common.css">
		<link rel="stylesheet" href="css/timeThink.css">
	</head>

	<body>
		<header>
			<!--ヘッダー読み込み-->
		</header>

		<main>
			<!--上半分-->
			<div>

				<!--入力フォーム-->
				<form action="/B4/TimeThinkServlet" method="post" class="form">
					<input type="time" name="arrival">に
					<input type="text" name="destination" placeholder="目的地">
				</form>

				<!-- 住所のポップアップ -->
					<input type="checkbox" id="address-popup" class="popup">
					<label class="popup-open" for="address-popup">＜住所</label>
					<div class="popup-overlay">
						<div class="popup-window">

							<!--ポップアップの中身-->
							<form action="/B4/TimeThinkServlet" method="post" class="form">
								<h1>現在住所</h1>
								<input type="text" name="now-address" placeholder="現在の住所" readonly>
								<h1>変更</h1>
								<input type="text" name="address" placeholder="新しい住所を入力してください">
								<input type="submit" name="change-address" value="変更">
							</form>

							<!--ポップアップ閉じる-->
							<label class="popup-close" for="address-popup">
								<svg width="18" height="18" xmlns="http://www.w3.org/2000/svg">
									<line x1="0" y1="0" x2="18" y2="18" stroke="white" stroke-width="3"></line>
									<line x1="0" y1="18" x2="18" y2="0" stroke="white" stroke-width="3"></line>
								</svg>
							</label>
						</div>
					</div>

				<!--hero-->
				<div class="hero">
					<!--現在予定-->
					<div>
						<p>現在の予定</p>
						<p class="now-plan">睡眠</p>
						<p class="plan-time">
							<span class="startTime">23:50</span>
							 ~
							<span class="end-time">6:50</span>
						</p>
					</div>
					<hr>
					<!--次の予定-->
					<div>
						<p>次の予定</p>
						<div class="next-plan-set">
						<p class="next-plan">洗顔</p>
						<p>
							<span class="start-time">23:50</span>
							 ~
							<span class="end-time">6:50</span>
						</p>
						</div>
					</div>
				</div>

				<!--計測ボタン-->
					<form action="/B4/TimeThinkServlet" method="post" class="time-button">
						<input type="submit" name="start-button" value="開始">
						<input type="submit" name="complete-button" value="完了">
					</form>

			</div>
			<hr>
			<!--下半分-->
			<div>
				<!--スケジュール-->
				<div class="plan-list">
					<h1>スケジュール</h1>
					<table>
						<tr>
							<td>家を出る時間</td>
							<td>8:00</td>
						</tr>
						<tr>
							<td>起床時間</td>
							<td>6:50</td>
						</tr>
						<tr>
							<td>寝る時間</td>
							<td>23:50</td>
						</tr>
					</table>
				</div>

				<!--タスクのポップアップ-->
				<!--どうやって上のとは別に表示するかあんまり理解できてない-->
				<input type="checkbox" id="task-popup" class="popup">
				<label class="popup-open" for="task-popup">＜タスク</label>
				<div class="popup-overlay">
					<div class="popup-window">

						<!--ポップアップの中身-->
						<!--予定タスク-->
						<div>
							<div>
								<h1>予定タスク</h1>
								<p>所要時間</p>
							</div>
							<table>
								<tr>
									<td>
									${taskName}
									</td>
									<td>
									${time}
									</td>
									<td><input type="submit" value="×"></td>
								</tr>
								<tr>
									<td>
										${taskName}
										</td>
										<td>
										${time}
										</td>
										<td><input type="submit" value="×"></td>
								</tr>
							</table>
						</div>
						<hr>
						<!--myタスク-->
						<div>
							<div>
								<h1>myタスク</h1>
								<p>所要時間</p>
							</div>
							<form action="/B4/TimeThinkServlet" method="post" class="form">
							<table>
								<tr>
									<td>
									${taskName}
									</td>
									<td>
									${time}
									</td>
									<td>
										<input type="submit" value="追加">
										<input type="submit" value="×"></td>
								</tr>
								<tr>
									<td>
										${taskName}
										</td>
										<td>
										${time}
										</td>
										<td>
											<input type="submit" value="追加">
											<input type="submit" value="×"></td>
								</tr>
							</table>
							</form>

							<!--入力フォーム-->
							<form action="/B4/TimeThinkServlet" method="post" class="form">
								<input type="text" name="task-name" placeholder="新しいタスク">
								<input type="text" name="time" placeholder="所要時間">
								<input type="submit" name="task-entry" value="追加">
							</form>
						</div>

						<!--ポップアップ閉じる-->
						<label class="popup-close" for="task-popup">
							<svg width="18" height="18" xmlns="http://www.w3.org/2000/svg">
								<line x1="0" y1="0" x2="18" y2="18" stroke="white" stroke-width="3"></line>
								<line x1="0" y1="18" x2="18" y2="0" stroke="white" stroke-width="3"></line>
							</svg>
						</label>
					</div>
				</div>

				<!--コメント-->
				<h1>コメント</h1>
				<div class="comment">
					<p>今回の遅刻で、<span>1000円</span>給料が減少</p>
					<p>更にこれを続けると、<span>10000円</span>の減少が・・・</p>
				</div>
			</div>
		</main>

		<footer>
			<!--フッター読み込み-->
		</footer>
	</body>
</html>

