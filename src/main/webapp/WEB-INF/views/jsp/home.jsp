<!doctype html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html xmlns:th="http://www.thymeleaf.org">
<head>
	<title>Bat Chat</title>
	<spring:url value="resources/css/bootstrap.css" var="bootstrapcss"/>
	<spring:url value="resources/css/style.css" var="stylecss"/>
	<spring:url value="resources/js/jquery-1.11.3.min.js" var="jqueryjs"/>
	<spring:url value="resources/js/bootstrap.js" var="bootstrapjs"/>
	<link rel="stylesheet" type="text/css" href="${bootstrapcss}"/>
	<link rel="stylesheet" type="text/css" href="${stylecss}"/>
	<script type="text/javascript" src="${jqueryjs}"></script>
	<script type="text/javascript" src="${bootstrapjs}"></script>
</head>

<script type="text/javascript">
	roomname = '#!ROOMNAME!#';

	function messageInputKeyCheck( keyboardInfo ){
		if( keyboardInfo.keyCode == 13 ) messageSend();
	}

	function messageSend(){
		document.getElementById('messageInput').value = ''
	}
</script>

<body id="thebody">

	<!-- Navigation bar !-->
	<div class="navbar navbar-static navbar-inverse navbar-fixed-top" id="navbar">
		<div class="navbar-inner">
			<div class="container" style="width: auto;">
				<a class="brand" style="color: #fff;"> &nbsp;Bat Chat</a>
				<ul class="nav" role="navigation">
					<li class="dropdown" align="left">
						<a class="dropdown-toggle" role="button" data-toggle="dropdown" style="color: #fff;">
							<i class="icon-th-list icon-white"></i>
							Rooms
							<b class="caret"></b>
						</a>
						<ul class="dropdown-menu" role="menu">
							<li>
								<a href="#!FULLROOMLISTLINK!#" tabindex="-1">
									<i class="icon-th-list"></i>
									Room List
								</a>
							</li>
							<li>
								<a href="!#MYROOMLISTLINK#!" tabindex="-1">
									<i class="icon-user"></i>
									My Rooms
								</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="!#CREATEROOMLINK#!" tabindex="-1">
									<i class="icon-plus"></i>
									Create Room
								</a>
							</li>
						</ul>
					</li>
				</ul>
				#!ADMINTOOLSLIST!#
				<ul class="nav pull-right" role="navigation">
					<li class="dropdown" align="left">
						<a class="dropdown-toggle" id="username" role="button" data-toggle="dropdown"  style="color: #fff;">
							<i class="icon-user icon-white"></i>
							#!USERNAME!#
							<b class="caret"></b>
						</a>
						<ul class="dropdown-menu" role="menu">
							<li>
								<a href="#!USERINFOLINK!#" tabindex="-1">
									<i class="icon-user"></i>
									User Info
								</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="#!LOGOUTLINK!#" tabindex="-1">
									<i class="icon-remove"></i>
									Log Out
								</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<!-- Content !-->
	<div class="container">
		<div class="span12" id="allcontent">
			<h3 id="roomname">
				Room #!ROOMNAME!#
			</h3>
			<div class="container">
				<div class="well span8" style="height: 400px; overflow-y: scroll; text-align: left; word-wrap: break-word;" id="messagelist">
					<jsp:useBean id="test" class="com.vladimercury.MessageBean"/>
                    <jsp:getProperty name="test" property="message"/>
				</div>
				<div class="well span2" style="height:400px; overflow-y: scroll; overflow-x: scroll; font-size: 9pt; text-align: left;" id="roomuserlist">
					#!USERLIST!#
				</div>
				<div class="container" id="messageform">
				    <form action="#" th:action="@{/msg}" th:object="${msg}" method="post">
					    <input type="text" class="span8 search-query" id="messageInput" placeholder="Your message" th:field="*{content}" />
					    <input type="submit" class="btn btn-primary" id="messagesubmit" value="Send" />
				    </form>
				</div>
			</div>
		</div>
	</div>

</body>

</html>