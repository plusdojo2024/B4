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
		<form action="/B4/MoneyThinkServlet" method="post" class="form">
			<p>
				<input type="number" name="length" id="number1" placeholder=""
				value="${current.length }">
				<select name="form" class="green" id="YearOrMonth">
					<option value="365">年</option>
					<option value="30">カ月</option>
				</select>
				<input type="text" name="target_saving" class="green" placeholder="">
				<span class="green">円貯める</span>
				<input type="hidden" id="finaldate" name="saving_period" value="${current.target_saving }">
				<inputtype="submit"  value="登録" Style="background-color: var(- -dark-green); margin-left: 0.5rem; width: 3rem;">
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
					<input type="text" id="income" name="income" value="${income}">円
				</form>
				<hr>
				<div class="common-list green">
					<div class="total-cost">
						固定費合計 100,000
						<!-- ここに固定費の合計を記入 -->
						円
					</div>
					<h1>固定費</h1>
					<p>金額</p>
					<form action="/B4/MoneyThinkServlet" method="post">
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
			<label class="popup-close" for="money-popup">
			<svg width="18" height="18" xmlns="http://www.w3.org/2000/svg">
                <line x1="0" y1="0" x2="18" y2="18" stroke="white" stroke-width="3"></line>
                <line x1="0" y1="18" x2="18" y2="0" stroke="white" stroke-width="3"></line>
            </svg>
			</label>
			</div>
		</div>
	</div>
	<form action="/B4/MoneyThinkServlet" method="post" class="form green"
		style="text-align: center; height:">
		<p>
			支出<input type="text" name="amount_used"
				style="width: 20rem; height: 2rem;"> <span
				class="add-botton"><input type="submit" value="追加"
				style="width: 4rem"></span>
		</p>
	</form>
	<form action="/B4/MoneyThinkServlet" method="get" class="green">
		<p>使用金額※ページ更新時に変わります。</p>
		<p class="used-money" id="Used">
			<!-- ここに使用金額 -->
		</p>
	</form>
</div>
<hr>
<div class="bottom">
	<form action="/B4/MoneyThinkServlet" method="post" class="form green">
		<p>
			使用額<select name="period" class="green">
				<option value="yearList">月（日数）</option>
				<option value="weekList" id="weekList">週（曜日）</option>
				<option value="dayList">日（時間）</option>
			</select>
		</p>
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
	<c:forEach var="e" items="${dayList}" varStatus="status">
		<form method="POST" action="/B4/MoneyThinkServlet">
			<input type="hidden" id="amountDay${status.index}" value="${e}"><br>
			<input type="hidden" class="day_${status.last}" id="${status.index}"
				value="${status.index}"><br>
		</form>
	</c:forEach>
	<c:forEach var="e" items="${weekList}" varStatus="status">
		<form method="POST" action="/B4/MoneyThinkServlet">
			<input type="hidden" id="amountWeek${status.index}" value="${e}"><br>
			<input type="hidden" class="week_${status.last}" id="${status.index}"
				value="${status.index}"><br>
		</form>
	</c:forEach>
	<c:forEach var="e" items="${yearList}" varStatus="status">
		<form method="POST" action="/B4/MoneyThinkServlet">
			<input type="hidden" id="amountMonth${status.index}" value="${e}"><br>
			<input type="hidden" class="month_${status.last}"
				id="${status.index}" value="${status.index}"><br>
		</form>
	</c:forEach>
	<div class="investment" style="display: inline;">
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
				約9,000,000円の損
			</p>
		</div>
	</div>
</div>
<script>

//目標金額、期間
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
		document.getElementById('finalDate').value = dt.toISOString()
				.split('T')[0];
		// 最終日を表示
	}
</script>

<script>
	//今週の予算


	//画面読み込み完了時に実行するJavaScriptを書く
	//実行するのはcalculate_budget

	  window.onload = function calculateBudget() {
	  let income = parseFloat(document.getElementById('income')) / 5;// 収入の5分の1（週換算なので）
	 console.log(income);
	  let cost = 25000;// 固定費（今回は時間がないため、変動不可）
	  let targetsavings = 10000;	// 勝手にひかれる分（上と同じく）
	  let UsedsWeek = ${sum};	//週の使用金額()
	  console.log(UsedsWeek);
	let Used = income - cost - targetsavings - UsedsWeek;
	 console.log(Used);
	document.getElementById("Used").innerText = Used + '円';
	}

</script>
<script>
	//投資グラフ
	  const monthlyInvestment = 10000; // 月々の積み立て額 1万円
	  const annualReturnRate = 0.05; // 年間利回り 5%
	  const investmentPeriod = 30; // 投資期間 30年間
	  const monthsPerYear = 12;


	  // 各年の投資額を計算
	  let years = [];
	  let investmentValues = [];

	  let totalInvestment = 0;
	  for (let year = 0; year <= investmentPeriod; year++) {
	      years.push(year);
	      for (let month = 0; month < monthsPerYear; month++) {
	          totalInvestment += monthlyInvestment;
	          totalInvestment *= (1 + annualReturnRate / monthsPerYear);
	      }
	      investmentValues.push(totalInvestment);
	  }

	  // グラフの描画
	  const ctx = document.getElementById('investmentChart').getContext('2d');
	  const investmentChart = new Chart(ctx, {
	      type: 'line',
	      data: {
	          labels: years,
	          datasets: [{
	              label: "投資額",
	              data: investmentValues,
	              borderColor: 'rgba(75, 192, 192, 1)',
	              backgroundColor: 'rgba(75, 192, 192, 0.2)',
	              fill: true,
	              borderWidth: 2,
	              pointRadius: 3,
	              pointBackgroundColor: 'rgba(75, 192, 192, 1)'
	          }]
	      },
	      options: {
	          responsive: true,
	          scales: {
	              x: {
	                  title: {
	                      display: true,
	                      text: "年数"
	                  }
	              },
	              y: {
	                  title: {
	                      display: true,
	                      text: "投資額（円）"
	                  },
	                  ticks: {
	                      beginAtZero: true
	                  }
	              }
	          },
	          plugins: {
	              title: {
	                  display: true,
	                  text: "30年間の積み立て投資額の増加"
	              }
	          }
	      }
</script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="/B4/js/amountGraph.js"></script>
</body>

</html>