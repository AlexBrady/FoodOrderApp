package com.example.friskybutcher.foodorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    //Declare DBManager, user table and login button
    DBManager myDb;
    public EditText table_number;
    Button butOne;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DBManager(this);

        //Find ID of table number EditText and Button
        table_number = (EditText) findViewById(R.id.table_no);
        butOne = (Button) findViewById(R.id.button_table);
        butOne.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        //Switch to Catagory page when login button clicked
        Toast.makeText(getApplicationContext(), "Logged in at Table  " + table_number.getText(), Toast.LENGTH_LONG).show();
        startActivity(new Intent(MainActivity.this, Catagories.class));
    }

}

