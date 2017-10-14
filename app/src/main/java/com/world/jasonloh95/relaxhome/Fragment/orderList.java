package com.world.jasonloh95.relaxhome.Fragment;

import android.app.Activity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.world.jasonloh95.relaxhome.R;
import com.world.jasonloh95.relaxhome.data.orders;
import com.world.jasonloh95.relaxhome.listView.orderAdapter;
import com.world.jasonloh95.relaxhome.orderPage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JasonLoh95 on 14/10/2017.
 */

public class orderList extends AppCompatActivity {


    ListView listViewOrder;
    DatabaseReference databaseOrder;
    private Activity context;
    List<orders> orders;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);

        databaseOrder = FirebaseDatabase.getInstance().getReference().child("order");
        listViewOrder = (ListView) findViewById(R.id.orderList);

        orders = new ArrayList<>();
    }


    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseOrder.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                orders.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    orders artist = postSnapshot.getValue(orders.class);
                    //adding artist to the list
                    orders.add(artist);
                }

                //creating adapter
                orderAdapter orderAdapter = new orderAdapter(orderList.this, orders);
                //attaching adapter to the listview
                listViewOrder.setAdapter(orderAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        listViewOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //getting the selected artist
                orders order = orders.get(i);

                //creating an intent
                Intent intent = new Intent(orderList.this, orderPage.class);

                //putting artist name and id to intent
                intent.putExtra("NAME_KEY", order.getCompanyName());
                intent.putExtra("ORDER_DATE_KEY", order.getPerformDate());

                //starting the activity with intent
                startActivity(intent);
            }
        });


    }




}


