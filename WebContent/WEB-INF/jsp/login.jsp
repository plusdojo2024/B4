<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>login</title>
<!--==============���C�A�E�g�𐧌䂷��Ǝ���CSS��ǂݍ���===============-->

<link rel="stylesheet" type="text/css" href="/B4/css/login.css">
<body>
<div class="form-structor">
<!--登録ここから -->
  <div class="signup slide-up">
    <h2 class="form-title" id="signup">登録</h2>
    <form action="/B4/LoginServlet" method="post">
    <div class="form-holder">
    <div class = "password">
      <input name="sid" type="text" class="input" placeholder="ユーザーID" required>
      </div>
      <div class=password>
      <input name="spw"  type="password" class="input pas" placeholder="パスワード" required>
      <img src="/B4/img/eye-icon.png" class="eye-icon" alt="Show Password">
		</div>
		<div class="password">
      <input name="spw2" type="password" class="input pas" placeholder="パスワード（確認用）" required>
      <img src="/B4/img/eye-icon.png" class="eye-icon" alt="Show Password">
	</div>
    </div>
    <button class="submit-btn">登録</button>
    </form>
  </div>
<!--登録ここまで -->

  <h1 id="title">ずぼら塾</h1>

<!--ログインここから -->
  <div class="login slide-up">
  <img src="/B4/img/hito.png" class="hito" alt="Show Password">
    <div class="center">
      <h2 class="form-title" id="login">ログイン</h2>
      <form action="/B4/LoginServlet" method="post">
      <div class="form-holder">
      <div class="password">
        <input name="lid" type="text" class="input" placeholder="ユーザーID" required>
        </div>
        <div class="password">
        <input name="lpw" type="password" class="input pas" placeholder="パスワード" required>
        <img src="/B4/img/eye-icon.png" class="eye-icon" alt="Show Password">
        </div>
      </div>
      	<button type="submit" class="submit-btn">ログイン</button>
      </form>
    </div>
  </div>
  <!--ログインここまで -->
</div>

<script src="/B4/js/login.js"></script>
</body>
</html>

