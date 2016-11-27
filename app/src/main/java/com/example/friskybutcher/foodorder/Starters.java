package com.example.friskybutcher.foodorder;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Starters extends ListActivity
{
    String[] columns = {"NAME", "DESCRIPTION", "PRICE"};
    int[] to = {R.id.name, R.id.description, R.id.price};
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

        // Find ListView to populate
        //ListView lvItems = (ListView) findViewById(R.id.list);
        // Setup cursor adapter using cursor from last step
        TodoCursorAdapter todoAdapter = new TodoCursorAdapter(this, mCursor);
        // Attach cursor adapter to the ListView
        //lvItems.setAdapter(todoAdapter);

        mAdapter = new SimpleCursorAdapter(this, R.layout.starter_row, mCursor, columns, to, 0);

        setListAdapter(mAdapter);
    }

    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);

        /*ListView lv =  (ListView) findViewById(android.R.id.list);
        String str=lv.getItemAtPosition(position).toString();
        Intent intent = new Intent(getApplicationContext(), ShowItems.class);
        intent.putExtra("listPosition", id);
        Toast.makeText(getApplicationContext(), "List id : " + str, Toast.LENGTH_SHORT).show();
        startActivity(intent);*/



        db.addToOrder(mCursor);
    }
}
