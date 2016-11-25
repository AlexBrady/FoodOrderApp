package com.example.friskybutcher.foodorder;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class Fish extends ListActivity
{

    String[] columns = {"NAME", "DESCRIPTION", "PRICE"};
    int[] to = {R.id.name, R.id.description, R.id.price};
    Cursor mCursor;
    DBManager db;
    Intent soup;
    SimpleCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters);

        soup = new Intent(this, Fish.class);
        db = new DBManager(this);

        try
        {
            db.open();
            mCursor = db.getFish();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        mAdapter = new SimpleCursorAdapter(this, R.layout.starter_row, mCursor, columns, to, 0);

        setListAdapter(mAdapter);
    }

}
