package ec.edu.epn.redes.date.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * Trivial client for the date server.
 */
public class DateClient {

	private static int SERVER_PORT = 9090;
	
	/**
     * Runs the client as an application.  First it displays a dialog
     * box asking for the IP address or hostname of a host running
     * the date server, then connects to it and displays the date that
     * it serves.
     */
	
	public static void main(String[] args) throws IOException {
        
		String serverAddress = JOptionPane.showInputDialog(
            "Enter IP Address of a machine that is\n" +
            "running the date service on port "+SERVER_PORT+":");
        
        Socket clientSocket = new Socket(serverAddress, SERVER_PORT);
        
        //Obtiene el paquete enviado por el servidor
        InputStreamReader inputSrem = new InputStreamReader(clientSocket.getInputStream());
        
        //Lee los datos enviados a travez del socket
        BufferedReader input = new BufferedReader(inputSrem);
        String answer = input.readLine();
        
        //String answer2 = input.readLine();
        //System.out.println("answer2: "+answer2);
        //Imprime el mensaje
        JOptionPane.showMessageDialog(null, answer);
        System.exit(0);
    }
	
}
