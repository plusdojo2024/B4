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