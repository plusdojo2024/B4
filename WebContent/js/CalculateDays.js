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


	//今週の予算


	//画面読み込み完了時に実行するJavaScriptを書く
	//実行するのはcalculate_budget()

	  window.onload = function calculateBudget() {
	// 収入の5分の1（週換算なので）
	  let income = parseFloat(document.getElementById('income')) / 5;
	 console.log(income);
	// 固定費（今回は時間がないため、変動不可）
	  let cost = 25000;
	// 勝手にひかれる分（上と同じく）
	  let targetsavings = 10000;
	//週の使用金額
	  let UsedsWeek = ${sum};
	  console.log(UsedsWeek);
	let Used = income - cost - targetsavings - UsedsWeek;
	 console.log(Used);
	document.getElementById("Used").innerText = Used + '円';
	}