package com.example.new_math_puzzle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Winning_page extends AppCompatActivity
{
    TextView t1,t2,level;
    int levelNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winning_page);
        t1=findViewById(R.id.continuebutton);
        t2 = findViewById(R.id.mainmenubutton);
        level=findViewById(R.id.winlevel);
        levelNo = getIntent().getIntExtra("levelNo",0);
        level.setText("PUZZLE "+levelNo+" COMPLETED");
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Winning_page.this,Game_page.class);
                intent.putExtra("levelNo",levelNo);
                startActivity(intent);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Winning_page.this,MainActivity.class);
                intent.putExtra("levelNo",levelNo);
                startActivity(intent);
            }
        });

    }
}
