package com.example.friskybutcher.foodorder;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Order extends AppCompatActivity
{
    String[] columns = {"NAME", "PRICE"};
    int[] to = {R.id.name, R.id.price};
    String passVar = null;
    private TextView passedView = null;
    Cursor mCursor;
    DBManager db;
    SimpleCursorAdapter mAdapter;
    Button back;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starters);

        ListView listView = (ListView) findViewById(android.R.id.list);

        LayoutInflater inflater = getLayoutInflater();
        View vi = inflater.inflate(R.layout.starter_row, null);

        db = new DBManager(this);


        passVar = getIntent().getStringExtra(Starters.itemName);
        passedView = (TextView)vi.findViewById(R.id.name);
        passedView.setText(passVar);
        Toast.makeText(getApplicationContext(), passVar, Toast.LENGTH_SHORT).show();

        try
        {
            db.open();
            mCursor = db.addToOrder(passVar);
            mCursor = db.viewOrder();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        mAdapter = new SimpleCursorAdapter(this, R.layout.starter_row, mCursor, columns, to, 0);

        listView.setAdapter(mAdapter);
    }
}
