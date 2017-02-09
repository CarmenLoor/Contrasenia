package com.example.carme_000.contrasenia;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import static android.R.id.edit;

public class recupera_pwd extends AppCompatActivity {
    private EditText et1;
    private TextView tv1;
    private static Session session;         // Sesion de correo
    private static Properties properties;   // Propiedades de la sesion
    private static Transport transport;     // Envio del correo
    private static MimeMessage mensaje;     // Mensaje que enviaremos

    // Credenciales de usuario
    private static String direccionCorreo = "lopcarmnen45@gmail.com";   // Dirección de correo
    private static String contrasenyaCorreo = "16101993";                 // Contraseña

    // Correo al que enviaremos el mensaje
    private static String destintatarioCorreo = "carmenk74@hotmail.com";//"leo.tomalo@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recupera_pwd);
        et1 = (EditText) findViewById(R.id.et1);
        tv1 = (TextView) findViewById(R.id.tv1);
    }

    public void  mostrar(View v) throws MessagingException {

        final String con = (String)PasswordGenerator.getPassword( PasswordGenerator.MINUSCULAS+ PasswordGenerator.MAYUSCULAS+ PasswordGenerator.ESPECIALES,10);
        Toast noti;
        noti = Toast.makeText(this,con,Toast.LENGTH_LONG);
        noti.show();

        //enviarMensaje("Contraseña de aplicacion","Clave: "+con);

        EnviarMail en = new EnviarMail();

       en.enviarMensaje("Contraseña de aplicacion","Clave: "+con);



/* enviar correo desde el mismo...
        String[] to = {"carmenk74@hotmail.com"};
        String[] cc = {"carmenk74@hotmail.com","carmenk74@hotmail.com"};
        Intent inten_enviar = new Intent(Intent.ACTION_SEND);
        inten_enviar.setData(Uri.parse("mailto"));
        inten_enviar.putExtra(Intent.EXTRA_CC,cc);
        inten_enviar.putExtra(Intent.EXTRA_EMAIL,to);
        inten_enviar.putExtra(Intent.EXTRA_SUBJECT,"Mi primer correo...");
        inten_enviar.putExtra(Intent.EXTRA_TEXT,"Clave: "+con);

        inten_enviar.setType("message/rfc822");
        //elegir de las aplicaciones q tiene
        startActivity(Intent.createChooser(inten_enviar,"Email"));
*/



     /*   Button btnSend = (Button) findViewById(R.id.button);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                Intent inten_enviar = new Intent(Intent.ACTION_SEND);
                inten_enviar.putExtra(Intent.EXTRA_EMAIL,"lopcarmen45@gmail.com");
                Intent intent = inten_enviar.putExtra(Intent.EXTRA_TEXT, con);
                startActivity(inten_enviar);
            }
        });*/


    }





}
