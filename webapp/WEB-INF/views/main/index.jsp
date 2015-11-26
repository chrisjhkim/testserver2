<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<title>testServer</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">

<link href="/testserver2/assets/css/main.css" rel="stylesheet" type="text/css">

</head>
<body>
	<div id="outerwrap">
		<div id="header"><h1>Hello testserver2 index.jsp!!</h1><br></div>
		<div id="main">
			<a href = "/testserver2/joinform">가입시키기</a><br>
			<a href = "">(로그인)</a><br>
			<a href = "">()로그아웃)</a><br>
			<a href = "/testserver2/userlist">User목록</a><br>
			<a href = "/testserver2/grouplist">그룹목록</a><br>
			<a href = "/testserver2/groupjoinform">그룹 가입</a><br>
		</div>
		<div id="footer"> Footer part <br></div>
	</div>
</body>
</html>
