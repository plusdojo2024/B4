<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width">
<title>予算逆算 | ずぼら塾</title>
<style>
#popup {
  display: none; /* label でコントロールするので input は非表示に */
}

.popUp {
  cursor: pointer; /* マウスオーバーでカーソルの形状を変えることで、クリックできる要素だとわかりやすいように */
}

.popup-overlay {
  display: none; /* input にチェックが入るまでは非表示に */
}

#popup:checked ~ .popup-overlay {
  display: block;
  z-index: 99999;
  background-color: #00000070;
  position: fixed;
  width: 100%;
  height: 100vh;
  top: 0;
  left: 0;
}

.popup-window {
  width: 90vw;
  max-width: 560px;
  padding: 20px;
  background-color: #ffffff;
  border-radius: 6px;
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.popup-text {
  margin: 0;
}

.popup-text:not(:last-of-type) {
  margin-bottom: 1em
}

.popup-close {
  cursor: pointer;
  position: absolute;
  top: -26px;
  right: 0;
}
</style>
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
<label class="popUp" for="popup">詳細</label>
<div class="popup-overlay">
    <div class="popup-window">
        <p class="popup-text">
        <h1>手取り</h1>
        <input type="text" name="income">円
        <hr>
        <div class="total_costs">固定費合計61,490<!-- ここに固定費合計 -->円</div>
        <h1 style="display:inline">固定費</h1> <h2 style="display:inline">金額<h2>
        <!-- ここに固定費別のもの-->
        <ul>
          <li>家賃 50000円</li>
          <li>電気 5000円</li>
          <li>水道代 2000円</li>
          <li>ガス代 3000円</li>
          <li>ネトフリ 1490円</li>
        </ul>
        <input type="text" name="form" placeholder="用途">
        <input type="text" name="form" placeholder="金額">
        <label class="formButton">
          <input type="submit" value="追加">
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
         <label class="formButton">
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