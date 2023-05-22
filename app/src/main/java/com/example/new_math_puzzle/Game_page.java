package com.example.new_math_puzzle;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game_page extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView,skip,delet;
    TextView ans,submit;
    TextView[] b=new TextView[10];
    String s="";
    int a=0,cnt;
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

        skip = findViewById(R.id.skipbutton);
//        skip.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(cnt<19) {
//                    cnt++;
//                    imageView.setImageResource(config.img[cnt]);
//                }
//            }
//        });

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
                Log.d("TTT", "onClick: Submit");
                if(ans.getText().toString().equals(config.ansArr[levelNo]))
                {
                    Log.d("TTT", "onClick: true");
                    levelNo++;
                    Intent intent=new Intent(Game_page.this, Game_page.class);
                    intent.putExtra("levelNo",levelNo);
                    startActivity(intent);
                    //finish();
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
        Log.d("TTT", "befor: All images="+imgArr);
        arrayList=imgArr.subList(3,imgArr.size()-1);
        Log.d("TTT", "after: All images="+arrayList);
        InputStream inputstream = null;
        try {
            inputstream = getAssets().open("images/"+arrayList.get(levelNo));
            Drawable drawable = Drawable.createFromStream(inputstream, null);
            //System.out.println("input Stream="+drawable);
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
