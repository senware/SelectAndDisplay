package edu.temple.selectanddisplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Spinner;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {
    // declare spinner pointer
    GridView dinoGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        getSupportActionBar().setTitle("Selection");

        // array of dinosaur objects
        ArrayList<Dino> dinoArrayList = new ArrayList<>();
        dinoArrayList.add(new Dino("Triceratops", R.drawable.triceratops));
        dinoArrayList.add(new Dino("Stegosaurus", R.drawable.stegosaurus));
        dinoArrayList.add(new Dino("Utahraptor", R.drawable.raptor));
        dinoArrayList.add(new Dino("Allosaurus", R.drawable.allosaurus));
        dinoArrayList.add(new Dino("Parasaurolophus", R.drawable.parasaur));
        dinoArrayList.add(new Dino("Yutyrannus", R.drawable.yutyrannus));

        // instantiate custom adapter
        DinoAdapter dinoAdapter = new DinoAdapter(this, dinoArrayList);

        // instantiate spinner and attach adapter
        dinoGrid = findViewById((R.id.dinoGrid));
        dinoGrid.setAdapter(dinoAdapter);

        // click behavior
        dinoGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // send information about selection to the display activity and launch it
                Intent displayIntent = new Intent(SelectionActivity.this, DisplayActivity.class);
                displayIntent.putExtra("name", dinoArrayList.get(position).getName());
                displayIntent.putExtra("imageRes", dinoArrayList.get(position).getImageRes());
                startActivity(displayIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}