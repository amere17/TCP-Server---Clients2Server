import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.google.gson.Gson;
/**
 * 
 * @author Mohamad amer
 *
 */
public class ClientThread extends Thread {

	private Socket socket;
	private BufferedReader input;

	public ClientThread(Socket s) throws IOException {

		this.socket = s;
		this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

	}

	public void run() {
		try {
			while (true) {
				Gson gson = new Gson();
				Response res = gson.fromJson(input.readLine(),Response.class);
				System.out.println(res.getBody());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (Exception e) {

			}

		}
	}
}
