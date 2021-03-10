package edu.temple.selectanddisplay;

import android.app.ActionBar;
import android.content.Context;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DinoAdapter extends BaseAdapter {

    Context context;
    ArrayList<Dino> items;

    // Constructor
    public DinoAdapter(Context context, ArrayList<Dino> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    // return number of items in array
    // do not include default instructions
    public int getCount() {
        return items.size() - 1;
    }

    @Override
    // returns dinosaur object at position
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    // unused, required for subclasses of BaseAdapter
    public long getItemId(int position) {
        return position;
    }

    @Override
    // the non-dropdown view only displays the name
    public View getView(int position, View convertView, ViewGroup parent) {
        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView textView;

        if (convertView == null) {
            relativeLayout = new RelativeLayout(context);
            imageView = new ImageView(context);
            textView = new TextView(context);

            relativeLayout.addView(imageView);
            relativeLayout.addView(textView);

            // layout params to put the text at the bottom
            RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            textParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);

            // text view formatting
            textView.setLayoutParams(textParams);
            textView.setTextSize(14);
            textView.setTextColor(0xFFFFFFFF);
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
            textView.setBackgroundResource(R.color.grey);

            // image view formatting
            imageView.getLayoutParams().height = 400;
            imageView.getLayoutParams().width = 400;

        } else {
            relativeLayout = (RelativeLayout) convertView;
            imageView = (ImageView) relativeLayout.getChildAt(0);
            textView = (TextView) relativeLayout.getChildAt(1);
        }

        imageView.setImageResource(items.get(position).getImageRes());
        textView.setText(items.get(position).getName());

        return relativeLayout;
    }

//    @Override
//    // the dropdown view displays both the name and the image
//    public View getDropDownView(int position, View convertView, ViewGroup parent) {
//        TextView textView;
//        ImageView imageView;
//
//        // container for object data views
//        LinearLayout linearLayout;
//
//        // only need to do this once for entire array
//        if (convertView == null) {
//            linearLayout = new LinearLayout(context);
//            linearLayout.setOrientation((LinearLayout.HORIZONTAL));
//
//            textView = new TextView(context);
//            imageView = new ImageView(context);
//
//            textView.setPadding(8, 16, 16, 16);
//            textView.setTextSize(20);
//
//            linearLayout.addView(imageView);
//            linearLayout.addView(textView);
//
//            imageView.getLayoutParams().height = 150;
//            imageView.getLayoutParams().width = 150;
//        }
//        // retrieve views formatted as above
//        else {
//            linearLayout = (LinearLayout) convertView;
//            imageView = (ImageView) linearLayout.getChildAt(0);
//            textView = (TextView) linearLayout.getChildAt((1));
//        }
//
//        // necessarily unique per array element
//        // do this for each of them
//        imageView.setImageResource(items.get(position).getImageRes());
//        textView.setText(items.get(position).getName());
//
//        return linearLayout;
//    }
}
