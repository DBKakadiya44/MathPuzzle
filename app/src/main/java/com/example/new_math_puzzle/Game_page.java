package com.example.new_math_puzzle;

import static com.example.new_math_puzzle.MainActivity.editor;
import static com.example.new_math_puzzle.MainActivity.preferences;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game_page extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView,skip,delet;
    TextView ans,submit,levelboard;
    TextView[] b=new TextView[10];
    String s="";

    int levelNo=0;
    private ArrayList<String> imgArr=new ArrayList<>();
    private List<String> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);
        imageView = findViewById(R.id.main_image);
        levelNo=getIntent().getIntExtra("levelNo",0);
        getImage(); // we will get images from assets at here
        ans=findViewById(R.id.ansfield);
        delet = findViewById(R.id.delet);
        submit = findViewById(R.id.submit);
        levelboard=findViewById(R.id.levelboard);
        levelboard.setText("LEVEL "+(levelNo+1));
        skip = findViewById(R.id.skipbutton);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(levelNo<19) {
                    AlertDialog.Builder builder=new AlertDialog.Builder(Game_page.this);
                    builder.setTitle("Skip");
                    builder.setMessage("Are you sure you want to skip this level without playing?");
                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            levelNo++;
                            getImage();
                            levelboard.setText("LEVEL "+(levelNo+1));
                            editor.putInt("levelNo",levelNo);
                            editor.putString("levelstatus"+(levelNo),"skip");
                            editor.commit();
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            builder.setCancelable(true);
                        }
                    });
                    builder.show();

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
                String info = preferences.getString("info"+levelNo,"play");
                if(info.equals("play")) {
                    if (ans.getText().toString().equals(config.ansArr[levelNo])) {
                        levelNo++;
                        editor.putInt("levelNo", levelNo);
                        editor.putString("levelstatus" + (levelNo), "win");
                        editor.putString("info" + levelNo, "played");
                        editor.commit();
                        Intent intent = new Intent(Game_page.this, Winning_page.class);
                        intent.putExtra("levelNo", levelNo);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Game_page.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    }
                }
                if(info.equals("played")) {
                    if (ans.getText().toString().equals(config.ansArr[levelNo])) {
                        levelNo++;
                        editor.putString("levelstatus" + (levelNo), "win");
                        editor.commit();
                        Intent intent = new Intent(Game_page.this, Winning_page.class);
                        intent.putExtra("levelNo", levelNo);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Game_page.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    private void getImage()
    {
        String[] images = new String[0];
        try {
            images = getAssets().list("images/");
            imgArr = new ArrayList<String>(Arrays.asList(images));
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
        Collections.sort(imgArr);
        arrayList=imgArr.subList(3,imgArr.size()-1);
        InputStream inputstream = null;
        try {
            inputstream = getAssets().open("images/"+arrayList.get(levelNo));
            Drawable drawable = Drawable.createFromStream(inputstream, null);
            imageView.setImageDrawable(drawable);
            inputstream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
