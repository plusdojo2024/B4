<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>運動逆算</title>
 <link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/exerciseThink.css">
<!--  <style> input[type="hidden"] { display: none; } </style> -->
</head>

<body>
	<header>
			<!--ヘッダー読み込み-->
	</header>

  <main class="wrapper">

<div class="body">
     <!--目標を入力する  -->
    <form method="post" action="/B4/ExerciseThinkServlet"  class="form green">
    	<p>
	        <input type="number" name="target" id="number1" value="${current.length }">
	        <select name="form" class="form" id="YearOrMonth">
	        	<option value="365">年</option>
	            <option value="30">ヵ月</option>
	            <option value="7">週</option>
	        </select>
	        <span class="green">後に</span>
	        <br>
	        <input type="text" name="target_weight" class="form" placeholder="" value="${current.target_weight}">
	        <span class="green"> kgに痩せる </span>
	        <input type="hidden" id="finaldate" name="weight_period" >
				 <input type="submit" value="設定"
				 style="background-color: var(- -dark-green); margin-left: 0.5rem; width: 3rem;">
		</p>
	</form>

    <!-- 必要運動量や運動結果を表示 hero-->
    <div class="hero">
    	<div class="hero-in orange">
        	<h1>
                必要時間
                <span class="hero-exercise">歩き</span>
                <span class="hero-time">${time_by_exercise} 分</span>
            </h1>
        </div>
        <hr>
        <div class="hero-in orange">
        	<h1>一日 ${daily_required_exercise}Ex 必要</h1>         <!-- データで変化にあとで変える -->
         	<p>本日の運動量 1${sum}Ex</p>       <!-- データで変化にあとで変える -->
        </div>
    </div>

    <!-- 現在体重のクリックとポップ -->
     <!-- 現在体重のクリック部分 -->
    <div class="popup-all">
        <input type="checkbox" id="popup" class="popup">
            <label class="popup-open" for="popup">＜現在体重</label>
                <div class="popup-overlay">  <!--背景 -->
                    <!-- ポップアップの本体部分 -->
                    <div class="popup-window">
                        <form method="post" action="/B4/ExerciseThinkServlet">
                            <label class="popup-text orange" for="kg">現在体重</label><br>
                            <input type="text" name="now_weight" value="${weight}" id="kg" class=" weight"  readonly><br> <!--既存の体重 -->

                            <label class="popup-text orange" for="change">変更 </label><br>
                            <input type="text" name="target_weight" id="change"  class=" weight" >
                            <span class="orange">kg</span>

                            <input type="submit"value="変更" name="submit" class="form-button">
                        </form>
                        <!-- ポップアップを閉じる -->
                            <label class="popup-close" for="popup">
							<svg width="20" height="20" xmlns="http://www.w3.org/2000/svg">
								<line x1="0" y1="0" x2="20" y2="20" stroke="white" stroke-width="6"></line>
								<line x1="0" y1="20" x2="20" y2="0" stroke="white" stroke-width="6"></line>
								</svg>
							</label>
                    </div>
                </div>
    </div>

     <!--行う運動の種類を選択  -->
     <form method="post" action="/B4/ExerciseThinkServlet">
        <select name="exercise_pulldown" class="pulldown form" >
            <option value="3.5">歩き</option>
            <option value="7.0">ランニング</option>
            <option value="5.0">筋トレ</option>
        </select>


    <!-- タイマーを表示 -->
        <div class="timer">
        <!-- 計測時間を表示 -->
            <div id="time">00:00.00</div>
            <!-- 開始・一時停止・完了ボタン -->
            <div class="bottons">
                <button type="button" id="start" class=time-button>開始</button>
                <button type="button" id="stop"  disabled class=time-button>一時停止</button>


				<button type="button" id="reset"  disabled class=time-button>リセット</button>
				<input type="submit" name="submit" id="submit" disabled value="登録" class=time-button>
				<input type="hidden" id="laptime" name="laptime" value="">
            </div>
        </div>
    </form>

</div>
    <hr>
<div class="body">
    <!-- 運動量結果のグラフを表示 -->
    <h1 class="green">運動量</h1>
    <form method="post" action="/B4/ExerciseThinkServlet">
        <select name="graph_menu">
            <option value="1">年（月）</option>
            <option value="2">週（曜日）</option>
            <option value="3">日（時間）</option>
        </select>
    </form>

<div class="chart-container">
    <canvas id="dayChart"></canvas>
</div>
 <div class="chart-container">
	<canvas id="weekChart" class = "chart" ></canvas>
</div>
<div class="chart-container">
	<canvas id="monthChart" class = "chart"></canvas>
</div>

<div style="display:none">
<c:forEach var="e" items="${dayList}" varStatus="status">
	<form method="POST" action="/B4/ExerciseThinkServlet" class = gragh>
		<input type="hidden" id="momentDay${status.index}"
			value="${e}"><br>
		<input  type="hidden" class="day_${status.last}" id = "${status.index}" value = "${status.index}"><br>
	</form>
</c:forEach>
<c:forEach var="e" items="${weekList}" varStatus="status">
	<form method="POST" action="/B4/ExerciseThinkServlet" class = gragh>
		<input type="hidden" id="momentWeek${status.index}"
			value="${e}"><br>
		<input  type="hidden" class="week_${status.last}" id = "${status.index}" value = "${status.index}"><br>
	</form>
</c:forEach>
<c:forEach var="e" items="${yearList}" varStatus="status">
	<form method="POST" action="/B4/ExerciseThinkServlet" class = gragh>
		<input type="hidden" id="momentMonth${status.index}"
			value="${e}"><br>
		<input  type="hidden" class="month_${status.last}" id = "${status.index}" value = "${status.index}"><br>
	</form>
</c:forEach>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="/B4/js/momentGraph.js"></script>



    <!-- 病気リストを表示 tdの部分を変化させる-->
    <h1 class="warning-comment">⚠️ 病気(運動不足)リスト</h1>
    <div class="plan-list three-columns">
        <table>
            <tr>
                <th>心臓病</th>
                <td> ${rank[0]}％</td>
                <td>${dlList[0].disease_money}万円</td>
            </tr>
            <tr>
                <th>糖尿病</th>
                <td> ${rank[1]}％</td>
                <td>${dlList[1].disease_money}万円</td>
            </tr>
            <tr>
                <th>高血圧</th>
                <td>${rank[2]}％</td>
                <td> ${dlList[2].disease_money}万円</td>
            </tr>
        </table>
    </div>
    </div>

  </main>

  <footer>
			<!--フッター読み込み-->
  </footer>


  <script src="js/exerciseThink.js"></script>
  <!-- <script src="js/graph.js"></script> -->


</body>

</html>