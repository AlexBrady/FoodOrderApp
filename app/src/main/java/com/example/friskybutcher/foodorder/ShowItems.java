package com.example.friskybutcher.foodorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Toast;

public class ShowItems extends AppCompatActivity
{

    Intent showItems;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_items);

        showItems = new Intent(this, Starters.class);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            //Long position = extras.getLong("listPosition");
            //Toast.makeText(getApplicationContext(), "Name Choosen : " + position, Toast.LENGTH_SHORT).show();

        }
    }
}
