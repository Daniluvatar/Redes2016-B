package ec.edu.epn.redes.cs.tcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * A TCP server that runs on port 9090.  When a client connects, it
 * sends the client a message, then closes the
 * connection with that client.  Arguably just about the simplest
 * server you can write.
 */
public class ServerTCP {

	private static int PORT = 9090;
	
     /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        
    	ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server listening on port "+PORT);
        
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Message from Server");
                } finally {
                    socket.close();
                }
            }
        }
        finally {
        	serverSocket.close();
        }
    }
	
}
