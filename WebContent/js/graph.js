//--アラート機能
window.onload = function() {
    var messageElement = '<%= request.getAttribute("message") %>';;
    if (messageElement && messageElement.textContent.trim().length > 0) {
        alert(messageElement.textContent.trim());
    }
}

//----運動逆算
  const day = document.getElementById('dayChart').getContext('2d');
  const week = document.getElementById('weekChart').getContext('2d');
  const month = document.getElementById('monthChart').getContext('2d');

  const days = [];
  for (let i = 0; i < 24; i++) {
    days.push(i + '時');
  }
  const weeks = ['月', '火', '水', '木', '金', '土','日'];
  const monthes = [];
  for (let i = 1; i <= 12; i++) {
    monthes.push(i + '月');
  }
  const momentDays =[];
  const momentWeeks =[];
  const momentMonthes =[];

  const endDays = document.querySelector(".day_true").value;
  const endWeeks = document.querySelector(".week_true").value;
  const endMonthes = document.querySelector(".month_true").value;
  for (let i = 0; i < endDays; i++) {
	const momentDay = document.getElementById("momentDay" + i).value;
	momentDays.push(momentDay);
}

for (let i = 0; i < endWeeks; i++) {
	const momentWeek = document.getElementById("momentWeek" + i).value;
	momentWeeks.push(momentWeek);
}

for (let i = 0; i < endMonthes; i++) {
	const momentMonth = document.getElementById("momentMonth" + i).value;
	momentMonthes.push(momentMonth);
}


  const dayChart = new Chart(day, {
    type: 'line', // グラフの種類を指定
    data: {
        labels: days,
        datasets: [{
            label: '運動量',
            data: momentDays,
            borderColor: '#FFB13C',
            tension: 0.1 // 折れ線のカーブ率を指定
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
          }
      }
  });

 const weekChart = new Chart(week, {
    type: 'line', // グラフの種類を指定
    data: {
        labels: weeks,
        datasets: [{
            label: '運動量',
            data: momentWeeks,
            borderColor: '#FFB13C',
            tension: 0.1 // 折れ線のカーブ率を指定
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
          }
      }
  });

 const monthChart = new Chart(month, {
    type: 'line', // グラフの種類を指定
    data: {
        labels: monthes,
        datasets: [{
            label: '運動量',
            data: momentMonthes,
            borderColor: '#FFB13C',
            tension: 0.1 // 折れ線のカーブ率を指定
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
          }
      }
  });

//-----未来図



  var comPower = document.getElementById('comPower');
  const chart = document.getElementById('Chart').getContext('2d');
  const age = [];
  for(let i = 2; i <5 ;i++){
  	age.push( i*10 + '年代');
  }
  age.push('50年代以上');

  var nensyu = [352,447,511,607];
  var real = [];
  for(let i = 0;i < nensyu.length;i++){
  	 real.push(nensyu[i] * (1+ 50 * 0.01));
  }
  var best = [];
  for(let i = 0;i < nensyu.length;i++){
  	 best.push(nensyu[i] * 2);
  }
   const aveChart = new Chart(chart, {
    type: 'line',
    data: {
        labels: age, // days をラベルとして使用する場合（days が配列である必要があります）
        datasets: [{
            label: '平均年収',
            data: nensyu,
            borderColor: '#17E299',
            tension: 0.1 // 折れ線のカーブ率を指定
        },{
            label: '現在年収',
            data: real,
            borderColor: '#FFB13C',
            tension: 0.1 // 折れ線のカーブ率を指定
        },{
            label: '最高年収',
            data: best,
            borderColor: '#F81414',
            tension: 0.1 // 折れ線のカーブ率を指定
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
          }
      }
  });

/*   const bestChart = new Chart(chart, {
    type: 'line', // グラフの種類を指定
    data: {
        labels: age,
        datasets: [{
            label: '最高年収',
            data: best,
            borderColor: '#F81414',
            tension: 0.1 // 折れ線のカーブ率を指定
        }]

    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
          }
      }
  });

  const minChart = new Chart(chart, {
    type: 'line', // グラフの種類を指定
    data: {
        labels: age,
        datasets: [{
            label: '現在年収',
            data: real,
            borderColor: '#FFB13C',
            tension: 0.1 // 折れ線のカーブ率を指定
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
          }
      }
  });
*/

//----予算逆算
  const day = document.getElementById('dayChart').getContext('2d');
  const week = document.getElementById('weekChart').getContext('2d');
  const month = document.getElementById('monthChart').getContext('2d');

  const days = [];
  for (let i = 0; i < 24; i++) {
    days.push(i + '時');
  }
  const weeks = ['月', '火', '水', '木', '金', '土','日'];
  const monthes = [];
  for (let i = 1; i <= 12; i++) {
    monthes.push(i + '月');
  }
  const amountDays =[];
  const amountWeeks =[];
  const amountMonthes =[];

  const endDays = document.querySelector(".day_true").value;
  const endWeeks = document.querySelector(".week_true").value;
  const endMonthes = document.querySelector(".month_true").value;
  
  for (let i = 0; i < endDays; i++) {
	const amountDay = document.getElementById("amountDay" + i).value;
	amountDays.push(amountDay);
}

for (let i = 0; i < endWeeks; i++) {
	const amountWeek = document.getElementById("amountWeek" + i).value;
	amountWeeks.push(amountWeek);
}

for (let i = 0; i < endMonthes; i++) {
	const amountMonth = document.getElementById("amountMonth" + i).value;
	amountMonthes.push(amountMonth);
}


  const dayChart = new Chart(day, {
    type: 'line', // グラフの種類を指定
    data: {
        labels: days,
        datasets: [{
            label: '使用金額',
            data: amountDays,
            borderColor: '#FFB13C',
            tension: 0.1 // 折れ線のカーブ率を指定
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
          }
      }
  });

 const weekChart = new Chart(week, {
    type: 'line', // グラフの種類を指定
    data: {
        labels: weeks,
        datasets: [{
            label: '使用金額',
            data: amountWeeks,
            borderColor: '#FFB13C',
            tension: 0.1 // 折れ線のカーブ率を指定
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
          }
      }
  });

 const monthChart = new Chart(month, {
    type: 'line', // グラフの種類を指定
    data: {
        labels: monthes,
        datasets: [{
            label: '使用金額',
            data: amountMonthes,
            borderColor: '#FFB13C',
            tension: 0.1 // 折れ線のカーブ率を指定
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
          }
      }
  });

