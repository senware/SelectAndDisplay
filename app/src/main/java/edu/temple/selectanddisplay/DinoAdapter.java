package edu.temple.selectanddisplay;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DinoAdapter extends BaseAdapter {

    Context context;
    ArrayList<Dino> items;

    public DinoAdapter(Context context, ArrayList<Dino> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() { return items.size(); }

    @Override
    public Object getItem(int position) { return items.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;

        if (convertView == null) {
            textView = new TextView(context);

            textView.setPadding(8, 16, 16, 16);
            textView.setTextSize(20);

        }
        else {
            textView = (TextView) convertView;
        }

        textView.setText(items.get(position).getName());

        return textView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        ImageView imageView;

        LinearLayout linearLayout;

        if (convertView == null) {
            linearLayout = new LinearLayout(context);
            linearLayout.setOrientation((LinearLayout.HORIZONTAL));

            textView = new TextView(context);
            imageView = new ImageView(context);

            textView.setPadding(8, 16, 16, 16);
            textView.setTextSize(20);

            linearLayout.addView(imageView);
            linearLayout.addView(textView);

            imageView.getLayoutParams().height = 150;
            imageView.getLayoutParams().width = 150;
        }
        else {
            linearLayout = (LinearLayout) convertView;
            imageView = (ImageView) linearLayout.getChildAt(0);
            textView = (TextView) linearLayout.getChildAt((1));
        }

        imageView.setImageResource(items.get(position).getImageRes());
        textView.setText(items.get(position).getName());

        return linearLayout;
    }
}
