import java.io.File;


/**
 * @author moham
 * Request class to build the request object from the user input
 */
public class Request {
	private String filePath;
	private String contentType;
	private String action;
	private int requestId;

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	/**
	 * Constructor 
	 * @param filePath
	 * @param action
	 */
	public Request(String filePath, String action) {
		super();
		this.filePath = filePath;
		this.contentType = getContentType(filePath);
		this.action = action;
		this.requestId = hashCode();
	}
	/**
	 * 
	 * @return file path
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * 
	 * @param filePath
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * 
	 * @return
	 */
	public String getContentType() {
		return contentType;
	}
	/**
	 * 
	 * @param contentType
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	/**
	 * 
	 * @return
	 */
	public String getAction() {
		return action;
	}
	/**
	 * 
	 * @param action
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * 
	 * @return
	 */
	public int getRequestId() {
		return requestId;
	}
	/**
	 * 
	 * @param requestId
	 */
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getContentType(final String fileName) {
		String extension = "folder";
		int i = fileName.lastIndexOf('.');
		int p = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));

		if(i > p) 
		    extension = fileName.substring(i+1);
		return extension;
		
	}
	/**
	 * 
	 * @param f
	 * @return
	 */
	public static String getExtension(final File f) {

		return getExtension(f.getName());
	}
	/**
	 * 
	 * @param f
	 * @return
	 */
	public static String getExtension(final String f) {

		return f.substring(f.lastIndexOf('.') + 1);
	}

}
