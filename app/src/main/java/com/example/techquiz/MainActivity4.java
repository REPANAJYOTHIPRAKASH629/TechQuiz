package com.example.techquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.app.AlertDialog;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity4 extends AppCompatActivity {


    Button ai,ds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ai = findViewById(R.id.btn1ai);
        ds = findViewById(R.id.btn2ds);

        ai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity4.this,HomePage.class);
                startActivity(intent1);
            }
        });

        ds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity4.this,HomePageDS.class);
                startActivity(intent2);
            }
        });

    }
}