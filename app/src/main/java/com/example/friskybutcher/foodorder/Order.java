package com.example.friskybutcher.foodorder;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Order extends AppCompatActivity
{
    String[] columns = {"NAME", "PRICE"};
    int[] to = {R.id.name, R.id.price};
    String passVar = null;
    public TextView passedView = null;
    TextView textView;
    Cursor mCursor;
    DBManager db;
    double total;
    SimpleCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        final ListView listView = (ListView) findViewById(R.id.list1);

        LayoutInflater inflater = getLayoutInflater();
        View vi = inflater.inflate(R.layout.starter_row, null);

        textView = (TextView) this.findViewById(R.id.total);
        db = new DBManager(this);

        passVar = getIntent().getStringExtra(Starters.itemName);
        passedView = (TextView) vi.findViewById(R.id.name);
        passedView.setText(passVar);

        try
        {
            db.open();
            mCursor = db.addToOrder(passVar);
            mCursor = db.viewOrder();
            total = db.totalPrice();
            String s = String.format("%.2f", total);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        mAdapter = new SimpleCursorAdapter(this, R.layout.starter_row, mCursor, columns, to, 0);

        textView.setText(String.valueOf(total));
        listView.setAdapter(mAdapter);

        Toast.makeText(getApplicationContext(), "Tap an item to remove it from your order!", Toast.LENGTH_SHORT).show();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                db.remove(id);
                mAdapter.notifyDataSetChanged();
                finish();
                Intent intent = new Intent(Order.this, Catagories.class);
                startActivity(intent);
            }
        });
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(Order.this, Pay.class);
        startActivity(intent);
    }


}
