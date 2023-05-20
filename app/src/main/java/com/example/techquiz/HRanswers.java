package com.example.techquiz;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HRanswers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hranswers);
        TextView text2=findViewById(R.id.tv2);
        Bundle bundle=getIntent().getExtras();
        int i=bundle.getInt("ss");
        text2.setText(hr1stq.correctAnswers[i]);
    }
}