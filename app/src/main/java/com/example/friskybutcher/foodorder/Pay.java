package com.example.friskybutcher.foodorder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Pay extends Activity
{
    //Spinner to select diffent payment methods
    private Spinner spinner;
    Button payButton;
    DBManager db;
    Intent pay;
    String placed = "Order Placed !";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        pay = new Intent(this, Pay.class);
        db = new DBManager(this);

        addItemsOnSpinner();
        addListenerOnSpinnerItemSelection();

        payButton = (Button) this.findViewById(R.id.finish);

        payButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(), placed, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addItemsOnSpinner()
    {
        spinner = (Spinner) findViewById(R.id.spinner);
        List<String> paymentMethods = new ArrayList<String>();
        //Add payment options to the spinner dropdown list
        paymentMethods.add("Cash");
        paymentMethods.add("Credit");
        paymentMethods.add("Debit");

        ArrayAdapter<String>  dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paymentMethods);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection()
    {
        spinner = (Spinner) findViewById(R.id.spinner);
    }

    /*public void sendMessage(View view)
    {
        Toast.makeText(this, placed, Toast.LENGTH_SHORT);
    }*/
}

