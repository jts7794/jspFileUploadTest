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
		FILE : <input type="file" name="file1"><br>
		FILE : <input type="file" name="file2"><br>
		FILE : <input type="file" name="file3"><br>
		
		<input type="submit" value="UPLOAD"><br>
	</form>
	<br>
	<a href="fileDownload.jsp">파일 다운로드 페이지</a>
	
</body>
</html>