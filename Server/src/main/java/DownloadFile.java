import java.io.FileNotFoundException;
import java.io.IOException;

public class DownloadFile extends ServerAction {

	@Override
	public Response Excute(Request req) {
		// TODO Auto-generated method stub
		try {
    		String[] arr = req.getFilePath().split("-");
			return Util.DownloadFile(req,arr[0], arr[1]);
		} catch (FileNotFoundException e) {
			return new Response(req, "File Not Found", 404);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
