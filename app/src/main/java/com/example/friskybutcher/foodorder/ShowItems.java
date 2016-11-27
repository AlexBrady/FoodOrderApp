package com.example.friskybutcher.foodorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ShowItems extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_items);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            //Long position = extras.getLong("listPosition");
            //Toast.makeText(getApplicationContext(), "Name Choosen : " + position, Toast.LENGTH_SHORT).show();

        }
    }
}
