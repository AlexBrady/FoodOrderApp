package com.example.friskybutcher.foodorder;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Starters extends ListActivity
{
    String[] columns = {"NAME", "DESCRIPTION", "PRICE"};
    int[] to = {R.id.name, R.id.description, R.id.price};
    Cursor mCursor;
    DBManager db;
    Intent starter;
    SimpleCursorAdapter mAdapter;

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

        mAdapter = new SimpleCursorAdapter(this, R.layout.starter_row, mCursor, columns, to, 0);

        setListAdapter(mAdapter);
    }

    public void onListItemClick(ListView i, View v, int position, long id)
    {

    }
}
