package com.world.jasonloh95.relaxhome;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.world.jasonloh95.relaxhome.Fragment.orderList;
import com.world.jasonloh95.relaxhome.data.Member;
import com.world.jasonloh95.relaxhome.data.orders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class orderPage extends AppCompatActivity {

    Context c;
    TextView companyName;
    TextView orderDate;
    TextView performDate;
    TextView phone;
    TextView requirement;
    TextView address;
    TextView email;

    static String name;

    List<orders> orderss;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        companyName = (TextView) findViewById(R.id.CompanyName1);
        orderDate = (TextView) findViewById(R.id.orderDate1);
        performDate = (TextView) findViewById(R.id.performDate1);
        phone = (TextView) findViewById(R.id.phone1);
        requirement = (TextView) findViewById(R.id.requirement1);
        address = (TextView) findViewById(R.id.address1);
        email = (TextView) findViewById(R.id.email1);

        Intent i = this.getIntent();
        final String companyNames = i.getExtras().getString("NAME_KEY");
        final String orderDates = i.getExtras().getString("ORDERDATE_KEY");
        String performDates = i.getExtras().getString("PERFORMDATE_KEY");
        String phones = i.getExtras().getString("PHONE_KEY");
        String requirements = i.getExtras().getString("REQUIREMENT_KEY");
        String addresss = i.getExtras().getString("ADDRESS_KEY");
        String emails = i.getExtras().getString("EMAILS_KEY");


        companyName.setText(companyNames);
        orderDate.setText(orderDates);
        performDate.setText(performDates);
        phone.setText(phones);
        requirement.setText(requirements);
        address.setText(addresss);
        email.setText(emails);


        Button delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                Query OrderQuery = ref.child("order").orderByChild("orderDate").equalTo(orderDates);

                OrderQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    public static final String TAG = "order Page";

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot OrderSnapshot : dataSnapshot.getChildren()) {
                            OrderSnapshot.getRef().removeValue();
                        }
                        startActivity(new Intent(orderPage.this, orderList.class));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e(TAG, "onCancelled", databaseError.toException());
                    }



                });
            }

            ;
        });


    }
}



