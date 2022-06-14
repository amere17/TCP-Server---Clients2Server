import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class Util {
	public static String rootPath = "-----------------------------";
	public static String downloadDefaultPath = "------------------";
	public static Boolean isDir(String path) {
		if (path == null || !Files.exists(Paths.get(path)))
			return false;
		else
			return Files.isDirectory(Paths.get(path));
	}

	public static boolean isValidPath(String path) {
		try {
			Paths.get(path);
		} catch (InvalidPathException | NullPointerException ex) {
			return false;
		}
		return true;
	}

	public static String checkRsponseCode(int resCode) {
		switch (resCode) {
		case 200:
			return "The method done successfully";
		case 404:
			return "The file not exist";
		case 500:
			return "Error while running the method";
		}
		return "Unknown Method";
	}

	@SuppressWarnings("resource")
	public static Response uploadFile(Request req) throws IOException {

		File file = new File(req.getFilePath());
		int resCode = 0;
		FileInputStream fileInputStream = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fileInputStream);
		OutputStream out;
			if (Util.isValidPath(req.getFilePath()))
				out = new FileOutputStream(rootPath  + file.getName());
			else
				return new Response(req, Util.checkRsponseCode(404), 404);
	
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		while ((bytesRead = bis.read(buffer, 0, 4096)) != -1) {
			try {
				out.write(buffer, 0, bytesRead);
			} catch (Exception e) {
				return new Response(req, Util.checkRsponseCode(405), 405);
			}
		}
		out.close();
		resCode = 200;
		return new Response(req, Util.checkRsponseCode(resCode), resCode);
	}
	@SuppressWarnings("resource")
	public static Response DownloadFile(Request req,String filePath, String destString) throws IOException {

		File file = new File(rootPath+filePath);
		int resCode = 0;
		FileInputStream fileInputStream = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fileInputStream);
		OutputStream out = null;
		String ds = destString.toLowerCase().replaceAll("\\s", "");
		if(ds == "default" || ds.isEmpty())
			destString = downloadDefaultPath;
		if(Util.isDir(rootPath + filePath))
			return new Response(req,"The Path is not routing to a file",404);
		System.out.println(file.getAbsolutePath().toString()+" "+ destString  + file.getName());

		if (Util.isDir(destString))
			out = new FileOutputStream(destString  + file.getName());
		else
			return new Response(req, Util.checkRsponseCode(404), 404);
		
		System.out.println(file.getAbsolutePath().toString()+" "+ destString  + file.getName());
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		while ((bytesRead = bis.read(buffer, 0, 4096)) != -1) {
			try {
				out.write(buffer, 0, bytesRead);
				System.out.println("downloading " + bytesRead);
			} catch (Exception e) {
				return new Response(req, Util.checkRsponseCode(405), 405);
			}
		}
		out.close();
		resCode = 200;
		return new Response(req, Util.checkRsponseCode(resCode), resCode);
	}
	
	

}
