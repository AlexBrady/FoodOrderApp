package com.example.friskybutcher.foodorder;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by friskybutcher on 25/11/16.
 */

public class TodoCursorAdapter extends CursorAdapter
{
    public TodoCursorAdapter(Context context, Cursor cursor)
    {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent)
    {
        return LayoutInflater.from(context).inflate(R.layout.activity_starters, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor)
    {
        // Find fields to populate in inflated template
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView description = (TextView) view.findViewById(R.id.description);
        TextView price = (TextView) view.findViewById(R.id.price);
        // Extract properties from cursor
        String item_name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String item_desc = cursor.getString(cursor.getColumnIndexOrThrow("description"));
        int item_price = cursor.getInt(cursor.getColumnIndexOrThrow("price"));
        // Populate fields with extracted properties
        name.setText(item_name);
        price.setText(String.valueOf(item_price));
        description.setText(item_desc);
    }
}