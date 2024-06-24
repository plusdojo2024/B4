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
