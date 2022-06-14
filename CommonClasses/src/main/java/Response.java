import java.util.Objects;


public class Response {
	private int reqId;
	private int resId;
	private int responseCode;
	private String contentType;
	private String body;
	
	public Response(Request req,String body,int resCode) {
		super();
		this.reqId = req.getRequestId();
		this.resId = hashCode();
		this.contentType = req.getContentType();
		this.body = body;
		this.responseCode = resCode;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public int getReq() {
		return reqId;
	}

	public void setReq(int reqId) {
		this.reqId = reqId;
	}

	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public int hashCode() {
		return Objects.hash(body, contentType, reqId, resId);
	}
	
}
