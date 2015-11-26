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
				<th>userNo </th>
				<th>userName </th>	
				<th>userId </th>	
				<th>userType </th>
			</tr>	
		<c:forEach items='${userList }' var="vo">
			<tr>
				<td>${vo.userNo }</td>
				<td><a href="/testserver2/user-info?userNo=${vo.userNo }">"${vo.userName }</a></td>	
				<td>${vo.userId }</td>	
				<td>${vo.userType }</td>	
			</tr>
		</c:forEach>
	</table>
</body>
</html>
