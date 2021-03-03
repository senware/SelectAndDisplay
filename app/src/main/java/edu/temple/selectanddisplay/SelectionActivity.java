package edu.temple.selectanddisplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {
    // declare spinner pointer
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        getSupportActionBar().setTitle("Selection");

        // array of dinosaur objects
        ArrayList<Dino> dinoArrayList = new ArrayList<>();
        dinoArrayList.add(new Dino("Choose a dinosaur", 0));
        dinoArrayList.add(new Dino("Triceratops", R.drawable.triceratops));
        dinoArrayList.add(new Dino("Stegosaurus", R.drawable.stegosaurus));
        dinoArrayList.add(new Dino("Utahraptor", R.drawable.raptor));
        dinoArrayList.add(new Dino("Allosaurus", R.drawable.allosaurus));
        dinoArrayList.add(new Dino("Parasaurolophus", R.drawable.parasaur));
        dinoArrayList.add(new Dino("Yutyrannus", R.drawable.yutyrannus));

        // instantiate custom adapter
        DinoAdapter dinoAdapter = new DinoAdapter(this, dinoArrayList);

        // instantiate spinner and attach adapter
        spinner = findViewById((R.id.dinoSpinner));
        spinner.setAdapter(dinoAdapter);

        // click behavior
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // dont do anything when the default selection is chosen
                if (position == 0) {
                    return;
                } else {
                    // send information about selection to the display activity and launch it
                    Intent displayIntent = new Intent(SelectionActivity.this, DisplayActivity.class);
                    displayIntent.putExtra("name", dinoArrayList.get(position).getName());
                    displayIntent.putExtra("imageRes", dinoArrayList.get(position).getImageRes());
                    startActivity(displayIntent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // when the selection activity is returned to, set the spinner back to the default choice
        spinner.setSelection(0);
    }
}