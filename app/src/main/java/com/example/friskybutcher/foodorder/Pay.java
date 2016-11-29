package com.example.friskybutcher.foodorder;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Pay extends Activity
{
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        addItemsOnSpinner();
        addListenerOnSpinnerItemSelection();

    }

    public void addItemsOnSpinner()
    {
        spinner = (Spinner) findViewById(R.id.spinner);
        List<String> paymentMethods = new ArrayList<String>();
        paymentMethods.add("Cash");
        paymentMethods.add("Credit");
        paymentMethods.add("Debit");
        paymentMethods.add("PayPal");

        ArrayAdapter<String>  dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paymentMethods);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection()
    {
        spinner = (Spinner) findViewById(R.id.spinner);
    }
}
