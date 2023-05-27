package com.example.new_math_puzzle;

import static com.example.new_math_puzzle.MainActivity.editor;
import static com.example.new_math_puzzle.MainActivity.preferences;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Leval_page extends AppCompatActivity
{

    GridView gridView;

    LevelAdapter adapter;
    ImageView imageView,imageView1;
    int levelNo,cnt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leval_page);
        imageView = findViewById(R.id.next);
        imageView1 = findViewById(R.id.back);

        levelNo = getIntent().getIntExtra("levelNo",0);
        gridView = findViewById(R.id.gridview);

        adapter = new LevelAdapter(Leval_page.this, config.no1,cnt);
        editor.putString("page","p0");
        editor.commit();

//        if(preferences.getString("page1",null).equals("p1")){
//            adapter = new LevelAdapter(Leval_page.this,config.no1);
//        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt++;

                if(cnt==1){
                    adapter = new LevelAdapter(Leval_page.this, config.no2,cnt);
                    gridView.setAdapter(adapter);
                    editor.putString("page","p1");
                    editor.commit();
                    imageView1.setVisibility(View.VISIBLE);

                }
                if(cnt==2){
                    adapter = new LevelAdapter(Leval_page.this, config.no3,cnt);
                    gridView.setAdapter(adapter);
                    editor.putString("page","p2");
                    editor.commit();
                }
                if(cnt==3){
                    adapter = new LevelAdapter(Leval_page.this, config.no4,cnt);
                    gridView.setAdapter(adapter);
                    editor.putString("page","p3");
                    editor.commit();
                }


            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt--;

                if(cnt==0){
                    adapter = new LevelAdapter(Leval_page.this, config.no1,cnt);
                    gridView.setAdapter(adapter);
                    editor.putString("page","p0");
                    editor.commit();
                    imageView1.setVisibility(View.INVISIBLE);
                }
                if(cnt==1){
                    adapter = new LevelAdapter(Leval_page.this, config.no2,cnt);
                    gridView.setAdapter(adapter);
                    editor.putString("page","p1");
                    editor.commit();
                }
                if(cnt==2){
                    adapter = new LevelAdapter(Leval_page.this, config.no3,cnt);
                    gridView.setAdapter(adapter);
                    editor.putString("page","p2");
                    editor.commit();
                }

            }
        });



        gridView.setAdapter(adapter);



    }
}
