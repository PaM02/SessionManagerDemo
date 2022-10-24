package com.example.sessionmanagerdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tvUsername;
    Button btLogout;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvUsername = findViewById(R.id.tv_username);
        btLogout = findViewById(R.id.bt_logout);

        sessionManager = new SessionManager(getApplicationContext());

        //getusername from session manager
        String sUsername = sessionManager.getUsername();

        //set username from tvUsername
        tvUsername.setText(sUsername);
        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //initialise alertdialog builder
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("LOgout");
                builder.setMessage("are you sure to log out?");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //set login false
                        sessionManager.setLogin(false);
                        sessionManager.setUsername("");

                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });

                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();

                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

    }
}
