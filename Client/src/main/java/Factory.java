import java.util.Scanner;


/**
 * @author Mohamad Amer
 * Factory Class for client side
 */
public class Factory {
	/**
	 * 
	 * @param opt
	 * @return
	 */
	public static Request create(int opt) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String path = null;
		String act = null;
		switch (opt) {
		case 1:
			act = "download";
			System.out.println("Input file path to download it from the server");
			path = sc.next();
    		System.out.println("input destnation path to download the file");
    		System.out.println("or write default");
    		path+="-" + sc.next();
			break;
		case 2:
			act = "upload";
			System.out.println("Input file path to upload it to the server");
			path = sc.next();
			break;
		case 3:
			act = "remove";
			System.out.println("Input file path to remove it from the server");
			path = sc.next();
			break;
		case 4:
			System.out.println("Input folder path to display contnet");
			act = "display";
			path = sc.next();
			break;
		default:
			act = "null";
		}
		return new Request(path, act);
	}

}
