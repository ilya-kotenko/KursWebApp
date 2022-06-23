<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<html lang="en">
<head>
	<title>Зарегистрироваться</title>
	<link rel="stylesheet" type="text/css" href="css/responsive.css">
</head>
<body>
	 <input type="hidden" id="status" value="<%=request.getAttribute("status")%>">
	 <script type ="text/javascript">
var status = document.getElementById("status").value;
if (status == "success"){
	alert("Поздравляем с регистрацией");
	window.location.href = 'index.jsp';
}
if (status == "voidErr"){
	alert("Заполните все поля!");
}
if (status == "passwordErr"){
	alert("Проверьте идентичность паролей!");
}
if (status == "failed"){
	alert("Регистрация закончилась с ошибкой!");
}
if (status == "bdErr"){
	alert("Сервер недоступен, повторите попытку позже!");
}
if (status == "userErr"){
	alert("Пользователь существует!");
}
</script>
	<section class="hero">
		<header>
			<div class="wrapper">
				<a href="index.jsp"><img src="img/logo.png" class="logo" alt="" titl=""/></a>
								<nav>
					<ul>
						<li><a href="index.jsp">На главную</a></li>
						<li><a href="login.jsp">Войти</a></li>
					</ul>
				</nav>
			</div>
		</header>
			<section class="caption">
    <article class="left_article">
		<br>
      <h3>Регистрация</h3>
      <p> 
      <form id="registration" method="post" action="registration">
    <p>
      Логин:<br>
      <input type="text" size="20" maxlength="40"id="login" name="login">
    </p>
    <p>
      Пароль:<br>
      <input type="password" size="20" maxlength="40" id="password" name="password">
    </p>
    <p>
      Повторите пароль:<br>
      <input type="password" size="20" maxlength="40" id="password2" name="password2"> 
    </p>
    <p>
      Имя, видимое другим (никнейм):<br>
      <input type="text" size="20" maxlength="40" id="nickname" name="nickname">
    </p>
    <p>
      <input type="submit" value="Зарегистрироваться" id="signup" name="signup">
    </p>    
   </form>
		</p>
    </article>
	</section>
	</section>
	<footer>
		<div class="copyrights wrapper">
			Copyright © 2015 Котенко ИФСТ-4з. All Rights Reserved.
		</div>
	</footer>
</body>
</html>