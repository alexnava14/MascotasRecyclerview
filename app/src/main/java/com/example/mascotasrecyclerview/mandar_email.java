package com.example.mascotasrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
//import android.se.omapi.Session;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Properties;

public class mandar_email extends AppCompatActivity implements View.OnClickListener {

    String myemail,mypass;
    TextInputEditText Nombre,Correo,Mensaje;
    Button Enviarcoments;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandar_email);

        Nombre=(TextInputEditText) findViewById(R.id.tietNombre);
        Correo=(TextInputEditText) findViewById(R.id.tietCorreo);
        Mensaje=(TextInputEditText) findViewById(R.id.tietMensaje);
        Enviarcoments=(Button) findViewById(R.id.bEnviarcoments);

        Enviarcoments.setOnClickListener(this);

        myemail="alexnava1409@gmail.com";
        mypass="alejandro140996upiita";
    }

    @Override
    public void onClick(View view) {
        Properties properties= new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.googlemail.com");
        properties.put("mail.smtp.port","587");

        //properties.put("mail.smtp.socketFactory.port","465");
        //properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

        //inicializar session
        try {
            session=Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                @Override
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myemail,mypass);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        //inicializar Mensaje


        try {
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(myemail));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(Correo.getText().toString().trim()));
            message.setSubject(Nombre.getText().toString().trim());
            message.setText(Mensaje.getText().toString().trim());

            new SendMail().execute(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }

    private class SendMail extends AsyncTask<Message,String,String> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog=ProgressDialog.show(mandar_email.this,"Por Favor Espere", "Enviando Mensaje",true,false);
        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                Transport.send(messages[0]);
                return "Success";
            } catch (MessagingException e) {
                e.printStackTrace();
                return "Error";
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();

            if(s.equals("Success")){

                AlertDialog.Builder builder= new AlertDialog.Builder(mandar_email.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color='#509324'>Success</font>"));
                builder.setMessage("Mensaje enviado exitosamente");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
            else{
                Toast.makeText(getApplicationContext(),"Algo salio mal",Toast.LENGTH_SHORT);
            }
        }
    }
}


        /*    new Authenticator(){
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(myemail,mypass);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

*/