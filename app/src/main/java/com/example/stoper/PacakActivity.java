package com.example.stoper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PacakActivity extends AppCompatActivity {

    private ArrayList<ImageView> obrazki = new ArrayList<>();
    private int sekundy=10;
    private int punkty=0;
    boolean running = true;
    private TextView czasTextView;
    private TextView punktyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacak);
        czasTextView=findViewById(R.id.czasTextView);
        punktyTextView=findViewById(R.id.punktyTextView);
        obrazki.add(findViewById(R.id.imageView));
        obrazki.add(findViewById(R.id.imageView2));
        obrazki.add(findViewById(R.id.imageView3));
        obrazki.add(findViewById(R.id.imageView4));
        pokazWybranyObraz();
        zlicz();
    }
    private void zlicz(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(sekundy==0){
                    running=false;
                }else{
                    sekundy--;
                    pokazWybranyObraz();
                    czasTextView.setText("Czas: "+String.valueOf(sekundy));
                    handler.postDelayed(this,1000);
                }
            }

        });
    }
    private void pokazWybranyObraz() {
        for (ImageView obrazek : obrazki) {
            obrazek.setVisibility(View.INVISIBLE);
        }
        int index = (int) (Math.random() * obrazki.size());
        obrazki.get(index).setVisibility(View.VISIBLE);
        obrazki.get(index).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                punkty++;
                punktyTextView.setText("Punkty: "+Integer.valueOf(punkty));
                pokazWybranyObraz();
            }
        });
    }

}