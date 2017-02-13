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


import java.util.concurrent.ExecutionException;

import javax.mail.MessagingException;

import static android.R.id.edit;

public class recupera_pwd extends AppCompatActivity {
    private EditText et1;
    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recupera_pwd);
        et1 = (EditText) findViewById(R.id.et1);
        tv1 = (TextView) findViewById(R.id.tv1);
    }

    public void  mostrar(View v) throws MessagingException {
        try {
            AsyncEmail tareaEmail = new AsyncEmail();
            Boolean res= tareaEmail.execute().get();
            if (res)
                Toast.makeText(this,"Mensaje enviado con éxito.",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this,"Error al enviar el mensaje.",Toast.LENGTH_LONG).show();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
