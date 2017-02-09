package com.example.carme_000.contrasenia;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EnviarMail {

    private static Session session;         // Sesion de correo
    private static Properties properties;   // Propiedades de la sesion
    private static Transport transport;     // Envio del correo
    private static MimeMessage mensaje;     // Mensaje que enviaremos

    // Credenciales de usuario
    private static String direccionCorreo = "lopcarmnen45@gmail.com";   // Dirección de correo
    private static String contrasenyaCorreo = "16101993";                 // Contraseña

    // Correo al que enviaremos el mensaje
    private static String destintatarioCorreo = "carmenk74@hotmail.com";//"leo.tomalo@gmail.com";

    public static void main(String[] args) throws MessagingException {

        // Ajustamos primero las properties
       /* properties = System.getProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");*/

        //Configuramos la sesión
       // session = Session.getDefaultInstance(properties, null);

       // enviarMensaje("Hola Dionis","Prueba cliente correo, buen fin de semana. Sergi Barola");
    }

    public static void enviarMensaje(String subject, String content) throws MessagingException {
        // Ajustamos primero las properties
        properties = System.getProperties();
        properties.setProperty("mail.transport.protocol", "smtps");
        properties.setProperty("mail.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.quitwait","false");


        //Configuramos la sesión
        session = Session.getDefaultInstance(properties, null);

        // Configuramos los valores de nuestro mensaje
        mensaje = new MimeMessage(session);
        mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destintatarioCorreo));
        mensaje.setSubject(subject);
        mensaje.setContent(content,"text/html");

        // Configuramos como sera el envio del correo
        transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", direccionCorreo, contrasenyaCorreo);
        transport.sendMessage(mensaje, mensaje.getAllRecipients());
        transport.close();

        // Mostramos que el mensaje se ha enviado correctamente
        System.out.println("--------------------------");
        System.out.println("Mensaje enviado");
        System.out.println("---------------------------");
    }


}
