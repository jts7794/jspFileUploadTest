<%@page import="java.net.URLEncoder"%>
<%@ page import="java.io.File" %>
<%@ page import = "file.FileDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP FILE UPLOAD</title>
</head>
<body>	
	<%
		String directory = application.getRealPath("/upload/");
		//System.out.print("filedownlodad : " + directory);
		
		String files[] = new File(directory).list();
		
		for(String file : files){
			out.write("<a href=\"" + request.getContextPath() + "/downloadAction?file="+
				java.net.URLEncoder.encode(file, "UTF-8") + "\">" + file + "</a>");
			out.write("<a href=\""  + request.getContextPath() + "/deleteFileAction.jsp?fileRealName=" + java.net.URLEncoder.encode(file, "UTF-8") + "\">삭제</a><br>");
		}		
	%>
	
</body>
</html>