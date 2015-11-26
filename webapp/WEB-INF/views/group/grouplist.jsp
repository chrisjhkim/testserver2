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
				<th>groupNo</th>
				<th>groupName</th>
				<th>groupType</th>
			</tr>
		<c:forEach items='${groupList }' var="vo">
			<tr>
				<td>${vo.groupNo }</td>
				<td><a href="/testserver2/groupinfo?groupNo=${vo.groupNo }">${vo.groupName }</a></td>
				<td>${vo.groupType }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
