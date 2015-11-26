<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
<title>testServer</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">

<link href="/testserver2/assets/css/main.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/testserver2/assets/js/jquery/jquery-1.9.0.js"></script>
</head>
<body>
	Hello testserver2 userlist.jsp!!!!<br>
	
	<table>
			<tr>
				<th>groupNo </th>
				<th>groupName </th>	
				<th>groupRole </th>	
			</tr>	
		<c:forEach items='${groupList }' var="vo">
			<tr>
				<td>${vo.GROUPNO}</td>	
				<td>${vo.GROUPNAME}</td>	
				<td>${vo.GROUPROLE}</td>	
			</tr>
		</c:forEach>
	</table>
	<table>
			<tr>
				<th>groupName</th>
				<th>질문자No</th>
				<th>질문자</th>
				<th>질문No</th>
				<th>질문</th>
				<th>대답</th>
			<tr>
		<c:forEach items='${aList}' var="vo">
			<tr>
				<td>${vo.GROUPNAME }</td>
				<td>${vo.QUESTIONERNO }</td>
				<td>${vo.QUESTIONER}</td>
				<td>${vo.QNAQNO}</td>
				<td>${vo.QUESTION}</td>
				<td>${vo.ANSWER}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
