<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>運動逆算</title>
<link rel="stylesheet" href="/B4/css/ExerciseThink.css">
</head>

<body>
  <main class="wrapper">   

     <!--目標を入力する  -->
    <form method="post" action="/B4/ExerciseThinkServlet">
        <input type="text" name="keyword" value="何"　class="form">
        <select name="period" class="form">
            <option value="1">ヵ月</option>
            <option value="2">週</option>
            <option value="3">日</option>
        </select>
        <span>後に</span>
        <input type="text" name="target" value="何"　class="form">
        <span>kg痩せる</span>
    </form>
    
    <!-- 必要運動量や運動結果を表示 -->
    <div class="hero">
        <h1>必要時間　歩き１５分</h1>　         <!-- データで変化にあとで変える -->
        <h1>一日　3Ex　必要</h1>　         <!-- データで変化にあとで変える -->
         <p>本日の運動量　1Ex</p>            <!-- データで変化にあとで変える -->
    </div>

    <!-- 現在体重のクリックとポップ 　中身コピペをしたので変更する-->
    <input type="checkbox" class="popUp">
        <label class="popup-open" for="popup">現在体重</label>
        <div class="popup-overlay">
            <div class="popup-window">
            <form method="post" action="/B4/ExerciseThinkServlet">
                <label class="popup-text" for="kg">現在体重</label>
                <input type="text" name="now_weight" id="kg" ><br>　<!-- ここを入力できないように直す　既存の現在体重を表示 -->
               
                <label class="popup-text" for="change">変更 </label>
                <input type="text" name="now_weight" id="change" >
                <span>kg</span>
                <button type="submit" name="submit" class="formButton">変更</button>
            </form>
                <label class="popup-close" for="popup">
                    <svg width="18" height="18" xmlns="http://www.w3.org/2000/svg">
                        <line x1="0" y1="0" x2="18" y2="18" stroke="white" stroke-width="3"></line>
                        <line x1="0" y1="18" x2="18" y2="0" stroke="white" stroke-width="3"></line>
                    </svg>
                </label>
            </div>
        </div>
    　
     <!--行う運動の種類を選択  -->
     <form method="post" action="/B4/ExerciseThinkServlet">
        <select name="exercise_pulldown"　class="form">
            <option value="1">歩き</option>
            <option value="2">ランニング</option>
            <option value="3">筋トレ</option>
        </select>

    <!-- タイマーを表示 -->
        <div class="timer">
        <!-- 計測時間を表示 -->
            <div id="time">00:00.000</div>
            <!-- 開始・一時停止・完了ボタン -->
            <div>
                <button id="start" onclick="start()">開始</button>
                <button id="stop" onclick="pause()" disabled>一時停止</button>
                <button id="reset" onclick="complete()" disabled>完了</button>
            </div>
        </div>
     </form>


    <hr>
    
    <!-- 運動量結果のグラフを表示 -->
    <h1>運動量</h1>
    <form method="post" action="/B4/ExerciseThinkServlet">
        <select name="graph_menu">
            <option value="1">月（日数）</option>
            <option value="2">週（曜日）</option>
            <option value="3">日（時間）</option>
        </select>
    </form>
    <canvas class="graph"></canvas>


    <!-- 病気リストを表示 tdの部分を変化させる-->
    <h1>病気リスト</h1>
    <table class="planList">  
        <tr>
            <th>糖尿病</th>
            <td>50％</td>
            <td>-456万円</td>
        </tr>
        <tr>
            <th>病</th>
            <td>50％</td>
            <td>-456万円</td>
        </tr>
        <tr>
            <th>病</th>
            <td>50％</td>
            <td>-456万円</td>
        </tr>


    </table>
  </main>
</body>

</html>