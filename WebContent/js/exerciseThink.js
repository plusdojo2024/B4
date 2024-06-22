/**
 *
 */
 // 目標期間を送る
         function calculateDays() {
            var num1 = parseFloat(document.getElementById('number1').value);
            // 数値入力
            var YearOrMonth = parseFloat(document.getElementById('YearOrMonthOrWeek').value);
            // 月（30日）か年（365日）の選択された方
            var product = num1 * YearOrMonth;
            // 上記をかけて、期間（日数）を出す。
            var dt = new Date();
            dt.setDate(dt.getDate() + product);
            // 今日の日付に足して、最終日を割り出し。
            document.getElementById('finalDate').value = dt.toISOString().split('T')[0];
            // 最終日を表示
        }

// タイマー
var startButton;    // startボタン
var stopButton;     // stopボタン
var resetButton;    // resetボタン
var showTime;       // 表示時間

var timer;              // setinterval, clearTimeoutで使用
var startTime;          // 開始時間
var elapsedTime = 0;    // 経過時間
var holdTime = 0;       // 一時停止用に時間を保持

startButton = document.getElementById("start");
stopButton = document.getElementById("stop");
resetButton = document.getElementById("reset");
showTime = document.getElementById("time");
submitButton = document.getElementById("submit");


startButton.addEventListener('click',function(){
    // 開始時間を現在の時刻に設定
    startTime = Date.now();

    // 時間計測
    measureTime();

    startButton.disabled = true;
    stopButton.disabled = false;
    resetButton.disabled = false;
    submitButton.disabled = false;
    }
,false);

stopButton.addEventListener('click',function(){
    // タイマー停止
    clearInterval(timer);

    // 停止時間を保持
    holdTime += Date.now() - startTime;

    startButton.disabled = false;
    stopButton.disabled = true;
    resetButton.disabled = false;
    submitButton.disabled = false;
    }
,false);

resetButton.addEventListener('click', function () {
    // タイマー停止
    clearInterval(timer);

    // 送信処理（時間を送信するなど）



    // ここに追加のコードを書く

    // 変数、表示を初期化
    elapsedTime = 0;
    showTime.textContent = "00:00.00";
	holdTime =0;
    startButton.disabled = false;
    stopButton.disabled = true;
    resetButton.disabled = true;
    submitButton.disabled = false;
}, false);


// 時間を計測（再帰関数）
function measureTime() {
    // タイマーを設定
    timer = setTimeout(function () {
        // 経過時間を設定し、画面へ表示
        elapsedTime = Date.now() - startTime + holdTime;
        showTime.textContent = new Date(elapsedTime).toISOString().slice(14, 23);

		//idが「laptime」の要素のvalueに計測時間をいれる
		let laptime = document.getElementById("laptime");
		laptime.value=elapsedTime;

        // 関数を呼び出し、時間計測を継続する
        measureTime();
    }, 10);
}