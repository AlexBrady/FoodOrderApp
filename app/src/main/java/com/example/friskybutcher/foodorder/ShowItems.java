/*package com.example.friskybutcher.foodorder;


import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;

public class ShowItems extends ListActivity
{
    String[] columns = {"NAME", "DESCRIPTION", "PRICE"};
    int[] to = {R.id.name, R.id.description, R.id.price};
    DBManager db;
    Cursor mCursor;
    Intent items;
    SimpleCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_items);

        items = new Intent(this, ShowItems.class);
        db = new DBManager(this);

        try
        {
            db.open();
            mCursor = db.showItems();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        mAdapter = new android.widget.SimpleCursorAdapter(this, R.layout.show_items, mCursor, columns, to, 0);

        setListAdapter(mAdapter);

    }

}*/