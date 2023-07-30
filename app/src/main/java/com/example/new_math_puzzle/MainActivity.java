package com.example.new_math_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView,textView1;

    public static SharedPreferences preferences;
    public static SharedPreferences.Editor editor;
    int cnt,a,levelNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.continuebutton);
        textView1 = findViewById(R.id.puzzles);

        preferences = getSharedPreferences("mypref",MODE_PRIVATE);
        editor= preferences.edit();
        levelNo=preferences.getInt("levelNo",0);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Game_page.class);
                intent.putExtra("levelNo",levelNo);
                startActivity(intent);
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Leval_page.class);
                intent.putExtra("levelNo",levelNo);
                startActivity(intent);
            }
        });

    }
}