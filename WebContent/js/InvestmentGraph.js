

	//投資グラフ
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
	  });