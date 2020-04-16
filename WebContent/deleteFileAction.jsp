<%@page import="java.net.URLEncoder"%>
<%@ page import="java.io.File" %>
<%@ page import = "file.FileDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
	String directory = application.getRealPath("/upload/");
	//System.out.print("deletefileaction : " + directory);
	
	String file = request.getParameter("fileRealName");
	
	FileDAO fileDAO = new FileDAO();
	int result = fileDAO.deleteFile(file);

	File delFile = new File(directory +"/" + file);

	//해당 파일이 존재하면 삭제
    if (delFile.isFile()) {
        delFile.delete();
    }
	
    %>
	<script type="text/javascript">
	alert('삭제 성공.');
	location.href = 'fileDownload.jsp';
	</script>
</body>
</html>