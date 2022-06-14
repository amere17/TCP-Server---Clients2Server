import java.io.IOException;

public class Factory {
	public static Response createResponse(Request req) throws IOException {
		int resCode = 501;
		switch(req.getAction()) {
    	case "display":
    		DisplayFolder dispFolder = new DisplayFolder();
    		return dispFolder.Excute(req);
    	case "upload":
    		UploadFile uf = new UploadFile();
    		return uf.Excute(req);
    	case "download":
    		DownloadFile downFile = new DownloadFile();
    		return downFile.Excute(req);
    	case "remove":
    		DeleteFile df = new DeleteFile();
    		return df.Excute(req);
    	default:
    		resCode = 405;
    		break;
    	}
		return new Response(req, "Method not Exist", resCode);
	}
	
	
}
