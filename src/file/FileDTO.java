package file;

// Database Transfer Object
public class FileDTO {

	String FileName;
	String FileRealName;
	int downloadCount;
	
	// 생성자 : 해당 변수 초기화 목적
	public FileDTO(String fileName, String fileRealName, int downloadCount ) {
		super();
		this.FileName = fileName;
		this.FileRealName = fileRealName;
		this.downloadCount = downloadCount;
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

	public int getDownloadCount() {
		return downloadCount;
	}

	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}
	
	
	
}