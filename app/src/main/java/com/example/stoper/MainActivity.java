package com.example.stoper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float sekundy = 0;
    boolean running = true;
    TextView textView;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textViewTimerUp);
        btn = findViewById(R.id.button);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(running) {
                    sekundy+=0.1;
                    textView.setText(Float.toString(sekundy));
                }
                handler.postDelayed(this,100);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(running){
                    running = false;
                    btn.setText("Dalej");
                }else{
                    running = true;
                    btn.setText("Pauza");
                }
            }
        });
    }
}