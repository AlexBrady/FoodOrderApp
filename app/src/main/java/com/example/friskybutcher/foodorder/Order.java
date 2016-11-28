package com.example.friskybutcher.foodorder;

import android.database.Cursor;
import android.database.SQLException;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class Order extends AppCompatActivity
{
    String[] columns = {"NAME", "PRICE"};
    int[] to = {R.id.name, R.id.price};
    String passVar = null;
    private TextView passedView = null;
    Cursor mCursor;
    DBManager db;
    SimpleCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters);

        ListView listView = (ListView) findViewById(android.R.id.list);

        db = new DBManager(this);

        passVar = getIntent().getStringExtra(Starters.itemName);
        passedView = (TextView) findViewById(R.id.name);
        passedView.setText(passVar);

        try
        {
            db.open();
            mCursor = db.addToOrder(passVar);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        mAdapter = new SimpleCursorAdapter(this, R.layout.starter_row, mCursor, columns, to, 0);

        listView.setAdapter(mAdapter);

    }


}
