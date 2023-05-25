package com.example.new_math_puzzle;

import static com.example.new_math_puzzle.MainActivity.editor;
import static com.example.new_math_puzzle.MainActivity.preferences;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Leval_page extends AppCompatActivity
{

    GridView gridView;
    LevelAdapter adapter;
    int levelNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leval_page);

        levelNo = getIntent().getIntExtra("levelNo",0);
        gridView = findViewById(R.id.gridview);
        adapter = new LevelAdapter(Leval_page.this,config.no);
        gridView.setAdapter(adapter);

//        if(preferences.getString("levelstatus1","skip").equals("win")){
//            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//
//        }else {
//            System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
//        }
    }
}
