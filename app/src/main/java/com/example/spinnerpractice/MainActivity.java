package com.example.spinnerpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner drink, ice_temp;
    TextView cart;
    String[] iceSet1 = {"去冰","微冰","少冰","正常冰"};
    String[] iceSet2 = {"熱","溫","去冰","微冰","少冰","正常冰"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cart = (TextView)findViewById(R.id.textView);
        drink = (Spinner)findViewById(R.id.spinner_drink);
        ice_temp = (Spinner)findViewById(R.id.spinner_ice);
        drink.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String[] tempSet;
        if(position == 0)
            tempSet = iceSet1;  // 沒有溫的柳橙汁
        else tempSet = iceSet2;
        ArrayAdapter<String> tempAD = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,tempSet);
        tempAD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ice_temp.setAdapter(tempAD);
    }
    public void showOrder(View v){
        String itemInCart = drink.getSelectedItem() + ", " + ice_temp.getSelectedItem();
        cart.setText(itemInCart);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}