package com.example.friskybutcher.foodorder;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Pasta extends ListActivity
{
    String[] columns = {"NAME", "DESCRIPTION", "PRICE"};
    int[] to = {R.id.name, R.id.description, R.id.price};
    Cursor mCursor;
    DBManager db;
    //Intent soup;
    SimpleCursorAdapter mAdapter;
    public final static String itemName = "com.example.friskybutcher.foodorder.Starters._id";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters);

        ListView listView = (ListView) findViewById(android.R.id.list);

        //soup = new Intent(this, Pasta.class);
        db = new DBManager(this);

        try
        {
            db.open();
            mCursor = db.getPasta();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        mAdapter = new SimpleCursorAdapter(this, R.layout.starter_row, mCursor, columns, to, 0);

        setListAdapter(mAdapter);
        listView.setOnItemClickListener(onListClick);
    }

    private AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener()
    {
        public void onItemClick(AdapterView<?> parent,
                                View view, int position,
                                long id)
        {
            Intent i = new Intent(Pasta.this, Order.class);

            i.putExtra(itemName, String.valueOf(id));
            startActivity(i);
        }
    };

    public void sendMessage(View view)
    {
        Intent intent = new Intent(Pasta.this, Order.class);
        startActivity(intent);
    }
}
