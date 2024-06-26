<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>status</title>
<link rel="stylesheet" href="css/status.css">
<link rel="stylesheet" href="css/common.css">
</head>
<body>
<div class="group">
<ul>
    <li class = "status">
    <div class="display-flex">
    <div class="orenzi">継続力</div>
      <div class="iro1">${status.keizoku_rank} ${status.keizoku}</div></div>
</li>
<li class = "status">
    <div class="display-flex">
      <div class="orenzi">修正力</div>
          <div class="iro">${status.shusei_rank } ${status.shusei}</div></div>
</li>
<li class = "status">
    <div class="display-flex">
      <div class="orenzi">時間管理</div>
          <div class="iro">${status.jikan_rank } ${status.jikan}</div></div>
</li>
<li class = "status">
    <div class="display-flex">
      <div class="orenzi">貯金</div>
          <div class="iro">${status.chokin_rank } ${status.chokin}</div></div>
</li>
<li class = "status">
    <div class="display-flex">
      <div class="orenzi">体力</div>
          <div class="iro">${status.tairyoku_rank } ${status.tairyoku}</div></div>
</li>
<li class = "status">
    <div class="display-flex">
      <div class="orenzi">貢献力</div>
          <div class="iro">${status.kouken_rank } ${status.kouken}</div></div>
</li>
    </ul>
</div>

</body>

<body>
    <div class="box1">
	<img src = ${ filePath } alt ="img" width=200>
   <form action="/B4/StatusServlet" method="post" enctype="multipart/form-data">
        <input type="file" name="imageFile">
        <input type="submit" value="アップロード">
    </form>

     ログインID:<br>
     体重:<br>

       <div class="password--">
        <a href="#" class="btn-square-soft">チャンス</a>
        <a href="#" class="btn-square-soft">管理職人</a>
        <a href="#" class="btn-square-soft">時間管理</a>
        <a href="#" class="btn-square-soft">ムード</a>

	    </div>
	    </div>
	     </body>




<!--点線-->
<div class="wrapper">
  <p class="txt txt01">



      <p><!--コメント-->
        <h1 class="green">コメント</h1>
        <div class="comment">
          <p>昨日と比べて<span>継続は５</span>下がった</p>
          <p><span>修正力は３</span>下がった</p>
        </div>
      </div>

  <h3>未来予想シュミレータ</h3>
  <div class="display-flex">
  </div>

  <div class="chart-container">
	<canvas id="Chart" class = "chart"></canvas>
</div>


<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="/B4/js/statusGraph.js"></script>
</html>


