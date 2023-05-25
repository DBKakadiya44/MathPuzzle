package com.example.new_math_puzzle;

import static com.example.new_math_puzzle.MainActivity.preferences;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LevelAdapter extends BaseAdapter {

    Leval_page leval_page;
    int[] no;

    public LevelAdapter(Leval_page leval_page, int[] no) {
        this.leval_page = leval_page;
        this.no = no;
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

        ImageView imageView = convertView.findViewById(R.id.lockimg);


        if(preferences.getString("levelstatus1",null).equals("win")){
            imageView.setImageResource(R.drawable.tick);
            //imageView.isShown();
        }


        TextView textView = convertView.findViewById(R.id.lockno);
        textView.setText(""+no[position]);
        return convertView;
    }
}
