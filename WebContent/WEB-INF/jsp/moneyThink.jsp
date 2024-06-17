<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<title>予算逆算 | ずぼら塾</title>
<link rel="stylesheet" href="css/MoneyThink.css">
</head>
<body onload="displayLineChart();">
	<div class="top">
		<form action="/B4/MoneyThinkServlet" method="post" class="form">
			<p>
				<input type="text" name="form"> <select name="period">
					<option value="年">年</option>
					<option value="カ月">カ月</option>
				</select> <input type="text" name="form"> 円貯める
			</p>
		</form>
	<div class="Hero">
		<table>
			<tr>
				<td>今週の予算</td>
				<td>45,678<!-- ここに予算の数値 -->円
				</td>
			</tr>
			<tr>
				<td>現在貯蓄額</td>
				<td>123,456<!-- ここに貯蓄の数値 -->円
				</td>
			</tr>
		</table>
    </div>
		<input type="checkbox" id="popup"> <label class="popUp"
			for="popup">＜詳細</label>
		<div class="popup-overlay">
			<div class="popup-window">
				<p class="popup-text">
				<h1>手取り</h1>
				<form action="/B4/MoneyThinkServlet" method="post" class="orange">
				<input type="text" name="income">円
				</form>
				<hr>
				<div class="popup-all">
					<div>
						<h1>固定費</h1>
						<p>金額</p>
					</div>
					<form action="/B4/MoneyThinkServlet" method="post" class="form">
						<table>
							<tr>
								<td>${moneyName}</td>
								<td>${money}</td>
								<td><input type="submit" value="追加"> <input
									type="submit" value="×"></td>
							</tr>
							<tr>
								<td>${moneyName}</td>
								<td>${money}</td>
								<td><input type="submit" value="追加"> <input
									type="submit" value="×"></td>
							</tr>
						</table>
					</form>
					<label class="popup-close" for="popup"> <svg width="18"
							height="18" xmlns="http://www.w3.org/2000/svg">
                <line x1="0" y1="0" x2="18" y2="18" stroke="white"
								stroke-width="3"></line>
                <line x1="0" y1="18" x2="18" y2="0" stroke="white"
								stroke-width="3"></line>
            </svg>
					</label>
				</div>
			</div>
		</div>
	<form action="/B4/MoneyThinkServlet" method="post" class="green">
		<p>
			支出<input type="text" name="form"> <label class="form-button">
				<input type="submit" value="追加">
			</label>
		</p>
	</form>
   <form action="/B4/MoneyThinkServlet" method="get" class="green">
		<p>
			使用金額20,000
			<!-- ここに使用金額 -->
			円
		</p>
	</form>
	</div>
	<hr>
	<div class="bottom">
	<form action="/B4/MoneyThinkServlet" method="post" class="orange">
		<p>
			使用額<select name="period">
				<option value="月（日数）">月（日数）</option>
				<option value="週（曜日）">週（曜日）</option>
				<option value="日（時間）">日（時間）</option>
			</select>
		</p>
	</form>
		<div class="box">
			<canvas id="lineChart" height="450" width="800"></canvas>
		</div>
		<div class="investment"><!-- display inlineする -->
			<canvas id="lineChart2" height="300" width="400"></canvas>
			<span class="inv-comment">30年後までに<!-- 月に引かれる金＊12＊30 -->円貯金しないと貯金出来て、投資に回す人と比べると<!--設定金額テーブルの金額＊12＊1.05＊30ー設定金額の元本（設定金額＊12＊30)-->万円の損</span>
		</div>
	</div>
</body>

</html>