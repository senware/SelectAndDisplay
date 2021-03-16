package edu.temple.selectanddisplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
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

        getSupportActionBar().setTitle(getString(R.string.selectionTitle));

        Resources res = getResources();
        String[] dinoNames = res.getStringArray(R.array.dino_string_list);

        // array of dinosaur objects
        ArrayList<Dino> dinoArrayList = new ArrayList<>();
        dinoArrayList.add(new Dino(dinoNames[0], R.drawable.triceratops));
        dinoArrayList.add(new Dino(dinoNames[1], R.drawable.stegosaurus));
        dinoArrayList.add(new Dino(dinoNames[2], R.drawable.raptor));
        dinoArrayList.add(new Dino(dinoNames[3], R.drawable.allosaurus));
        dinoArrayList.add(new Dino(dinoNames[4], R.drawable.parasaur));
        dinoArrayList.add(new Dino(dinoNames[5], R.drawable.yutyrannus));

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