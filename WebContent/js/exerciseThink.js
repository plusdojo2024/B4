/**
 *
 */
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



// ストップボタン押下時
//function stop(){
    // タイマー停止
  //  clearInterval(timer);

    // 停止時間を保持
    //holdTime += Date.now() - startTime;

    //startButton.disabled = false;
    //stopButton.disabled = true;
    //resetButton.disabled = false;
//}

// リセットボタン押下時
//function reset(){
    // タイマー停止
  //  clearInterval(timer);

    // 変数、表示を初期化
    //elapsedTime = 0;
    //holdTime = 0;
    //showTime.textContent = "00:00.00";

    //startButton.disabled = false;
    //stopButton.disabled = true;
    //resetButton.disabled = true;
//}

resetButton.addEventListener('click', function () {
    // タイマー停止
    clearInterval(timer);

    // 送信処理（時間を送信するなど）
        // 停止時間を保持
    holdTime += Date.now() - startTime;


    // ここに追加のコードを書く

    // 変数、表示を初期化
    elapsedTime = 0;
    showTime.textContent = "00:00.00";

    startButton.disabled = false;
    stopButton.disabled = true;
    resetButton.disabled = true;
    submitButton.disabled = true;
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