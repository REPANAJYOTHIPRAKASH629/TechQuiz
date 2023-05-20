package com.example.techquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HRactivity extends AppCompatActivity implements View.OnClickListener {
    TextView text1;
    EditText edit1;
    Button submit_btn,answer_btn;
    int currentQuestionIndex=0;
    Intent intent;
    int totalQuestion = hr1stq.question.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hractivity);
        text1=findViewById(R.id.textView);
        edit1=findViewById(R.id.edit1);
        submit_btn=findViewById(R.id.button1);
        answer_btn=findViewById(R.id.button4);
        submit_btn.setOnClickListener((View.OnClickListener) this);
        answer_btn.setOnClickListener((View.OnClickListener) this);

        loadNewQuestion();

    }
    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.button1){
            currentQuestionIndex++;
            edit1.setText("");
            loadNewQuestion();
        }
        else if (clickedButton.getId()==R.id.button4){
            Intent intent=new Intent(HRactivity.this,HRanswers.class);
        intent.putExtra("ss",currentQuestionIndex);
        startActivity(intent);
        }


    }
    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ) {
            finishQuiz();
            return;
        }
        text1.setText(hr1stq.question[currentQuestionIndex]);
    }
    void finishQuiz(){
        new AlertDialog.Builder(this)
                .setMessage("Finished !!")
                .show();
    }
}