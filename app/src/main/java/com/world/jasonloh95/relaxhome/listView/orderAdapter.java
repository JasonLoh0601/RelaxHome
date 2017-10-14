package com.world.jasonloh95.relaxhome.listView;


import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.world.jasonloh95.relaxhome.CompanyDetail;
import com.world.jasonloh95.relaxhome.R;
import com.world.jasonloh95.relaxhome.data.companyDetail;
import com.world.jasonloh95.relaxhome.data.orders;
import com.world.jasonloh95.relaxhome.orderPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JasonLoh95 on 12/10/2017.
 */

public class orderAdapter extends ArrayAdapter<orders> {

    LayoutInflater inflater;
    ListView listViewOrder;
    DatabaseReference databaseOrder;
    private Activity context;
    List<orders> orders;

    public orderAdapter(Activity context, List<orders> orders) {
        super(context, R.layout.order_list, orders);
        this.context = context;
        this.orders = orders;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView= inflater.inflate(R.layout.order_list,parent,false);
        }

        TextView textViewName = (TextView) convertView.findViewById(R.id.orderNo);
        TextView textViewGenre = (TextView) convertView.findViewById(R.id.orderDate);

        final String companyName = orders.get(position).getCompanyName();
        final String orderDate = orders.get(position).getOrderDate();
        final String PerformDate = orders.get(position).getPerformDate();
        final String phone = orders.get(position).getPhone();
        final String requirement = orders.get(position).getRequirement();
        final String address = orders.get(position).getAddress();
        final String email = orders.get(position).getEmail();

        textViewName.setText(companyName);
        textViewGenre.setText(PerformDate);


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOrderDetail(companyName, orderDate, PerformDate, phone, requirement, address, email);
            }
        });
        return convertView;
    }

    private void openOrderDetail(String companyName, String orderDate, String PerformDate, String phone, String requirement, String address, String email){
        Intent i = new Intent(context, orderPage.class);

        i.putExtra("NAME_KEY",companyName);
        i.putExtra("ORDERDATE_KEY",orderDate);
        i.putExtra("PERFORMDATE_KEY",PerformDate);
        i.putExtra("PHONE_KEY",phone);
        i.putExtra("REQUIREMENT_KEY",requirement);
        i.putExtra("ADDRESS_KEY",address);
        i.putExtra("EMAILS_KEY",email);

        context.startActivity(i);
    }



}
