<%@ page import="file.FileDAO" %>
<%@ page import="java.io.File" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<!-- DefaultFileRenamePolicy : 사용자가 업로드한 파일중에서 이름이 똑같은 경우, 자동으로 파일 이름들을 바꾸어 주고 오류가 발생하지 않도록 해준다  -->
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<!-- MultipartRequest클래스를 가져온다  -->

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
		/* application : 내장 객체는 전체 프로젝트에 대한 자원을 관리하는 객체, 서버의 실제 프로젝트 경로에서 자원을 찾을 때 사용 */
		int maxSize = 1024 * 1024 * 100;
		/* 파일의 최대크기 100mega */
		String encoding ="UTF-8";
		
		MultipartRequest multipartRequest
		 = new MultipartRequest(request, directory, maxSize, encoding, 
				 new DefaultFileRenamePolicy());
		
		String fileName = multipartRequest.getOriginalFileName("file");
		/* getOriginalFileName : 원본 파일 이름 */
		String fileRealName = multipartRequest.getFilesystemName("file");
		/* getFilesystemName : 실제 업로드된 파일 이름 */ 
		
		new FileDAO().upload(fileName, fileRealName);
		out.write("파일명 : "+ fileName + "<br>");
		out.write("실제 파일명 : "+ fileRealName + "<br>");
		
		
		
	 %>
</body>
</html>