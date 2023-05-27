package com.example.new_math_puzzle;

import static com.example.new_math_puzzle.MainActivity.editor;
import static com.example.new_math_puzzle.MainActivity.preferences;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LevelAdapter extends BaseAdapter {

    Leval_page leval_page;
    int[] no;
    int cnt;

    public LevelAdapter(Leval_page leval_page, int[] no, int cnt) {
        this.leval_page = leval_page;
        this.no = no;
        this.cnt = cnt;
    }

    @Override
    public int getCount() {
        return no.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(leval_page).inflate(R.layout.leval_page_item,parent,false);

//        if(position<6){
//            editor.putString("page","p0");
//            editor.commit();
//        }
//        if(position>=6 && position<12){
//            editor.putString("page","p1");
//            editor.commit();
//        }
//        if(position>=12 && position<18){
//            editor.putString("page","p2");
//            editor.commit();
//        }
//        if(position>=18 && position<20){
//            editor.putString("page","p3");
//            editor.commit();
//        }

        String page = preferences.getString("page","pp");

        if(page.equals("p0")){
                ImageView lock = convertView.findViewById(R.id.lockimg);
                ImageView tick = convertView.findViewById(R.id.tick);
                TextView textView = convertView.findViewById(R.id.lockno);
                String status = preferences.getString("levelstatus"+(position+1),"pending");
                int levelNo = preferences.getInt("levelNo",0);
                textView.setText("");

                if(status.equals("win")){
                    lock.setVisibility(View.INVISIBLE);
                    textView.setText(""+no[position]);
                    tick.setImageResource(R.drawable.tick);
                } else if (status.equals("skip") || levelNo==position) {
                    lock.setVisibility(View.INVISIBLE);
                    textView.setText(""+no[position]);
                }

                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(leval_page,Game_page.class);
                        intent.putExtra("levelNo",position);
                        leval_page.startActivity(intent);
                    }
                });
        }

        if(page.equals("p1")){
            ImageView lock = convertView.findViewById(R.id.lockimg);
            ImageView tick = convertView.findViewById(R.id.tick);
            TextView textView = convertView.findViewById(R.id.lockno);
            String status = preferences.getString("levelstatus"+(position+7),"pending");
            int levelNo = preferences.getInt("levelNo",0);
            textView.setText("");

            if(status.equals("win")){
                lock.setVisibility(View.INVISIBLE);
                textView.setText(""+no[position]);
                tick.setImageResource(R.drawable.tick);
            } else if (status.equals("skip") || levelNo==position+7) {
                lock.setVisibility(View.INVISIBLE);
                textView.setText(""+no[position]);
            }

            tick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(leval_page,Game_page.class);
                    intent.putExtra("levelNo",position+6);
                    leval_page.startActivity(intent);
                }
            });
        }

        if(page.equals("p2")){
            ImageView lock = convertView.findViewById(R.id.lockimg);
            ImageView tick = convertView.findViewById(R.id.tick);
            TextView textView = convertView.findViewById(R.id.lockno);
            String status = preferences.getString("levelstatus"+(position+13),"pending");
            int levelNo = preferences.getInt("levelNo",0);
            textView.setText("");

            if(status.equals("win")){
                lock.setVisibility(View.INVISIBLE);
                textView.setText(""+no[position]);
                tick.setImageResource(R.drawable.tick);
            } else if (status.equals("skip") || levelNo==position+13) {
                lock.setVisibility(View.INVISIBLE);
                textView.setText(""+no[position]);
            }

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(leval_page,Game_page.class);
                    intent.putExtra("levelNo",position+12);
                    leval_page.startActivity(intent);
                }
            });
        }

        if(page.equals("p3")){
            ImageView lock = convertView.findViewById(R.id.lockimg);
            ImageView tick = convertView.findViewById(R.id.tick);
            TextView textView = convertView.findViewById(R.id.lockno);
            String status = preferences.getString("levelstatus"+(position+19),"pending");
            int levelNo = preferences.getInt("levelNo",0);
            textView.setText("");

            if(status.equals("win")){
                lock.setVisibility(View.INVISIBLE);
                textView.setText(""+no[position]);
                tick.setImageResource(R.drawable.tick);
            } else if (status.equals("skip") || levelNo==position+19) {
                lock.setVisibility(View.INVISIBLE);
                textView.setText(""+no[position]);
            }

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(leval_page,Game_page.class);
                    intent.putExtra("levelNo",position+18);
                    leval_page.startActivity(intent);
                }
            });
        }


//        ImageView lock = convertView.findViewById(R.id.lockimg);
//        ImageView tick = convertView.findViewById(R.id.tick);
//        TextView textView = convertView.findViewById(R.id.lockno);
//        String status = preferences.getString("levelstatus"+(position+1),"pending");
//        int levelNo = preferences.getInt("levelNo",0);
//        textView.setText("");
//
//        if(status.equals("win")){
//            lock.setVisibility(View.INVISIBLE);
//            textView.setText(""+no[position]);
//            tick.setImageResource(R.drawable.tick);
//        } else if (status.equals("skip") || levelNo==position) {
//            lock.setVisibility(View.INVISIBLE);
//            textView.setText(""+no[position]);
//        }


        return convertView;
    }
}
