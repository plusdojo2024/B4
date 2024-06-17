  const day = document.getElementById('dayChart').getContext('2d');
  for (let i = 0; i <= 24; i++) {
    days.push(i + '時');
  }
  const days = [];
  const week = document.getElementById('weekChart').getContext('2d');
  const weeks = ['日', '月', '火', '水', '木', '金', '土'];
  const month = document.getElementById('monthChart').getContext('2d');
  const monthes = [];
  for (let i = 1; i <= 12; i++) {
    monthes.push(i + '月');
  }
  const dayMoment = [];
  const weekMoment = [];
  const monthMoment = [];

  //時間ごと、週ごと、月ごと、dateで区切って一日取得、取得、月ごと取得

  //ここで三つの運動量を完成させる
  fetch('ExerciseThinkServlet')
  .then(response => response.json()) // JSONデータをJavaScriptオブジェクトに変換、、
  .then(data => {
    dayMoment.moments = data;

            const userListElement = document.getElementById('userList');
        data.forEach(user => {
            const listItem = document.createElement('li');
            listItem.textContent = `${user.name} (Age: ${user.age})`;
            userListElement.appendChild(listItem);
        });

  });
  //ここまで

  const dayChart = new Chart(day, {
    type: 'line', // グラフの種類を指定
    data: {
        labels: days, // days をラベルとして使用する場合（days が配列である必要があります）
        datasets: [{
            label: '運動量',
            data: dayMoment, // dayMoment をデータとして使用する場合
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
            data: weekMoment, // dayMoment をデータとして使用する場合
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
            data: monthMoment, // dayMoment をデータとして使用する場合
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

