
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import com.google.gson.Gson;


public class ServerThread extends Thread {
    private Socket socket;
    private ArrayList<ServerThread> threadList;
    private PrintWriter output;

    public ServerThread(Socket socket, ArrayList<ServerThread> threads) {
        this.socket = socket;
        this.threadList = threads;
    }

    @Override
    public void run() {
        try {
            //Reading the input from Client
            BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
            
            //returning the output to the client : true statement is to flush the buffer otherwise
            //we have to do it manuallyy
             output = new PrintWriter(socket.getOutputStream(),true);


            //inifite loop for server
            while(true) {
    			Gson gson = new Gson();
            	Request req = gson.fromJson(input.readLine(),Request.class);
                String outputString = req.getAction();
                //if user types exit command
                if(outputString.equals("exit")) {
                    break;
                }
                Response res = Factory.createResponse(req);
                String response = gson.toJson(res);
                printToALlClients(response);
            }


        } catch (Exception e) {
            System.out.println("Error occured " +e.getStackTrace());
        }
    }

    private void printToALlClients(String outputString) {
        for( ServerThread sT: threadList) {
        	if(sT == this)
        		sT.output.println(outputString);
        }

    }
}
