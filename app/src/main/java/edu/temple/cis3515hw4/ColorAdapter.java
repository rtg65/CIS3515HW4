package edu.temple.cis3515hw4;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter{
    private Context c;
    private int count;
    private String[] colors;

    public ColorAdapter(Context c, int cnt, String[] clr){
        colors = clr;
        count = cnt;
        this.c = c;
    }

    @Override
    public int getCount(){
        return count;
    }

    public Context getC() {
        return c;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;

        if (convertView != null) {
            textView = (TextView) convertView;
        } else {
            textView = new TextView(c);
        }

        textView.setText(colors[position]);
        textView.setPadding(50,50,5,50);
        textView.setBackgroundColor(Color.parseColor(parent.getContext().getResources().getStringArray(R.array.colors_values)[position]));

        return textView;
    }
}
