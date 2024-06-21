<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>予算逆算 | ずぼら塾</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/MoneyThink.css">
</head>
<div class="top">
	<form action="/B4/MoneyThinkServlet" method="post" class="form">
		<p>
			<input type="number" name="length" id="number1" placeholder="" value ="${current.length }">
			<select name="form" class="green" id="YearOrMonth">
				<option value="365">年</option>
				<option value="30">カ月</option>
			</select>
			<input type="text" name="target_saving" class="green" placeholder="">
			<span class="green">円貯める</span>
			<input type="hidden" id="finaldate" name="saving_period" value="${current.target_saving }">
			 <input type="submit" value="登録"
			 Style="background-color: var(- -dark-green); margin-left: 0.5rem; width: 3rem;">
		</p>
	</form>
	<div class="hero">
		<div class="orange hero-in">
			<!--今週の予算-->
			<div class="orange hero-in">
				<p>今週の予算</p>
				<p class="now-money">
					45,678
					<!-- ここに予算の数値 -->
					円
				</p>
			</div>
			<hr>
			<!--次の予定-->
			<div class="orange hero-in">
				<p>現在貯蓄額</p>
				<div class="next-money-set">
					<p class="next-money orange">
						123,456
						<!-- ここに現在の貯蓄数値 -->
						円
					</p>
				</div>
			</div>
		</div>
	</div>
	<div class="popup-all">
		<input type="checkbox" id="money-popup" class="popup"> <label
			class="popup-open" for="money-popup">＜詳細</label>
		<div class="popup-overlay">
			<div class="popup-window">
				<h1>手取り</h1>
				<form action="/B4/MoneyThinkServlet" method="post" class="orange">
					<input type="text" name="income">円
				</form>
				<hr>
				<div class="common-list green">
					<div class="total-cost">
						固定費合計
						<!-- ここに固定費の合計を記入 -->
						円
					</div>
					<h1>固定費</h1>
					<p>金額</p>
					<form action="/B4/MoneyThinkServlet" method="post">
						<table>
							<tr>
								<th>用途</th>
								<td>金額</td>
								<td><input type="submit" value="×"></td>
							</tr>
							<tr>
								<th>用途 ${moneyName}</th>
								<td>金額 ${money}</td>
								<td><input type="submit" value="×"></td>
							</tr>
						</table>
					</form>

					<!--入力フォーム-->
					<form action="/B4/MoneyThinkServlet" method="post"
						class="form green">
						<input type="text" name="money-name" placeholder="用途"> <input
							type="text" name="money" placeholder="金額"> <span
							class="add-botton"><input type="submit" name="task-entry"
							value="追加"></span>
					</form>
				</div>
				<label class="popup-close" for="money-popup"> <svg
						width="18" height="18" xmlns="http://www.w3.org/2000/svg">
                <line x1="0" y1="0" x2="18" y2="18" stroke="white"
							stroke-width="3"></line>
                <line x1="0" y1="18" x2="18" y2="0" stroke="white"
							stroke-width="3"></line>
            </svg>
				</label>
			</div>
		</div>
	</div>
	<form action="/B4/MoneyThinkServlet" method="post" class="form green"
		style="text-align: center; height:">
		<p>
			支出<input type="text" name="form" style="width: 20rem; height: 2rem;">
			<span class="add-botton"><input type="submit" value="追加"
				style="width: 4rem"></span>
		</p>
	</form>
	<form action="/B4/MoneyThinkServlet" method="get" class="green">
		<p class="used-money">
			使用金額20,000
			<!-- ここに使用金額 -->
			円
		</p>
	</form>
</div>
<hr>
<div class="bottom">
	<form action="/B4/MoneyThinkServlet" method="post" class="form green">
		<p>
			使用額<select name="period" class="green">
				<option value="月（日数）">月（日数）</option>
				<option value="週（曜日）">週（曜日）</option>
				<option value="日（時間）">日（時間）</option>
			</select>
		</p>
	</form>
	<div class="box">
		<canvas id="lineChart" height="450" width="800"></canvas>
	</div>
	<div class="investment">
		<!-- display inlineする -->
		<canvas id="lineChart2" height="300" width="400"></canvas>
		<span class="inv-comment"><p class="inv-comment">
				30年後までに
				<!-- 月に引かれる金＊12＊30 -->
				円
			</p>
			<p class="inv-comment">貯金しないと貯金出来て、</p>
			<p class="inv-comment">投資に回す人と比べると</p> <!--設定金額テーブルの金額＊12＊1.05＊30ー設定金額の元本（設定金額＊12＊30)-->
			<p class="inv-comment">万円の損</p> </span>
	</div>
</div>
<script>
        function calculateDays() {
            var num1 = parseFloat(document.getElementById('number1').value);
            // 数値入力
            var YearOrMonth = parseFloat(document.getElementById('YearOrMonth').value);
            // 月（30日）か年（365日）の選択された方
            var product = num1 * YearOrMonth;
            // 上記をかけて、期間（日数）を出す。
            var dt = new Date();
            dt.setDate(dt.getDate() + product);
            // 今日の日付に足して、最終日を割り出し。
            document.getElementById('finalDate').value = dt.toISOString().split('T')[0];
            // 最終日を表示
        }
    </script>
</body>

</html>