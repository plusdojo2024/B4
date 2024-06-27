<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<title>status</title>
	<link rel="stylesheet" href="css/status.css">
	<link rel="stylesheet" href="css/common.css">
</head>

<body>
<main>
<div class="user-status">
	<div class="group">
	<table>
	    <tr class = "status">
<!-- 	    <div class="display-flex"> -->
	    <th class="orenzi">継続力</th>
	      <td class="iro1">${status.keizoku_rank} ${status.keizoku}</td>
		</tr>
		<tr class = "status">
	      <th class="orenzi">修正力</th>
	          <td class="iro">${status.shusei_rank } ${status.shusei}</td>
		</tr>
		<tr class = "status">
	      <th class="orenzi">時間管理</th>
	          <td class="iro">${status.jikan_rank } ${status.jikan}</td>
		</tr>
		<tr class = "status">
	      <th class="orenzi">貯金</th>
	          <td class="iro">${status.chokin_rank } ${status.chokin}</td>
		</tr>
		<tr class = "status">
	      <th class="orenzi">体力</th>
	          <td class="iro">${status.tairyoku_rank } ${status.tairyoku}</td>
		</tr>
		<tr class = "status">
	      <th class="orenzi">貢献力</th>
	          <td class="iro">${status.kouken_rank } ${status.kouken}</td>
		</tr>
	 </table>
	</div>


    <div class="box1">
	<img src = ${ filePath } alt ="img" width=200>
   <form action="/B4/StatusServlet" method="post" enctype="multipart/form-data" class=upd>
        <input type="file" name="imageFile" class="update">
        <input type="submit" value="アップロード">
    </form>

     ログインID: yazima_go<br>
     体重: 60 kg<br>

       <div class="password">
        <a href="#" class="btn-square-soft">チャンス</a>
        <a href="#" class="btn-square-soft">管理職人</a>
        <a href="#" class="btn-square-soft">時間管理</a>
        <a href="#" class="btn-square-soft">ムード</a>

	    </div>
	    </div>
</div>




<!--点線-->
<div class="wrapper">
  <p class="txt txt01">

      <p><!--コメント-->
        <h1 class="green">コメント</h1>
        <div class="comment">
          <p class="com">昨日と比べて</p>
          <p><span class="red">継続は５</span>下がった</p>
          <p><span class="red">修正力は３</span>下がった</p>
        </div>
      </div>

  <h1 class="orange">未来予想シュミレータ</h1>
  <div class="display-flex">
  </div>

  <div class="chart-container">
	<canvas id="Chart" class = "chart"></canvas>
</div>

</main>
</body>


<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="/B4/js/statusGraph.js"></script>
</html>


