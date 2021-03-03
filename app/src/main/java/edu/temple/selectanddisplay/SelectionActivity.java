package edu.temple.selectanddisplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        getSupportActionBar().setTitle("Selection");

        ArrayList<Dino> dinoArrayList = new ArrayList<>();
        dinoArrayList.add(new Dino("Choose a dinosaur", 0));
        dinoArrayList.add(new Dino("Triceratops", R.drawable.triceratops));
        dinoArrayList.add(new Dino("Stegosaurus", R.drawable.stegosaurus));
        dinoArrayList.add(new Dino("Utahraptor", R.drawable.raptor));
        dinoArrayList.add(new Dino("Allosaurus", R.drawable.allosaurus));
        dinoArrayList.add(new Dino("Parasaurolophus", R.drawable.parasaur));
        dinoArrayList.add(new Dino("Yutyrannus", R.drawable.yutyrannus));

        DinoAdapter dinoAdapter = new DinoAdapter(this, dinoArrayList);

        spinner = findViewById((R.id.dinoSpinner));
        spinner.setAdapter(dinoAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    return;
                } else {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}