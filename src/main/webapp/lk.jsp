<%
if (session.getAttribute("userType") != null){
	response.sendRedirect("lkAdministrator.jsp");
}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<html lang="en">
<head>
	<title>Личный кабинет</title>
	<link rel="stylesheet" type="text/css" href="css/responsive.css">
</head>
<body>
	 <input type="hidden" id="status" value="<%=request.getAttribute("status") %>">
	<script type="text/javascript">
        var status = document.getElementById("status").value;
        if (status == "success"){
			alert("Сообщение отправлено");
			}
		if (status == "voidErr"){
			alert("Заполните все поля!");
		}
		if (status == "failed"){
			alert("Ошибка отправки!");
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
						<li><a href="logout">Выход</a></li>
					</ul>
				</nav>
			</div>
		</header>
			<section class="caption">
    <article class="left_article">
		<br>
		<h4>Пользователь: <%=session.getAttribute("nickname") %></h4>
      <h4>Обратная связь:</h4>
      <p class="thumbnail_align"> 
	  	<form id="addMsg" method="post" action="addMsg">
			<p><textarea form="addMsg" maxlength="256" cols="100" rows="10" id="msg" name="msg"></textarea></p>
			<p><input type="submit" value="Отправить" id="mailTo" name="mailTo"></p>
    	</form>
	  </p>
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