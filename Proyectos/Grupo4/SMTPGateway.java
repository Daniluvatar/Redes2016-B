package ec.edu.epn.redes.pmf;

import org.subethamail.smtp.server.SMTPServer;

public class SMTPGateway {

	private static int PORT = 2525;
	
	public static void main(String[] args) {
        MyMessageHandlerFactory myFactory = new MyMessageHandlerFactory() ;
        SMTPServer smtpServer = new SMTPServer(myFactory);
        System.out.println("SMTP server listening on port: " + PORT);
        smtpServer.setPort(PORT);
        smtpServer.start();
	}
}
