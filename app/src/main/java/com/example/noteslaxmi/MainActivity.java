package com.example.noteslaxmi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private EditText noteEditText;
    private Button addButton;
    private ListView notesListview;
    private ArrayList<String> notesList;
    private ArrayAdapter<String>
    notesAdapter;

    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_main);
        noteEditText = findViewById(R.id.noteEditText);
        addButton = findViewById(R.id.addButton);
        notesListview = findViewById(R.id.notesListview);

        notesList = new ArrayList<>();
        notesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,notesList);

        notesListview.setAdapter(notesAdapter);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = noteEditText.getText().toString();
                notesList.add(note);

                notesAdapter.notifyDataSetChanged();
                noteEditText.getText().clear();
            }
        });

    }

}
