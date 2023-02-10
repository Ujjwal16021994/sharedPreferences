package com.example.sharedpreferencestwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

        EditText edittextname,edittextnumber,edittextage;
        Button Submit;
        String strname,strnumber,strage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);
        String string1 = preferences.getString("keyNumber","");

        if(string1 != "")
        {
            Intent intent1 = new Intent(Registration.this,Login.class);
            startActivity(intent1);
        }

        edittextname = findViewById(R.id.idname);
        edittextnumber = findViewById(R.id.idnumber);
        edittextage = findViewById(R.id.idage);

        Submit = findViewById(R.id.idSubmit);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                strname = edittextname.getText().toString();
                strnumber = edittextnumber.getText().toString();
                strage = edittextage.getText().toString();


                Long number = Long.valueOf(strnumber);
                Long age = Long.valueOf(strage);

                boolean check1 = false,check2 = false,check3 = false;

                while (check1!=true && check2!=true && check3!=true)
                {
                    if(number<999999999)
                    {
                        Toast.makeText(getApplicationContext(),"Mobile Number Not Correct",Toast.LENGTH_SHORT).show();
                        check1=false;
                    }
                    else {check1 = true;}
                    if(strname == "")
                    {
                        Toast.makeText(getApplicationContext(),"Please enter name",Toast.LENGTH_SHORT).show();
                        check2=false;
                    }
                    else {check2 = true;}
                    if(age<=0)
                    {
                        Toast.makeText(getApplicationContext(),"Please enter correct age",Toast.LENGTH_SHORT).show();
                        check3=false;
                    }
                   else{check3= true;}
                }

                SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor myedit = preferences.edit();

                myedit.putString("keyName",strname);
                myedit.putString("keyNumber",strnumber);
                myedit.putString("keyAge",strage);
                myedit.commit();

                if(number>999999999)
                {
                    Intent intent = new Intent(Registration.this,Disply.class);
                    startActivity(intent);
                }
            }
        });
    }
}