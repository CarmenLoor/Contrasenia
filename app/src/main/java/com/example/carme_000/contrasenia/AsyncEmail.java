package com.example.carme_000.contrasenia;
import android.os.AsyncTask;
import android.util.Log;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by carme_000 on 13/02/2017.
 */

public class AsyncEmail extends AsyncTask <Void, Void, Boolean> {
    private static Session session;         // Sesion de correo
    private static Properties properties;   // Propiedades de la sesion
    private static Transport transport;     // Envio del correo
    private static MimeMessage mensaje;     // Mensaje que enviaremos

    private static String direccionCorreo = "";   // Dirección de correo
    private static String contrasenyaCorreo = ""; // Contraseña

    // Correo al que enviaremos el mensaje
    private static String destintatarioCorreo = ""; // Dirección de correo destino

    @Override
    protected Boolean doInBackground(Void...params ) {
        try
        {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", direccionCorreo);
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);
            session.setDebug(true);
            //creacion de la contraseña aleatoria
            final String con;
            con = "Su nueva contraseña de la aplicacion GeoTurSE es: " + (String)PasswordGenerator.getPassword( PasswordGenerator.MINUSCULAS+ PasswordGenerator.MAYUSCULAS+ PasswordGenerator.ESPECIALES,10);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(direccionCorreo));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destintatarioCorreo));
            message.setSubject("Clave.");
            message.setText(con);
            //message.setText("Problema de Carmen" + " " + "Se le perdio la cadenita!");

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect(direccionCorreo, contrasenyaCorreo);
            t.sendMessage(message, message.getAllRecipients());
            // Cierre.
            t.close();
            return true;
        }
        catch (Exception e)
        {
            Log.e("Error De SMPT", "enviarMensaje: " + e.getMessage());
            e.printStackTrace();
            return  false;
        }
    }


}
