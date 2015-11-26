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

</head>
<body>
	welcome to alist.jsp<br>
	질문 : ${qInfo.QUESTION }<br>
	질문자 : ${qInfo.USERNAME  } <br>
	${qInfo.CREATEDDATE }
	<table>
		<tr>
			<th>userNo</th>
			<th>userName</th>
			<th>answer</th>
		</tr>
		<c:forEach items='${aList }' var='vo'>
			<tr>
				<td>${vo.USERNO }</td>
				<td>${vo.USERNAME }</td>
				<td>${vo.ANSWER }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
