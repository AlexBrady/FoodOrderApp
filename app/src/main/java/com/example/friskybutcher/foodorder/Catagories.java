package com.example.friskybutcher.foodorder;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Catagories extends ListActivity
{
    String[] catagory = {"Starters", "Soup", "Sandwiches", "Fish", "Pasta", "Main Course", "Desert"};
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_catagories);

        setListAdapter(new MyCustomAdapter(Catagories.this, R.layout.row, catagory));
    }

    public class MyCustomAdapter extends ArrayAdapter<String>
    {
        public MyCustomAdapter(Context context, int textViewResId, String[] objects)
        {
            super(context, textViewResId, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View row = convertView;

            if(row==null)
            {
                LayoutInflater inflater = getLayoutInflater();
                row=inflater.inflate(R.layout.row, parent, false);
            }

            ImageView icon = (ImageView)row.findViewById(R.id.starter);

            TextView label = (TextView)row.findViewById(R.id.catagory);
            label.setText(catagory[position] + "\n");

            if(catagory[position] == "Soup")
            {
                icon.setImageResource(R.drawable.soup);
            }
            else if (catagory[position] == "Sandwiches")
            {
                icon.setImageResource(R.drawable.sandwich);
            }
            else if (catagory[position] == "Pasta")
            {
                icon.setImageResource(R.drawable.pasta);
            }
            else if (catagory[position] == "Fish")
            {
                icon.setImageResource(R.drawable.fish);
            }
            else if (catagory[position] == "Main Course")
            {
                icon.setImageResource(R.drawable.main_course);
            }
            else if (catagory[position] == "Desert")
            {
                icon.setImageResource(R.drawable.desert);
            }
            else
            {
                icon.setImageResource(R.drawable.starter);
            }

            return row;
        }
    }

    protected void onListItemClick(ListView i, View v, int position, long id)
    {

    }
}
