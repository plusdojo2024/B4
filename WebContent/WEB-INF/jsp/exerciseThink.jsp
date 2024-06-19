<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>運動逆算</title>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/exerciseThink.css">

</head>

<body>
  <main class="wrapper">

     <!--目標を入力する  -->
    <form method="post" action="/B4/ExerciseThinkServlet">
        <input type="text" name="keyword" value="何" class="form">
        <select name="period" class="form">
            <option value="1">ヵ月</option>
            <option value="2">週</option>
            <option value="3">日</option>
        </select>
        <span class="green">後に</span>
        <input type="text" name="target" value="何" class="form">
        <span class="green">kg痩せる</span>
    </form>

    <!-- 必要運動量や運動結果を表示 hero-->
    <div class="hero">
    	<div class="hero-in orange">
        	<h1>
                必要時間
                <span class="hero-exercise">歩き${exercise_name}</span>
                <span class="hero-time">１５分 ${time_by_exercise}</span>
            </h1>
        </div>
        <hr>
        <div class="hero-in orange">
        	<h1>一日 3${momentum}Ex 必要</h1>         <!-- データで変化にあとで変える -->
         	<p>本日の運動量 1${today_exercise}Ex</p>       <!-- データで変化にあとで変える -->
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
                            <input type="text" name="now_weight" value="${weight}" id="kg" class="form orange" placeholder="現在の体重" readonly><br> <!--既存の体重 -->

                            <label class="popup-text orange" for="change">変更 </label><br>
                            <input type="text" name="now_weight" id="change"  class="form orange" >
                            <span class="orange">kg</span>

                            <button type="submit" name="submit" class="form-button">変更</button>
                        </form>
                        <!-- ポップアップを閉じる -->
                            <label class="popup-close" for="popup">
                                <svg width="18" height="18" xmlns="http://www.w3.org/2000/svg">
                                    <line x1="0" y1="0" x2="18" y2="18" stroke="white" stroke-width="3"></line>
                                    <line x1="0" y1="18" x2="18" y2="0" stroke="white" stroke-width="3"></line>
                                </svg>
                            </label>
                    </div>
                </div>
    </div>

     <!--行う運動の種類を選択  -->
     <form method="post" action="/B4/ExerciseThinkServlet">
        <select name="exercise_pulldown" class="pulldown form" >
            <option value="walking">歩き</option>
            <option value="running">ランニング</option>
            <option value="workout">筋トレ</option>
        </select>
   

    <!-- タイマーを表示 -->
        <div class="timer">
        <!-- 計測時間を表示 -->
            <div id="time">00:00.00</div>
            <!-- 開始・一時停止・完了ボタン -->
            <div>
                <button type="button" id="start" onclick="start()">開始</button>
                <button type="button" id="stop" onclick="stop()" disabled>一時停止</button>
                <button type="submit" id="reset"  orm="button"f onclick="reset()" disabled>完了</button>
            </div>
        </div>
    </form>
    <!-- <form id="button"></form> -->

   


    <hr>

    <!-- 運動量結果のグラフを表示 -->
    <h1 class="green">運動量</h1>
    <form method="post" action="/B4/ExerciseThinkServlet">
        <select name="graph_menu">
            <option value="1">年（月）</option>
            <option value="2">週（曜日）</option>
            <option value="3">日（時間）</option>
        </select>
    </form>
    <canvas class="graph"></canvas>


    <!-- 病気リストを表示 tdの部分を変化させる-->
    <h1 class="green">病気リスト</h1>
    <div class="plan-list three-columns green">
        <table>
            <tr>
                <th>糖尿病</th>
                <td>50％ ${risk}</td>
                <td>-456万円 ${disease_money}</td>
            </tr>
            <tr>
                <th>病</th>
                <td>50％ ${risk}</td>
                <td>-456万円 ${disease_money}</td>
            </tr>
            <tr>
                <th>病</th>
                <td>50％ ${risk}</td>
                <td>-456万円 ${disease_money}</td>
            </tr>
        </table>
    </div>

  </main>

  <script src="js/exerciseThink.js"></script>
  <!-- <script src="js/graph.js"></script> -->


</body>

</html>