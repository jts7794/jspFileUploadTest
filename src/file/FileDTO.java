package file;

// Database Transfer Object
public class FileDTO {

	String FileName;
	String FileRealName;
	
	// 생성자 : 해당 변수 초기화 목적
	public FileDTO(String fileName, String fileRealName) {
		super();
		FileName = fileName;
		FileRealName = fileRealName;
	}
	
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getFileRealName() {
		return FileRealName;
	}
	public void setFileRealName(String fileRealName) {
		FileRealName = fileRealName;
	}
	
	
}