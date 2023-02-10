package com.example.sharedpreferencestwo;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.Preference;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

     EditText textview;
     Button btnlogin,btnclear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);
        String str3 = preferences.getString("kyeNumber","");
        String str1 = "";
        if(!str3.equals(str1))
        {
            Intent intent = new Intent(Login.this,Disply.class);
            startActivity(intent);
        }

        textview = findViewById(R.id.idNumber1);
        btnlogin = findViewById(R.id.idLogin);
        btnclear = findViewById(R.id.idclear);

        String str = preferences.getString("keyNumber","");

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str1 = textview.getText().toString();
                Log.e(TAG,"this is the value of str"+str);
                Log.e(TAG,"this is the value of str1"+str1);

                if(str1.equals(str))
                {
                    Intent intent = new Intent(Login.this,Disply.class);
                    startActivity(intent);
                }

                else
                {
                    Toast.makeText(getApplicationContext(),"Please Enter your 10 digit Mobile Number!",Toast.LENGTH_SHORT).show();

                }
            }
        });

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences1 = getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor myedit = preferences1.edit();
                myedit.putString("keyName","");
                myedit.putString("keyNumber","");
                myedit.putString("keyAge","");
                myedit.commit();

                Intent intent = new Intent(Login.this,Registration.class);
                startActivity(intent);
            }
        });
    }
}
