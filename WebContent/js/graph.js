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
    days.push(i + '月');
  }

  const momentDays =[];
  const momentWeeks =[];
  const momentMonthes =[];

  const endDays = document.querySelector(".day_true").value;

for (let i = 0; i < end_count; i++) {
	const momentDay = document.getElementById("momentDay" + i).value;
	momentDays[i]=momentDay;
}

  const dayChart = new Chart(day, {
    type: 'line', // グラフの種類を指定
    data: {
        labels: days, // days をラベルとして使用する場合（days が配列である必要があります）
        datasets: [{
            label: '運動量',
            data: momentDays, // dayMoment をデータとして使用する場合
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
        labels: weeks, // days をラベルとして使用する場合（days が配列である必要があります）
        datasets: [{
            label: '運動量',
            data: momentWeeks, // dayMoment をデータとして使用する場合
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
        labels: monthes, // days をラベルとして使用する場合（days が配列である必要があります）
        datasets: [{
            label: '運動量',
            data: momentMonthes, // dayMoment をデータとして使用する場合
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

-----ここまで
//未来図
  var comPower = document.getElementById('comPower');
  const chart = document.getElementById('Chart').getContext('2d');
  var nensyu = [352,447,511,607];
  const age = [];
  for(let i = 2; i <5 ;i++){
  	age.push( i*10 + '年代');
  }
  age.push('50年代以上');

  var futures = [];
  for(let i = 0;i < nensyu.length();i++){
  	 future = nensyu[i] * compower;
  }

   const aveChart = new Chart(chart, {
    type: 'line', // グラフの種類を指定
    data: {
        labels: age, // days をラベルとして使用する場合（days が配列である必要があります）
        datasets: [{
            label: '予想年収',
            data: nensyu, // dayMoment をデータとして使用する場合
            borderColor: '#17E299',
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
