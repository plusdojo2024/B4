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
  <div class="signup">
    <h2 class="form-title" id="signup"><span>or</span>Sign up</h2>
    <div class="form-holder">
      <input type="text" class="input" placeholder="Name" />
      <input type="email" class="input" placeholder="Email" />
      <input type="password" class="input" placeholder="Password" />
    </div>
    <button class="submit-btn">Sign up</button>
  </div>
  <div class="login slide-up">
    <div class="center">
      <h2 class="form-title" id="login"><span>or</span>Log in</h2>
      <div class="form-holder">
        <input type="email" class="input" placeholder="Email" />
        <input type="password" class="input" placeholder="Password" />
      </div>
      <button class="submit-btn">Log in</button>
    </div>
  </div>
</div>
<script src="/B4/js/login.js"></script>
</body>
</html>

