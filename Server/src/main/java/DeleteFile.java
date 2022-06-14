import java.io.File;

public class DeleteFile extends ServerAction {
	private Request req;

	
	@Override
	public String toString() {
		return "DeleteFile [req=" + req + ", getReq()=" + getReq() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public Response Excute(Request req) {
		int resCode = 0;
		try {
            File file = new File(Util.rootPath+req.getFilePath());
            if (file.delete()) {
                resCode = 200;
            } else {
                resCode = 404;
            }
        } catch (Exception e) {
        	
        }
		return new Response(req,Util.checkRsponseCode(resCode),resCode);
	}
	public Request getReq() {
		return req;
	}
	public void setReq(Request req) {
		this.req = req;
	}

}
