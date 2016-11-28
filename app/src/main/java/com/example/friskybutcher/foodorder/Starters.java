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
    ArrayList<String> arrayListName = new ArrayList<String>();
    public final static String itemName = "com.example.friskybutcher.foodorder.Starters.NAME";

    //ListView listView = (ListView) findViewById(R.id.list);

    TextView orderName;
    TextView orderPrice;

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

       /* mAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder()
        {
            @Override
            public boolean setViewValue(View view, Cursor cursor, int column)
            {
                // let's suppose that the column 3 is the date
                if( column == 1 )
                {
                    TextView tv = (TextView) view;

                    // get name from cursor
                    String nameStr = cursor.getString(cursor.getColumnIndex("name"));
                    arrayListName.add(nameStr);
                    //Log.e("myError", dateStr);
                    return true;
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "fail: ", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });*/

        //orderName = (TextView) findViewById(R.id.name2);
        //orderPrice = (TextView) findViewById(R.id.price2);

        listView.setAdapter(mAdapter);
        //listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(onListClick);



        Toast.makeText(getApplicationContext(), "name: ", Toast.LENGTH_SHORT).show();



        //String row1 = (String) orderName.getText();
       // String row2 = (String) orderPrice.getText();
        //float rowPrice = Float.parseFloat(row2);

        // db.addToOrder(row1, rowPrice);

        //Toast.makeText(getApplicationContext(), "" + row1 + " added to order!", Toast.LENGTH_SHORT).show();
    }

    /*protected void onListItemClick(ListView listView, View v, int position, long id)
    {
        super.onListItemClick(listView, v, position, id);

        orderName = (TextView) findViewById(R.id.name);
        orderPrice = (TextView) findViewById(R.id.price);

        final String row1 = orderName.getText().toString();
       // ListView lv =  (ListView) findViewById(android.R.id.list);
       // String str = lv.getItemAtPosition(position).toString();
        //Intent intent = new Intent(getApplicationContext(), ShowItems.class);
        //intent.putExtra("listPosition", id);
        Toast.makeText(getApplicationContext(), "yo: " + orderName, Toast.LENGTH_SHORT).show();
        //startActivity(intent);
    }*/

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
