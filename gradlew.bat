package com.example.linkonprojet;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public   class SendToMysql extends AsyncTask<String, String, String> {

    String user="cisixse";
    String passe="123";
    String url="jdbc:mysql://192.168.1.27:3308/linkonprojet";
    String msg;
    String text = Inscription.nomUser.getText().toString();

    @Override
    protected String doInBackground(String... strings) {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,user,passe);

            if ((connection == null)){

                msg = "connection goes wrong";

            }

            else {

                Statement statement = connection.createStatement();
                String query = "INSERT INTO client (username) VALUES ('"+text+"')";
                statement.executeUpdate(query);
                msg = "Inserting succeful";

            }

            connection.close();

        }
        catch (Exception e){

            msg = "connection goes wrong";
            e.printStackTrace();

        }

        return msg;
    }

    @Override
    protected void onPostExecute(String msg) {

    }

}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            