package com.example.friskybutcher.foodorder;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Starters extends AppCompatActivity
{
    //Declare DB columns, int array for finding layout values
    String[] columns = {"NAME", "DESCRIPTION", "PRICE"};
    int[] to = {R.id.name, R.id.description, R.id.price};
    public final static String itemName = "com.example.friskybutcher.foodorder.Starters._id";   //ID of item
    //Cursor, db connection, adapter
    Cursor mCursor;
    DBManager db;
    Intent starter;
    SimpleCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters);

        ListView listView = (ListView) findViewById(android.R.id.list); //List for printing starters in xml file

        starter = new Intent(this, Starters.class);
        db = new DBManager(this);

        try
        {
            //Open db and grab items from database
            db.open();
            mCursor = db.getStarters();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        mAdapter = new SimpleCursorAdapter(this, R.layout.starter_row, mCursor, columns, to, 0);

        //Set the adapter and listview
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(onListClick);
    }

    //On item click, send item to user order list
    private AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener()
    {
        public void onItemClick(AdapterView<?> parent,
                                View view, int position,
                                long id)
        {
            Intent i = new Intent(Starters.this, Order.class);

            //Send id of item clicked to order activity
            i.putExtra(itemName, String.valueOf(id));
            startActivity(i);
        }
    };

    //Button to view user current order
    public void sendMessage(View view)
    {
        Intent intent = new Intent(Starters.this, Order.class);
        startActivity(intent);
    }
}
