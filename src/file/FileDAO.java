package file;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


// Database Access Ojbect
public class FileDAO {

	private Connection conn;
	
	public FileDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/jspTestFile?serverTimezone=UTC";
			String dbID = "root";
			String dbPassword = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 업로드 관련 데이터베이스 접근 함수
	public int upload(String fileName, String fileRealName) {
		String SQL = "INSERT INTO FILE VALUES (?, ?, 0)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, fileName);
			pstmt.setString(2, fileRealName);
			return pstmt.executeUpdate(); //성공적으로 종료된 경우 반환값 1 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류 
	}
	
	//업로드 후에 사용자가 다운로드 할때마다 카운트 증가 함수
	public int views(String fileRealName) {
		String SQL = "UPDATE FILE SET downloadCount = downloadCount + 1 "
				+ "WHERE fileRealName = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, fileRealName);
			
			return pstmt.executeUpdate();  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류 
	}
	
	
	public ArrayList<FileDTO> getFileList(){
		String SQL = "SELECT * FROM FILE";
		ArrayList<FileDTO> fileList = new ArrayList<FileDTO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			//쿼리 실행 결과를 담는다.
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 생성자에 직접 값을 넣는 경우
				FileDTO file = new FileDTO(rs.getString(1), rs.getString(2),rs.getInt(3) );
				//file.setFileName(rs.getString(1));
				//file.setFileRealName(rs.getString(2));
				//file.setDownloadCount(rs.getInt(3));
				fileList.add(file);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return fileList;
	}
	
	// 삭제
	public int deleteFile(String fileRealName) {
		String SQL = "DELETE FROM FILE WHERE fileRealName = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, fileRealName);
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류 
	}

}



