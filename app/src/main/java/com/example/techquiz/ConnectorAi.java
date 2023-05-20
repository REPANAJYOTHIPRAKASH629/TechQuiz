package com.example.techquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.techquiz.R;


public class ConnectorAi extends AppCompatActivity implements View.OnClickListener{
    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC, ansD;
    Button submitBtn;


    int score=0;
    int totalQuestion = ai.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";
    private CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView timerTextView=findViewById(R.id.tv1);
        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions : "+totalQuestion);
        timer = new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                // Update the UI with the remaining time
                // For example:
               timerTextView.setText( "00:"+millisUntilFinished / 1000 );
            }
            public void onFinish() {
                // When the time runs out, load the next question
                selectedAnswer="";
                currentQuestionIndex++;
                loadNewQuestion();
            }
        };

        loadNewQuestion();
    }



    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;

        if(clickedButton.getId()== R.id.submit_btn){
            if (selectedAnswer==""){
                Toast.makeText(this, "Select one option", Toast.LENGTH_SHORT).show();
            }
            else if(selectedAnswer.equals(ai.correctAnswers[currentQuestionIndex])){
                score++;
                selectedAnswer="";
                currentQuestionIndex++;
                loadNewQuestion();
            }
            else{
                selectedAnswer="";
                currentQuestionIndex++;
                loadNewQuestion();
            }
            timer.start();

        }else{
            //choices button clicked
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.CYAN);

        }

    }
    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }
        timer.start();
        questionTextView.setText(ai.question[currentQuestionIndex]);
        ansA.setText(ai.choices[currentQuestionIndex][0]);
        ansB.setText(ai.choices[currentQuestionIndex][1]);
        ansC.setText(ai.choices[currentQuestionIndex][2]);
        ansD.setText(ai.choices[currentQuestionIndex][3]);

    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+ score+" out of "+ totalQuestion)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();

    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }

}

