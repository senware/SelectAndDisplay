package edu.temple.selectanddisplay;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        getSupportActionBar().setTitle("Display");

        Intent intent = getIntent();

        TextView textView = findViewById(R.id.dinoNameLabel);
        textView.setTextSize(20);
        textView.setText(intent.getStringExtra("name"));

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(intent.getIntExtra("imageRes", 0));
    }
}