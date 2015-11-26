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
	Hello testserver2 joinform.jsp!!<br>
	<form method='post' action="/testserver2/join">
		<label>이름</label>
		<input name='userName' type='text'><br>
		
		<label>id</label>
		<input name='userId' type='text'><br>
		
		<label>비밀번호</label>
		<input name='userPassword' type='text'><br>
		
		<label>userType</label>
		<input name='userType' type='text'><br>
		
		<input type='submit' value='완료'>
	</form>
</body>
</html>
