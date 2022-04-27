package by.bntu.fitr.model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MailSender {
    private Properties properties = new Properties();
    private String username = "artemkulakovich237";
    private String password = "artem201320133";
    private String uniqueCode;


    public void MailSender() {
    }

    public void sendMail(String sendTo, String subject, String messageBody, boolean flag) throws MessagingException {
        loadProperties();
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = getMessage(session, sendTo, subject, messageBody, flag);
        Transport.send(message);
    }

    private Message getMessage(Session session, String sendTo, String subject, String messageBody, boolean flag) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setSubject(subject);
        message.setText(messageBody + (flag == true ? generateUniqueCode() : ""));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));
        return message;
    }

    private String generateUniqueCode() {
        String code = "test";
        /*
        int size = 5 + (int) Math.random() * 5;
        for (int i = 0; i < size; i++) {
            code += (char) (65 + (int) Math.random() * 92);
        }
         */
        uniqueCode = code;
        return code;
    }


    private void loadProperties() {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Artyom\\IdeaProjects\\Ishop\\src\\main\\resources\\mail.properties");
            properties.load(fileInputStream);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public String getUniqueCode() {
        return uniqueCode;
    }
}
