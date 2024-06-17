<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>運動逆算</title>
</head>

<body>
    
    <form method="post" action="サーブレット名">
        <input type="text" name="keyword" value="何"　class="form">
        <select name="period" class="form">
            <option value="1">ヵ月</option>
            <option value="2">週</option>
            <option value="3">日</option>
        </select>
        <p class="nobr">後に</p>
        <input type="text" name="target" value="何"　class="form">
        <p class="nobr">kg痩せる</p>
    </form>
    
    <div class="hero">
        <h1>必要時間</h1>
    
         <h1>一日必要</h1>
   
         <p>本日の運動量</p>
    </div>

    <p class="popUp">現在体重</p>

    <form>
        <select name="exercise_pulldown" class="form">
            <option value="1">歩き</option>
            <option value="2">ランニング</option>
            <option value="3">筋トレ</option>
        </select>
        <input type="submit" name="submit" value="更新">
        <input type="submit" name="submit" value="削除"><br>

    </form>

    <hr>

    <h1>運動量</h1>

    <h1>病気リスト</h1>
    <table>

    </table>

</body>

</html>