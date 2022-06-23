<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<html lang="en">
<head>
	<title>Войти</title>
	<link rel="stylesheet" type="text/css" href="css/responsive.css">
</head>
<body>
<input type="hidden" id="status" value="<%=request.getAttribute("status") %>">
	<script type ="text/javascript">
    var status = document.getElementById("status").value;
    if (status == "loginErr"){
      alert("неверный логин или пароль!");
    }
    if (status == "voidErr"){
    	alert("Заполните пустые поля!");
    }
    if (status == "bdErr"){
    	alert("Сервер недоступен, повторите попытку позже!");
    }
    </script>
	<section class="hero">
		<header>
			<div class="wrapper">
				<a href="index.jsp"><img src="img/logo.png" class="logo" alt="" titl=""/></a>
				<nav>
					<ul>
						<li><a href="index.jsp">На главную</a></li>
						<li><a href="registration.jsp">Зарегистрироваться</a></li>
					</ul>
				</nav>
			</div>
		</header>
			<section class="caption">
				<br>
				<h3>Данные входа</h3>
      <p> <form id="registration" method="post" action="login">
    <p>
      Логин:<br>
      <input size="20" maxlength="40" id="login" name="login" type="text">
    </p>
    <p>
      Пароль:<br>
      <input type="password" size="20" maxlength="40" id="password" name="password">
    </p>
    <p>
      <input type="submit" name="signin" id="signin"  value="Войти">
    </p>    
   </form></p>
			</section>
	</section><!--  end hero section  -->
	<footer>
		<div class="copyrights wrapper">
			Copyright © 2015 Котенко ИФСТ-4з. All Rights Reserved.
		</div>
	</footer>
</body>
</html>