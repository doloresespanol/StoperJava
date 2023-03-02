package com.example.stoper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StoperSzachowyActivity extends AppCompatActivity {

    TextView textView,textView2;
    Button btn;
    boolean gracz=true;
    int sekundy=180,sekundy2=180,cos=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stoper_szachowy);
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        btn=findViewById(R.id.button);
        final Handler handler = new Handler();
        final Handler handler1 = new Handler();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cos==0){
                    cos=1;
                    btn.setText("Gracz 2");
                }else{
                    cos=0;
                    btn.setText("Gracz 1");
                }
            }
        });
                if(cos==0){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                        sekundy--;
                        textView.setText(Integer.toString(sekundy));
                        handler.postDelayed(this,1000);
                        }
                    });
                }else{
                    handler1.post(new Runnable() {
                        @Override
                        public void run() {
                            sekundy2--;
                            textView2.setText(Integer.toString(sekundy));
                            handler1.postDelayed(this, 1000);
                        }
                    });
                }
    }
}