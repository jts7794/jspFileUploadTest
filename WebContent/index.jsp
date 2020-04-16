<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP FILE UPLOAD</title>
</head>
<body>
										<!-- multipart request클래스와 매칭이 된다 -->
	<form action="uploadAction.jsp" method="post" enctype="multipart/form-data">
		FILE : <input type="file" name="file"><br>
		<input type="submit" value="UPLOAD"><br>
	</form>
</body>
</html>