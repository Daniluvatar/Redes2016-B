package ec.edu.epn.redes.pmf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.subethamail.smtp.*;

public class MyMessageHandlerFactory implements MessageHandlerFactory {

	public MessageHandler create(MessageContext ctx) {
		System.out.println("En MessageHandler");
		return new Handler(ctx);
    }

    class Handler implements MessageHandler {
        MessageContext ctx;
        String from,subject,content,name,emailTo; 
    	
        
        public Handler(MessageContext ctx) {
                this.ctx = ctx;
        }
        
        public void from(String from) throws RejectException {
                this.from=from;
        		System.out.println("FROM:"+from);
        }

        public void recipient(String recipient) throws RejectException {
                System.out.println("RECIPIENT:"+recipient);
        }

        public void data(InputStream data) throws IOException {
        	System.out.println("En InputStream");	
        	mimeMessage(data);
            
        	System.out.println("Sending email to the SMTP server...");
            sendEmail();
            	
        }

        public void done() {
                System.out.println("Finished");
        }

        
        public void mimeMessage(InputStream is){ //reads and interprets mime message
        	System.out.println("**************************** Interpreting Mime Message *****************************");
        	Session s = Session.getDefaultInstance(new Properties());
        	try {
				MimeMessage message = new MimeMessage(s, is);
				Address [] in = message.getFrom();
				for (Address address : in){
					System.out.println("From: " + address.toString());
					this.name = address.toString();
				}
				
				Address [] to = message.getRecipients(Message.RecipientType.TO);
				for (Address address : to){
					System.out.println("To: " + address.toString());
					this.emailTo = address.toString();
				}
				System.out.println("Subject: " + message.getSubject());
				this.subject = message.getSubject();
				MimeMultipart content = (MimeMultipart) message.getContent();
				System.out.println("Content 0: "+ content.getBodyPart(0).getContent());
				this.content = (String) content.getBodyPart(0).getContent();
				//System.out.println("Content 1: "+ content.getBodyPart(0).getContent());
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				System.out.println("Error in mimeMessage: " + e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error in mimeMessage: " + e.getMessage());
				e.printStackTrace();
			}
        }
        
        
        public void sendEmail(){
        	System.out.println("SimpleEmail Start");
        	
        	Properties props = System.getProperties();
        	Session session = Session.getInstance(props,null);
        	
        	System.out.println("Subject: "+ this.subject);
            System.out.println("Content: " + this.content);
            EmailUtil.sendEmail(session, this.emailTo,this.subject, this.content,this.from,this.name);
        }
        
    }
	
}
