import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.google.gson.Gson;
/**
 * 
 * @author Mohamad Amer
 *
 */
public class ClientRunnable implements Runnable {
	
    private Socket socket;
    private BufferedReader input;

    public ClientRunnable(Socket s) throws IOException {
        this.socket = s;
        this.input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
    }
    
    public void run() {
        
            try {
            	Gson gson = new Gson();
                while(true) {
    				Response res = gson.fromJson(input.readLine(),Response.class);
                    System.out.println(res.getBody());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    input.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }
    
}
