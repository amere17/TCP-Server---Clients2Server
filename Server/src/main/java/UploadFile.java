import java.io.IOException;

public class UploadFile extends ServerAction {

	@Override
	public Response Excute(Request req) {
		// TODO Auto-generated method stub
		try {
			return Util.uploadFile(req);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
