package com.example.sessionmanagerdemo;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    //initialise les variables
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    //creer le constructeur
    public SessionManager(Context context){

        sharedPreferences = context.getSharedPreferences("AppKey",0);
        editor = sharedPreferences.edit();
        editor.apply();

    }

    //create set login methode
    public  void setLogin(boolean login){

        editor.putBoolean("KEY_LOGIN",login);
        editor.commit();

    }

    //create get login methode
    public  boolean getLogin(){

        return sharedPreferences.getBoolean("KEY_LOGIN",false);

    }

    //create set username methode
    public  void setUsername(String username){

        editor.putString("KEY_USERNAME",username);
        editor.commit();

    }

    //create get username methode
    public  String getUsername(){

        return sharedPreferences.getString("KEY_USERNAME","");

    }



}
