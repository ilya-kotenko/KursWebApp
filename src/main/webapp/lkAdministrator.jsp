<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.simplewebapp.classes.MsgBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ArrayList<MsgBox> msgs = (ArrayList<MsgBox>) request.getAttribute("msgs");%>
<html lang="en">
<head>
	<title>Личный кабинет</title>
	<link rel="stylesheet" type="text/css" href="css/responsive.css">
</head>
<body>
	  <input type="hidden" id="status" value="<%=request.getAttribute("status") %>">
        <script type="text/javascript">
        var status = document.getElementById("status").value;
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
      <h4>Сообщения пользователей</h4>
      <p class="thumbnail_align"> 
  	  <table class="table">
	<thead>
		<tr>
			<th>Пользователь</th>
			<th>Сообщение</th>
		</tr>
	</thead>
	<tbody>
		<%for(int i = 0; i < msgs.size(); i++){
       		MsgBox msg = msgs. get(i);%>
		<tr>
			<td><%=msgs.get(i).getNickname() %></td>
			<td><%=msgs.get(i).getMsg() %></td>
		</tr>
		<%} %>
	</tbody>
</table>
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