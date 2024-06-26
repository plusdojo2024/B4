/**
 *
 */

 'use strict'

 	 function calculateDays() {
		let num1 = parseInt(document.getElementById('number1').value);
		// 数値入力
		let YearOrMonth = parseFloat(document.getElementById('YearOrMonth').value);
		// 月（30日）か年（365日）の選択された方
		let product = num1 * YearOrMonth;
		// 上記をかけて、期間（日数）を出す。
		let dt = new Date();
		dt.setDate(dt.getDate() + product);
		// 今日の日付に足して、最終日を割り出し。
		document.getElementById('finalDate').value = dt.toISOString()
				.split('T')[0];
		// 最終日を表示
	}

	//今週の予算


	//画面読み込み完了時に実行するJavaScriptを書く
	//実行するのはcalculate_budget

	  window.onload = function calculateBudget() {
	  let income = parseFloat(document.getElementById('income')) / 5;// 収入の5分の1（週換算なので）
	 console.log(income);
	  let cost = 25000;// 固定費（今回は時間がないため、変動不可）
	  let targetsavings = 10000;	// 勝手にひかれる分（上と同じく）
	 // let UsedsWeek = ${sum};	//週の使用金額()
	  console.log(UsedsWeek);
	let Used = income - cost - targetsavings - UsedsWeek;
	 console.log(Used);
	document.getElementById("Used").innerText = Used + '円';
	}

	//投資グラフ
	//グラフ表示するスクリプト全体をページを読み込んだ時に
	//自動的に動作するようにする
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
	          console.log(totalInvestment);
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
	      })