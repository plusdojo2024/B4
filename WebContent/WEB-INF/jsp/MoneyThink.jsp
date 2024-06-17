<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width">
<title>予算逆算 | ずぼら塾</title>
</head>
<body onload="displayLineChart();">
  <div class="top">
    <p><input type="text" name="form">
    <select name="period">
      <option value="年">年</option>
      <option value="カ月">カ月</option>
    </select>
    <input type="text" name="form">
    円貯める</p>

    <p><table>
      <tr>
        <td>今週の予算</td>
        <td>45,678<!-- ここに予算の数値 -->円</td>
      </tr>
      <tr>
        <td>現在貯蓄額</td>
        <td>123,456<!-- ここに貯蓄の数値 -->円</td>
      </tr></table></p>

<input type="checkbox" id="popup">
<label class="popUp" for="popup">＜詳細</label>
<div class="popup-overlay">
    <div class="popup-window">
        <p class="popup-text">
        <h1>手取り</h1>
        <input type="text" name="income">円
        <hr>
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
        </label>
        </p>
        <label class="popup-close" for="popup">
            <svg width="18" height="18" xmlns="http://www.w3.org/2000/svg">
                <line x1="0" y1="0" x2="18" y2="18" stroke="white" stroke-width="3"></line>
                <line x1="0" y1="18" x2="18" y2="0" stroke="white" stroke-width="3"></line>
            </svg>
        </label>
    </div>
</div>
      <p>支出<input type="text" name="form">
         <label class="form-button">
           <input type="submit" value="追加">
         </label></p>
      <p>使用金額20,000<!-- ここに使用金額 -->円</p>
  </div>
  <hr>
  <div class="bottom">
    <p>使用額<select name="period">
            <option value="月（日数）">月（日数）</option>
            <option value="週（曜日）">週（曜日）</option>
            <option value="日（時間）">日（時間）</option>
          </select></p>
 <div class="box">
    <canvas id="lineChart" height="450" width="800"></canvas>
  </div>
  <div class="investment">
    <canvas id="lineChart2" height="300" width="400"></canvas>


<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
  <script language="JavaScript">
  function displayLineChart() {
    var data = {
        labels: ["月","火","水","木","金","土","日"],
        datasets: [
            {
                label: "Prime and Fibonacci",
                fillColor: "rgba(220,220,220,0.2)",
                strokeColor: "rgba(220,220,220,1)",
                pointColor: "rgba(220,220,220,1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(220,220,220,1)",
                data: [2000, 340, 550, 7000, 10000, 0, 1700]
            }
        ]
    };
    var ctx = document.getElementById("lineChart").getContext("2d");
    var options = { };
    var lineChart = new Chart(ctx).Line(data, options);
  }


  </script>
</body>

</html>