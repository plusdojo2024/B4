console.clear();
window.onload = function() {
    var messageElement = '<%= request.getAttribute("message") %>';;
    if (messageElement && messageElement.textContent.trim().length > 0) {
        alert(messageElement.textContent.trim());
    }
}

const loginBtn = document.getElementById('login');
const signupBtn = document.getElementById('signup');

loginBtn.addEventListener('click', (e) => {
  let parent = e.target.parentNode.parentNode;
  Array.from(e.target.parentNode.parentNode.classList).find((element) => {
    if(element !== "slide-up") {
      parent.classList.add('slide-up')
    }else{
      signupBtn.parentNode.classList.add('slide-up')
      parent.classList.remove('slide-up')
    }
  });
});

signupBtn.addEventListener('click', (e) => {
  let parent = e.target.parentNode;
  Array.from(e.target.parentNode.classList).find((element) => {
    if(element !== "slide-up") {
      parent.classList.add('slide-up')
    }else{
      loginBtn.parentNode.parentNode.classList.add('slide-up')
      parent.classList.remove('slide-up')
    }
  });
});

const passwordFields = document.querySelectorAll(".pas");
const eyeIcons = document.querySelectorAll(".eye-icon");

eyeIcons.forEach((icon, index) => {
    icon.addEventListener("click", function() {
        togglePasswordVisibility(passwordFields[index], icon);
    });
});

function togglePasswordVisibility(passwordField, eyeIcon) {
    if (passwordField.type === "password") {
        passwordField.type = "text";
        eyeIcon.src = "/simpleBC/img/eye-icon-open.png"; // オープンアイコンに変更
    } else {
        passwordField.type = "password";
        eyeIcon.src = "/simpleBC/img/eye-icon.png"; // クローズアイコンに変更
    }
}

document.addEventListener('DOMContentLoaded', function() {
  const signupTitle = document.getElementById('signup'); // 登録のタイトル要素を取得
  const title = document.getElementById('title'); // 登録のタイトル要素を取得
	const login = document.getElementById('login');
  let titleVisible = true; // タイトルの初期表示状態

  // 登録ボタンにクリックイベントを追加
  signupTitle.addEventListener('click', function() {
    if (titleVisible) {
      title.style.display = 'none'; // タイトルを非表示にする
      titleVisible = false; // 表示状態を更新
    } else {
      title.style.display = 'block'; // タイトルを表示する
      titleVisible = true; // 表示状態を更新
    }
  });

    login.addEventListener('click', function() {
		title.style.display = 'block';
		titleVisible = true;
  });
})
