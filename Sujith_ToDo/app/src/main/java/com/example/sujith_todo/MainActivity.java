package com.example.sujith_todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements ListView.OnItemClickListener{

    private Button ButtonEnter;
    private TextView TextViewEnter;
    private String ItemTemp;
    private ArrayList<String> listItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButtonEnter = findViewById(R.id.btnEnter);

        TextViewEnter = findViewById(R.id.editTextEnter);


        ArrayList<String> listItems = new ArrayList<> ();


        ArrayAdapter<String> adapterItems = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice,
                listItems
        );

        ListView listViews = findViewById(R.id.listView);
        listViews.setAdapter(adapterItems);
        listViews.setOnItemClickListener(this);

        ButtonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemTemp = TextViewEnter.getText().toString();
                listItems.add(ItemTemp);
                ItemTemp = "";
                TextViewEnter.setText("");
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CheckedTextView item = (CheckedTextView) view;
        item.setChecked(!item.isChecked());

    }
}