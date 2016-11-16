package com.example.friskybutcher.foodorder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by friskybutcher on 16/11/16.
 */

public class MyCustomAdapter extends ArrayAdapter<String>
{
    Context context;
    String[] obj;

    public MyCustomAdapter(Context context, int textViewResId, String[] objects)
    {
        super(context, textViewResId, objects);
        this.obj = obj;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;

        if(row==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            row=inflater.inflate(R.layout.row, parent, false);
        }

        TextView label = (TextView)row.findViewById(R.id.catagory);
        label.setText(obj[position] + "\n");

        ImageView icon = (ImageView)row.findViewById(R.id.starter);

        if(obj[position] == "Soup")
        {
            icon.setImageResource(R.drawable.soup);
        }
        else if (obj[position] == "Sandwich")
        {
            icon.setImageResource(R.drawable.sandwich);
        }
        else if (obj[position] == "Pasta")
        {
            icon.setImageResource(R.drawable.pasta);
        }
        else if (obj[position] == "Fish")
        {
            icon.setImageResource(R.drawable.fish);
        }
        else if (obj[position] == "Main Course")
        {
            icon.setImageResource(R.drawable.main_course);
        }
        else if (obj[position] == "Desert")
        {
            icon.setImageResource(R.drawable.desert);
        }

        return row;
    }
}
