package com.example.sharedpreferencestwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Disply extends AppCompatActivity {

    TextView name, number, age;
    Button button, buttonlogout;

   public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disply);

        drawerLayout = findViewById(R.id.its_my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        name = findViewById(R.id.idname);
        number = findViewById(R.id.idnumber);
        age = findViewById(R.id.idage);

        buttonlogout = findViewById(R.id.idbtnlogout);
        button = findViewById(R.id.idbtnclear);

        SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);

        String strName = preferences.getString("keyName", "qqq");

        name.setText(strName);
        number.setText(preferences.getString("keyNumber", "0"));
        age.setText(preferences.getString("keyAge", "qqq"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
                SharedPreferences.Editor myedit = preferences.edit();
                myedit.clear();
                myedit.commit();
            }
        });

        buttonlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Disply.this, Login.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    }
