package pzprojekt;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.SwingWorker;


public class Mail {

    public static void sendRegister(String mail, String username, String name, String surname, String password) {
    	final String login=username;
		final String imie=name;
		final String nazwisko=surname;
		final String haslo=password;
		final String email=mail;
		
    	SwingWorker<Void, Void> worker=new SwingWorker<Void, Void>() {

			@Override
			protected Void doInBackground() throws Exception {
				final String username = "mail@sysinf2011.vipserv.org";
                final String password = "pzlab";

                Properties props = new Properties();
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.host", "sysinf2011.vipserv.org");
                props.put("mail.smtp.port", "587");

                Session session = Session.getInstance(props,
                  new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                  });

                try {

                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("mail@sysinf2011.vipserv.org"));
                    message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(email));
                    message.setSubject("Rejestracja w EPER");
                    message.setText("Witaj "+imie+" "+nazwisko+"! \n\n Dziękujemy za rejestrację w programie EPER"
                        + "\n\n Twój login to: "+login+"\n" 
                    	+ "Hasło: "+haslo+"\n");

                    Transport.send(message);

                    System.out.println("Done");

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
				return null;
			}
		};   
		worker.execute();
    }
}