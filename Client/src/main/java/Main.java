
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.google.gson.Gson;

public class Main {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try (Socket socket = new Socket("localhost", 5000)) {
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			Gson gson = new Gson();
			String userInput = null;
			ClientRunnable clientRun = new ClientRunnable(socket);
			new Thread(clientRun).start();
			do {
				if (userInput != null) {
					output.println(userInput);
				}
				userInput = gson.toJson(displayMenu());

			} while (true);

		} catch (Exception e) {
			System.out.println("Exception occured in client main: " + e.getStackTrace());
		}
	}
	/**
	 * 
	 * @return Request Object
	 */
	public static Request displayMenu() {

		System.out.println("Menu");
		System.out.println("Please pick a Number");
		System.out.println("1.Download File");
		System.out.println("2.Upload File");
		System.out.println("3.Delete File");
		System.out.println("4.Display Content");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int opt = sc.nextInt();

		return Factory.create(opt);
	}
}