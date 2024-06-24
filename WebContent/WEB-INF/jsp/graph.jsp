<style>
.chart-container {
	width: 80%;
	height: 80%;
	margin-bottom: 20px;
}
</style>

<div class="chart-container">
    <canvas id="dayChart"></canvas>
</div>
 <div class="chart-container">
	<canvas id="weekChart" class = "chart" ></canvas>
</div>
<div class="chart-container">
	<canvas id="monthChart" class = "chart"></canvas>
</div>
<c:forEach var="e" items="${dayList}" varStatus="status">
	<form method="POST" action="/B4/ExerciseThinkServlet">
		<input type="hidden" id="momentDay${status.index}"
			value="${e}"><br>
		<input  type="hidden" class="day_${status.last}" id = "${status.index}" value = "${status.index}"><br>
	</form>
</c:forEach>
<c:forEach var="e" items="${weekList}" varStatus="status">
	<form method="POST" action="/B4/ExerciseThinkServlet">
		<input type="hidden" id="momentWeek${status.index}"
			value="${e}"><br>
		<input  type="hidden" class="week_${status.last}" id = "${status.index}" value = "${status.index}"><br>
	</form>
</c:forEach>
<c:forEach var="e" items="${dayList}" varStatus="status">
	<form method="POST" action="/B4/ExerciseThinkServlet">
		<input type="hidden" id="momentMonth${status.index}"
			value="${e}"><br>
		<input  type="hidden" class="month_${status.last}" id = "${status.index}" value = "${status.index}"><br>
	</form>
</c:forEach>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="/B4/js/momentGraph.js"></script>

---運動ここまで

---予算ここから
<style>
.chart-container {
	width: 80%;
	height: 80%;
	margin-bottom: 20px;
}
</style>

<div class="chart-container">
    <canvas id="dayChart"></canvas>
</div>
 <div class="chart-container">
	<canvas id="weekChart" class = "chart" ></canvas>
</div>
<div class="chart-container">
	<canvas id="monthChart" class = "chart"></canvas>
</div>
<div class="chart-container">
	<canvas id="investChart" class = "chart"></canvas>
</div>
<c:forEach var="e" items="${dayList}" varStatus="status">
	<form method="POST" action="/B4/MoneyThinkServlet">
		<input type="hidden" id="amountDay${status.index}"
			value="${e}"><br>
		<input  type="hidden" class="day_${status.last}" id = "${status.index}" value = "${status.index}"><br>
	</form>
</c:forEach>
<c:forEach var="e" items="${weekList}" varStatus="status">
	<form method="POST" action="/B4/MoneyThinkServlet">
		<input type="hidden" id="amountWeek${status.index}"
			value="${e}"><br>
		<input  type="hidden" class="week_${status.last}" id = "${status.index}" value = "${status.index}"><br>
	</form>
</c:forEach>
<c:forEach var="e" items="${yearList}" varStatus="status">
	<form method="POST" action="/B4/MoneyThinkServlet">
		<input type="hidden" id="amountMonth${status.index}"
			value="${e}"><br>
		<input  type="hidden" class="month_${status.last}" id = "${status.index}" value = "${status.index}"><br>
	</form>
</c:forEach>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="/B4/js/amountGraph.js"></script>

--未来ず

<style>
.chart-container {
	width: 80%;
	height: 80%;
	margin-bottom: 20px;
}
</style>


<div class="chart-container">
	<canvas id="Chart" class = "chart"></canvas>
</div>

	<form method="POST" action="/B4/StatusServlet">
		<input type="hidden" id="comPower"
			value="<%= 総合力入れる%>">
			</form>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="/B4/js/statusGraph.js"></script>