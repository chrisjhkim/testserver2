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
				<th>userNo</th>
				<th>userId</th>
				<th>userName</th>
				<th>userPhoneId</th>
				<th>userType(User Table)</th>
				<th>userRole(GroupUser Table)</th>
			
			</tr>
		<c:forEach items='${userHashMapList }' var='vo'>
			<tr>
				<td>${vo.USERNO }</td>
				<td>${vo.USERID }</td>
				<td>${vo.USERNAME }</td>
				<td>${vo.USERPHONEID }</td>
				<td>${vo.USERTYPE }</td>
				<td>${vo.GROUPROLE }</td>
			</tr>		
		</c:forEach>
	</table>

	<table>
		<tr>
			<th>qNo</th> 
			<th>userNo</th>
			<th>질문자</th>
			<th>type</th>
			<th>question</th>
			<th>date</th>
		</tr>
		<c:forEach items='${qList }' var='vo'>
		<tr>
			<td> ${vo.QNAQNO }</td>
			<td>${vo.FROMUSERNO}</td>
			<td>${vo.USERNO}</td>
			<td>${vo.QUESTIONTYPE}</td>
			<td><a href="/testserver2/a-list-by-qno?qNo=${vo.QNAQNO }">${vo.QUESTION}</a></td>
			<td>${vo.CREATEDDATE}</td>
		</tr>
		</c:forEach>
	</table> 
	
</body>
</html>
