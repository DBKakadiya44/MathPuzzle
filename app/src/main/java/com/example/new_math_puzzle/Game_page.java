package com.example.new_math_puzzle;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Game_page extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView,skip,delet;
    TextView ans,submit;
    TextView[] b=new TextView[10];
    String s="";
    int a=0,cnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);
        imageView = findViewById(R.id.main_image);
        imageView.setImageResource(config.img[cnt]);
        ans=findViewById(R.id.ansfield);
        delet = findViewById(R.id.delet);
        submit = findViewById(R.id.submit);

        skip = findViewById(R.id.skipbutton);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cnt<19) {
                    cnt++;
                    imageView.setImageResource(config.img[cnt]);
                }
            }
        });

        for(int i=0;i<b.length;i++){
            int id = getResources().getIdentifier("b"+i,"id",getPackageName());
            b[i] = findViewById(id);
            b[i].setOnClickListener(this);
        }

        delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s="";
                ans.setText(""+s);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<20;i++){
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        for(int i=0;i<b.length;i++){
            if(v.getId()==b[i].getId()){
                s+=i;
                ans.setText(""+s);
            }
        }
    }
}
