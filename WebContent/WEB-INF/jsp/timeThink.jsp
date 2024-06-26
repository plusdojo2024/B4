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
					<input type="time" name="arrival" class="arrival">
					<span>に</span>
					<input type="text" name="destination" placeholder="目的地" class="destination">
					<input type ="submit" name="submit" value="検索">
					<input type="hidden" name="now-address" value="${address}" readonly>
				</form>

				<!-- 住所のポップアップ -->
				 <div class="popup-all">
					<input type="checkbox" id="address-popup" class="popup">
					<label class="popup-open" for="address-popup">＜住所</label>

					<div class="popup-overlay">
						<div class="popup-window">

							<!--ポップアップの中身-->
							<form action="/B4/TimeThinkServlet" method="post" class="form green">
								<h1 class="green">現在住所</h1>
								<input type="text" name="now-address" value="${address}" readonly class="address">
								<br>
								<br>
								<h1 class="green">変更</h1>
								<input type="text" name="address" placeholder="新しい住所を入力してください" class="address">
								<input type="text" name="nearest" placeholder="新しい最寄り駅を入力してください" class="address">
								<input type="text" name="near-time" placeholder="新しい最寄り駅を入力してください" class="address">
								<input type="submit" name="submit" value="変更">
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
				</div><!--変更点　ポップアップ閉じる-->

				<!--hero-->
				<div class="hero">
					<!--現在予定-->
					<div class="orange hero-in">
						<p>現在の予定</p>
						<p class="now-plan">睡眠</p>
						<p class="plan-time orange">
							<span class="startTime">23:50</span>
							 ~
							<span class="end-time">6:50</span>
						</p>
					</div>
					<hr>
					<!--次の予定-->
					<div  class="green hero-in">
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
				<h1  class="green">スケジュール</h1>
				<div class="plan-list two-columns">
					<table>
						<tr>
							<th>家を出る時間</th>
							<td>${goOut}</td>
						</tr>
						<tr>
							<th>起床時間</th>
							<td>${wakeUp}</td>
						</tr>
						<tr>
							<th>寝る時間</th>
							<td>${sleep}</td>
						</tr>
					</table>
				</div>

				<!--タスクのポップアップ-->
				<div class="popup-all">
				<input type="checkbox" id="task-popup" class="popup orange">
				<label class="popup-open" for="task-popup">＜タスク</label>
				<div class="popup-overlay">
					<div class="popup-window">

						<!--ポップアップの中身-->
						<!--予定タスク-->
<!-- 						<div class="common-list orange">
								<h1>予定タスク</h1>
								<p>所要時間</p>
								<table>
								<tr>
 									<td>a</td>
									<td>a</td>
									<td><input type="submit"   value="×"></td>
								</tr>
							</table>
						</div>
						<hr> -->
						<!--myタスク-->
						<div class="common-list orange">
								<h1>マイタスク</h1>
								<p>所要時間</p>


								<c:forEach var="t" items="${myTask}" >
								<form action="/B4/TimeThinkServlet" method="post">
								<input type="hidden" name="task-id" value="${t.task_id}" readonly>
								<input type="hidden" name="task" value="${t.task}" readonly>
								<input type="hidden" name="time" value="${t.time}" readonly>
								<table class="task-form">
								<tr>
									<th>${t.task} </th>
									<td>${t.time}</td>
									<td><input type="submit" name="submit" value="×"></td>
								</tr>
								</table>
								</form>
								</c:forEach>
						</div>

							<!--入力フォーム-->
							<div>
								<form action="/B4/TimeThinkServlet" method="post" class="form orange">
	 							<select name="task-id">
									<c:forEach var="tt" items="${taskTypes}" >
										<option value="${tt.id}">${tt.id} , ${tt.task}</option>
									</c:forEach>
								</select>
									<span>
									<input type="text" name="time" placeholder="所要時間" class="time">
									分</span>
									<input type="submit" name="submit" value="マイタスクに追加">
								</form>

								<form action="/B4/TimeThinkServlet" method="post" class="form orange">
									<input type="text" name="task-name" placeholder="新しいタスク" class="new-task">
									<input type="submit" name="submit" value="タスク追加">
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
				</div>


				<!--コメント-->
				<h1 class="green">コメント</h1>
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

