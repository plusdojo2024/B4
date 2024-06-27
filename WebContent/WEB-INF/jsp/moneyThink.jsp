<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<title>予算逆算 | ずぼら塾</title>
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/MoneyThink.css">
</head>
<body>

<main>
<div class="body">
		<form action="/B4/MoneyThinkServlet" method="post" class="form green target YearOrMonth">
				<input type="number" name="length" id="number1" placeholder="3"
				value="${current.length }" class="length">
				<select name="form" class="green" id="YearOrMonth">
					<option value="365">年</option>
					<option value="30">カ月</option>
				</select>
				<span>までに</span><br>
				<input type="text" name="target_saving" class="green target-save" placeholder="1,800,000">
				円貯める
<%-- 				<input class="green" value="${current.target_saving }"> --%>
				<input type="hidden" id="finaldate" name="saving_period">
				<!--  <input type="submit"  value="登録">-->
				<input type="submit" name="submit" value="登録">
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
			<div id="income_display">${Incomes}</div>
	</div>
	<hr>
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

	<div class="popup-all">
		<input type="checkbox" id="money-popup" class="popup">
		 <label class="popup-open" for="money-popup">＜詳細</label>
		<div class="popup-overlay">

			<div class="popup-window">
			<form class="form green">
				<h1>手取り</h1>
					<input type="text" id="income" name="income" value="${income} ">
					<span>円</span>
					<input type="submit" name="submit"  value="登録" >
			</form>
	<hr>

				<div class="common-list green">
					<h1 class="total-cost">
						固定費合計 100,000
						<!-- ここに固定費の合計を記入 -->
						円
					</h1>
					<h1>固定費</h1>
					<p>金額</p>
					<div>
					<form action="/B4/MoneyThinkServlet" method="post">
						<table class="task-form">
							<tr>
								<th>家賃<!-- 用途 --></th>
								<td>70,000</td>
								<td><input type="submit" value="×"></td>
							</tr>
							<tr>
								<th>水道光熱費 ${moneyName}</th>
								<td>30,000${money}</td>
								<td><input type="submit" value="×"></td>
							</tr>
						</table>
						</form>
					</div>
				</div>

					<!--入力フォーム-->
					<form action="/B4/MoneyThinkServlet" method="post" class="form green">
						<input type="text" name="money-name" placeholder="用途">
						<input type="text" name="money" placeholder="金額" >
						 <span class="add-botton"><input type="submit" name="task-entry" value="追加">
						 </span>
					</form>
				</div>

			<label class="popup-close" for="money-popup">
				<svg width="20" height="20" xmlns="http://www.w3.org/2000/svg">
				<line x1="0" y1="0" x2="20" y2="20" stroke="white" stroke-width="6"></line>
				<line x1="0" y1="20" x2="20" y2="0" stroke="white" stroke-width="6"></line>
				</svg>
			</label>
		</div>
	</div>

	<form action="/B4/MoneyThinkServlet" method="post" class="form green">
		<h1>支出</h1>
		<input type="text" name="amount_used" class="amount_used">
		<span class="add-botton">
			<input type="submit" value="追加" name="submit" style="width: 4rem">
		</span>
	</form>
	<div  class="green">
		<h1>使用金額<span class="mini">※ページ更新時に変わります。</span></h1>
		<p class="used-money">
			${sum}円
		</p>
	</div>
</div>

<hr>

<div class="body">
	<form action="/B4/MoneyThinkServlet" method="post" class="form green use">
			使用額
			<select name="period" class="green">
				<option value="yearList">月（日数）</option>
				<option value="weekList" id="weekList">週（曜日）</option>
				<option value="dayList">日（時間）</option>
			</select>
	</form>

	<div class="chart-container">
		<canvas id="dayChart"></canvas>
	</div>
	<div class="chart-container">
		<canvas id="weekChart" class="chart"></canvas>
	</div>
	<div class="chart-container">
		<canvas id="monthChart" class="chart"></canvas>
	</div>
	<div class="chart-container">
		<canvas id="investChart" class="chart"></canvas>
	</div>

	<div class="table">
		<c:forEach var="e" items="${dayList}" varStatus="status">
			<div>
				<input type="hidden" id="amountDay${status.index}" value="${e}"><br>
				<input type="hidden" class="day_${status.last}" id="${status.index}"
					value="${status.index}"><br>
			</div>
		</c:forEach>
		<c:forEach var="e" items="${weekList}" varStatus="status">
			<div>
				<input type="hidden" id="amountWeek${status.index}" value="${e}"><br>
				<input type="hidden" class="week_${status.last}" id="${status.index}"
					value="${status.index}"><br>
			</div>
		</c:forEach>
		<c:forEach var="e" items="${yearList}" varStatus="status">
			<div>
				<input type="hidden" id="amountMonth${status.index}" value="${e}"><br>
				<input type="hidden" class="month_${status.last}"
					id="${status.index}" value="${status.index}"><br>
			</div>
		</c:forEach>
	</div>

	<div class="investment">
		<!-- display inlineする -->
		<div class="inChart">
		<canvas id="investmentChart"></canvas>
		</div>
		<div class="right-text">
			<p>30年後までに貯金しないと</p>
				<!-- 月に引かれる金＊12＊30 -->
				<p><span class="bold">3,600,000円</span>　貯金出来て、</p>
			<p>投資に回す人と比べると</p>
			<p class="red-comment">
				<!--設定金額テーブルの金額＊12＊1.05＊30ー設定金額の元本（設定金額＊12＊30)-->
				約<span class="red">8.900,000円</span>の損
			</p>
		</div>
	</div>
</div>


</main>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="/B4/js/amountGraph.js"></script>
<script src="js/Moneythink.js"></script>
</body>

</html>