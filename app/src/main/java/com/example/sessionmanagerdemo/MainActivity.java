package com.example.sessionmanagerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUser,etPassword;
    Button btLogin;
    SessionManager sessionmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = findViewById(R.id.et_user);
        etPassword = findViewById(R.id.et_password);
        btLogin = findViewById(R.id.bt_login);

        //initialiser sessionManager
        sessionmanager = new SessionManager(getApplicationContext());

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sUsername= etUser.getText().toString().trim();
                String sPassword= etPassword.getText().toString().trim();

                //when password is empty
                if (sPassword.equals("")){

                    etPassword.setError("please enter password");

                }

                //when password is root
                if (sPassword.equals("root")){

                    //store login in session manager
                    sessionmanager.setLogin(true);
                    sessionmanager.setUsername(sUsername);
                    Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                    startActivity(intent);
                    finish();



                }

                else Toast.makeText(getApplicationContext(),"wrong",Toast.LENGTH_SHORT).show();


            }
        });

        //if user already logged in
        if (sessionmanager.getLogin()){

            Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(intent);
            finish();

        }

    }
}
