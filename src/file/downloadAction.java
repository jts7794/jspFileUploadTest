package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/downloadAction")
public class downloadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileName = request.getParameter("file");
		
		// 시큐어 코딩
		//String directory = this.getServletContext().getRealPath("/upload/");
		String directory = "C:/JSP/upload";
		// 시큐어 코딩 끝
		
		File file = new File(directory + "/" + fileName);
		
		// mimeType : 어떤 데이터를 주고 받을지에 대한 정보를 담는다.
		String mimeType = getServletContext().getMimeType(file.toString());
		if (mimeType == null) {
			response.setContentType("application/octet-stream");
			//octet-stream : 2진 데이터의 파일  데이터를 주고 받을 때 사용, 서버의 응답 (response)을 통해 파일 데이터를 받는다는 것을 알게 된다.
		}
		
		String downloadName = null;
		// 사용자의 MSIE : 인터넷 익스플로어 
		if (request.getHeader("user-agent").indexOf("MSIE") == -1) {
			// 인터넷 익스플로어가 아닌 다른 브라우져인 경우 
			downloadName = new String(fileName.getBytes("UTF-8"), "8859_1");
		} else {
			//
			downloadName = new String(fileName.getBytes("EUC-KR"), "8859_1");
		}
		
		// 사용자에게 전달할 응답; 헤더 처리 
		response.setHeader("Content-Disposition", "attachment;filename=\""
				+ downloadName + "\";");
		
		// responce에 실제 전달할 파일을 전달
		FileInputStream fileInputStream = new FileInputStream(file);
		ServletOutputStream servletOutputStream = response.getOutputStream();
		
		byte b[] = new byte[1024];
		int data = 0;
		
		while((data = (fileInputStream.read(b, 0, b.length))) != -1) {
			
			servletOutputStream.write(b, 0, data);
		}
		
		servletOutputStream.flush();
		servletOutputStream.close();
		fileInputStream.close();
		
	}



}
