package com.examples;

import com.configuration.EmailConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.nio.file.Paths;



public class SendEmail {
    public static void main(String[] args) throws MessagingException {
//        sendSimpleMessage();

        sendFileAndHtmlMessage();
    }


    public static void sendSimpleMessage() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmailConfig.class);

        JavaMailSender sender = context.getBean(JavaMailSenderImpl.class);

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("Legionpalko@gmail.com");
        message.setSubject("Greetings");
        message.setText("Hello from hospital");



        sender.send(message);
    }

    public static void sendFileAndHtmlMessage() throws MessagingException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmailConfig.class);

        JavaMailSender sender = context.getBean(JavaMailSenderImpl.class);

        MimeMessage mimeMessage = sender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo("Legionpalko@gmail.com");
        helper.setSubject("Greetings");
        helper.setText("<html>\n" +
                "<body>\n" +
                "<h1>Try to resolve tasks</h1>\n" +
                "</body>\n" +
                "</html>", true);

        File file = Paths.get("D:\\Андрей\\Java\\Git\\Healthy\\Homeworks\\Zbіrnik_zavdan.pdf").toFile();

//        FileSystemResource fileSystemResource = new FileSystemResource(file);

        helper.addAttachment("Good book", file);
      //  PdfTest pdfTest = new PdfTest();
       // helper.addAttachment("Good Pdf", pdf());

        sender.send(mimeMessage);
    }
}
