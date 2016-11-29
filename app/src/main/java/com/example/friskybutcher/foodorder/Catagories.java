package com.example.friskybutcher.foodorder;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Catagories extends ListActivity
{
    //Declare Catagory Column and int array to find the text view in the layout xml
    String[] columns = {"CATAGORY"};
    int[] to = {R.id.catagory};
    //Declare cursor, db connection and adapter
    Cursor mCursor;
    DBManager db;
    SimpleCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters);

        db = new DBManager(this);

        try
        {
            //Method in DBManager to open database and display list of catagories
            db.open();
            mCursor = db.getCategories();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        mAdapter = new SimpleCursorAdapter(this, R.layout.row, mCursor, columns, to, 0); //Set Cursor adapter

        setListAdapter(mAdapter);
        Toast.makeText(getApplicationContext(), "Tap an item to add it to your order!", Toast.LENGTH_LONG).show();
    }


    protected void onListItemClick(ListView i, View v, int position, long id)
    {
        //Switch statements for switching activites on item click
        switch(position)
        {
            //If starters is clicked by user, switch to that activity
            case 0:
                Intent starterActivity = new Intent(Catagories.this, Starters.class);
                startActivity(starterActivity);
                break;
            //If Soups is clicked by user, switch to that activity
            case 1:
                Intent soupsActivity = new Intent(Catagories.this, Soups.class);
                startActivity(soupsActivity);
                break;
            //If Sanwiches is clicked by user, switch to that activity
            case 2:
                Intent sandwichActivity = new Intent(Catagories.this, Sandwiches.class);
                startActivity(sandwichActivity);
                break;
            //If Pasta is clicked by user, switch to that activity
            case 3:
                Intent pastaActivity = new Intent(Catagories.this, Pasta.class);
                startActivity(pastaActivity);
                break;
            //If Fish is clicked by user, switch to that activity
            case 4:
                Intent fishActivity = new Intent(Catagories.this, Fish.class);
                startActivity(fishActivity);
                break;
            //If Main Course is clicked by user, switch to that activity
            case 5:
                Intent mainCourseActivity = new Intent(Catagories.this, MainCourse.class);
                startActivity(mainCourseActivity);
                break;
            //If Desert is clicked by user, switch to that activity
            case 6:
                Intent desertActivity = new Intent(Catagories.this, Desert.class);
                startActivity(desertActivity);
                break;
        }
    }

    //Button to view current order
    public void sendMessage(View view)
    {
        Intent intent = new Intent(Catagories.this, Order.class);
        startActivity(intent);
    }
}
