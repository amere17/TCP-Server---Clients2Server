import java.io.File;

public class DisplayFolder extends ServerAction {

	@Override
	public Response Excute(Request req) {
		File folder = new File(Util.rootPath + req.getFilePath());
		if(!folder.isDirectory())
			return new Response(req,"path not routing to a correct folder",405);
		if(!Util.isValidPath(req.getFilePath()))
		    return new Response(req,"Is Not valid Path",404);

		File[] listOfFiles = folder.listFiles();
		String filesName = "\n";
		for (int i = 0; i < listOfFiles.length; i++) {
			filesName += listOfFiles[i].getName() + '\n';
		}
		return new Response(req,filesName,200);
	}

}
