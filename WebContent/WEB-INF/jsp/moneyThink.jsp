<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div class="top">
		<div class="form">
			<p>
				<input type="number" name="length" id="number1" placeholder="3"
				value="${current.length }">
				<select name="form" class="green" id="YearOrMonth">
					<option value="365">年</option>
					<option value="30">カ月</option>
				</select>
				<input type="text" name="target_saving" class="green" placeholder="1,800,000">
				<span class="green" value="${current.target_saving }">円貯める</span>
				<input type="hidden" id="finaldate" name="saving_period">
				<!--  <input type="submit"  value="登録">-->
				<input type="submit">
			</p>
		</div>
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
				<div class="orange">
					<input type="text" id="income" name="income" value="${income}">円
					<input type="submit"  value="登録"  class="orange">
				</div>
				<hr>
				<div class="common-list green">
					<div class="total-cost">
						固定費合計 100,000
						<!-- ここに固定費の合計を記入 -->
						円
					</div>
					<h1>固定費</h1>
					<p>金額</p>
					<div>
						<table>
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
					</div>

					<!--入力フォーム-->
					<div class="form green">
						<input type="text" name="money-name" placeholder="用途"> <input
							type="text" name="money" placeholder="金額"> <span
							class="add-botton"><input type="submit" name="task-entry"
							value="追加"></span>
					</div>
				</div>
			<label class="popup-close" for="money-popup">
			<svg width="18" height="18" xmlns="http://www.w3.org/2000/svg">
                <line x1="0" y1="0" x2="18" y2="18" stroke="white" stroke-width="3"></line>
                <line x1="0" y1="18" x2="18" y2="0" stroke="white" stroke-width="3"></line>
            </svg>
			</label>
			</div>
		</div>
	</div>
	<div class="form green"
		style="text-align: center; height:">
		<p>
			支出<input type="text" name="amount_used"
				style="width: 20rem; height: 2rem;" value="20000"> <span
				class="add-botton"><input type="submit" value="追加"
				style="width: 4rem"></span>
		</p>
	</div>
	<div  class="green">
		<p>使用金額※ページ更新時に変わります。</p>
		<p class="used-money" id="Used">
			<!-- ここに使用金額 -->
		</p>
	</div>
</div>
<hr>
<div class="bottom">
	<div class="form green">
		<p>
			使用額<select name="period" class="green">
				<option value="yearList">月（日数）</option>
				<option value="weekList" id="weekList">週（曜日）</option>
				<option value="dayList">日（時間）</option>
			</select>
		</p>
	</div>
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
	<div class="investment">
		<!-- display inlineする -->
		<canvas id="investmentChart"></canvas>
		<div class="right-text">
			<p>
				30年後までに
				<!-- 月に引かれる金＊12＊30 -->
				3,600,000円
			</p>
			<p>貯金しないと貯金出来て、</p>
			<p>投資に回す人と比べると</p>
			<p class="red-comment">
				<!--設定金額テーブルの金額＊12＊1.05＊30ー設定金額の元本（設定金額＊12＊30)-->
				約8.900,000円の損
			</p>
		</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="/B4/js/amountGraph.js"></script>
<script src="js/Moneythink.js"></script>
</body>

</html>