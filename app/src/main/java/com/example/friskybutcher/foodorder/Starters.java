package com.example.friskybutcher.foodorder;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Starters extends AppCompatActivity
{
    String[] columns = {"NAME", "DESCRIPTION", "PRICE"};
    int[] to = {R.id.name, R.id.description, R.id.price};
    public final static String itemName = "com.example.friskybutcher.foodorder.Starters._id";

    //ListView listView = (ListView) findViewById(R.id.list);

    Cursor mCursor;
    DBManager db;
    Intent starter;
    SimpleCursorAdapter mAdapter;
    //TodoDatabaseHandler is a SQLiteOpenHelper class connecting to SQLite
     TodoCursorAdapter handler = new TodoCursorAdapter(this, mCursor);
    //Get access to the underlying writeable database
    //SQLiteDatabase db_2 = handler.getWritableDatabase();
    // Query for items from the database and get a cursor back
    //Cursor todoCursor = db_2.rawQuery("SELECT  * FROM food_items", null);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters);

        ListView listView = (ListView) findViewById(android.R.id.list);

        starter = new Intent(this, Starters.class);
        db = new DBManager(this);

        try
        {
            db.open();
            mCursor = db.getStarters();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        mAdapter = new SimpleCursorAdapter(this, R.layout.starter_row, mCursor, columns, to, 0);

        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(onListClick);
    }

    private AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener()
    {
        public void onItemClick(AdapterView<?> parent,
                                View view, int position,
                                long id)
        {
            Intent i = new Intent(Starters.this, Order.class);

            i.putExtra(itemName, String.valueOf(id));
            startActivity(i);
        }
    };
}
