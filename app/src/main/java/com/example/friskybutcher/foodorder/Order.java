package com.example.friskybutcher.foodorder;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

        final ListView listView = (ListView) findViewById(R.id.list1);  //Sets listView as list in activity_order  xml

        //This is so that the total price textview can be found in the correct layout
        LayoutInflater inflater = getLayoutInflater();
        View vi = inflater.inflate(R.layout.starter_row, null);

        textView = (TextView) this.findViewById(R.id.total);
        db = new DBManager(this);

        //itemName is the id of the item being added to the order
        passVar = getIntent().getStringExtra(Starters.itemName);    //Get String from Starters('_id')
        passedView = (TextView) vi.findViewById(R.id.name);
        passedView.setText(passVar);    //Set the passed string to the textview in layout so it can be displayed

        try
        {
            db.open();
            mCursor = db.addToOrder(passVar);   //addToOrder method with the id of item being added passed through
            mCursor = db.viewOrder();   //Method to viewOrder
            total = db.totalPrice();    //Display the total price of all items in the current order
            String s = String.format("%.2f", total);    //Format the total price to 2 decimal places
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        mAdapter = new SimpleCursorAdapter(this, R.layout.starter_row, mCursor, columns, to, 0);

        textView.setText(String.valueOf(total));
        listView.setAdapter(mAdapter);

        Toast.makeText(getApplicationContext(), "Tap an item to remove it from your order!", Toast.LENGTH_SHORT).show();

        //On item click, remove item from order db and list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                db.remove(id);  //remove selected item from db
                mAdapter.notifyDataSetChanged();
                finish();   //refreshes activity with updated listview

                //Brought to catagoies pge after its added to order
                Intent intent = new Intent(Order.this, Catagories.class);
                startActivity(intent);
            }
        });
    }

    //Button to take user to payment options
    public void sendMessage(View view)
    {
        Intent intent = new Intent(Order.this, Pay.class);
        startActivity(intent);
    }


}
