package com.ford.bguneser.lastexam.activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ford.bguneser.lastexam.R;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateUserActivity extends Activity {


    TextView textView;
    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    private static final String  DB_URL = "jdbc:mysql://192.168.2.7/lastexam?useSSL=false";
    private static final String USER="bguneser";
    private static final String PASS="Gs19881905";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_createuser );

        textView=(TextView) findViewById( R.id.tw_create_new_account);
        editText=(EditText) findViewById( R.id.txt_name );
        editText2=(EditText) findViewById( R.id.txt_password );
        editText3=(EditText) findViewById( R.id.txt_surname );
        editText4=(EditText) findViewById( R.id.txt_e_mail );

    }

    public void btnConn(View view)
    {
        CreateUserActivity.Send objSend= new Send();
        objSend.execute("");


    }

    private class Send extends AsyncTask<String,String,String>
    {
        String msg="";
        String text = editText.getText().toString();
        String text_password=editText2.getText().toString();
        String text_surname=editText3.getText().toString();
        String text_email = editText4.getText().toString();

        @Override
        protected void onPreExecute() {
//            textView.setText( "Please Wait Inserting Data" );
        }

        @Override
        protected String doInBackground(String... strings) {

            try {
                Class.forName( "com.mysql.jdbc.Driver" );
                Connection conn = DriverManager.getConnection( DB_URL,USER,PASS );

//                URL url = new URL( DB_URL );
//                HttpURLConnection httpConn = null;
//                httpConn=(HttpURLConnection) url.openConnection();
//                httpConn.setAllowUserInteraction( false );
//                httpConn.setInstanceFollowRedirects( false );
//                httpConn.setConnectTimeout( 6000000 );
//                httpConn.connect();



                if(conn == null)
                {
                    msg="Connection goes wrong";
                }

                else
                {
                    String query = "INSERT INTO user (username,password,surname,email) VALUES ('"+text+"','"+text_password+"','"+text_surname+"','"+text_email+"')";

                    Statement stmt1 = conn.createStatement();

                    stmt1.executeUpdate( query );

                    msg="Inserting successsfully";
                }

                conn.close();
            }

            catch (Exception e) {
                msg="Connection goes wrong" ;
                e.printStackTrace();

            }

            return msg;
        }

        @Override
        protected void onPostExecute(String s) {
            // textView.setText( msg );
        }
    }


}
