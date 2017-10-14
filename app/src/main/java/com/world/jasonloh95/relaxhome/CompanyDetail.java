package com.world.jasonloh95.relaxhome;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import android.view.View.OnClickListener;

import com.world.jasonloh95.relaxhome.data.companyDetail;

import java.util.ArrayList;

public class CompanyDetail extends AppCompatActivity implements OnClickListener {

    Context c;
    TextView Address;
    TextView Email;
    TextView PhoneNumber;
    TextView Website;
    TextView companyName;
    ImageView img;
    static String name;

    ArrayList<companyDetail> companyDetails;
    static ArrayList companyDetail1 = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button chat = (Button) findViewById(R.id.button);
        chat.setOnClickListener(this);





        companyName = (TextView) findViewById(R.id.CompanyName);
        Website = (TextView) findViewById(R.id.Website);
        PhoneNumber = (TextView) findViewById(R.id.PhoneNumber);
        Email = (TextView) findViewById(R.id.Email);
        Address = (TextView) findViewById(R.id.Address);
        img =(ImageView) findViewById(R.id.imageView2);

        Intent i = this.getIntent();
        name = i.getExtras().getString("NAME_KEY");
        String website = i.getExtras().getString("WEBSITE_KEY");
        String phoneNumber = i.getExtras().getString("PHONENUMBERS_KEY");
        String email = i.getExtras().getString("EMAILS_KEY");
        String address = i.getExtras().getString("ADDRESS_KEY");
        int image=i.getExtras().getInt("IMAGE_KEY");


        companyName.setText(name);
        Website.setText(website);
        PhoneNumber.setText(phoneNumber);
        Email.setText(email);
        Address.setText(address);
        img.setImageResource(image);

        Button booking = (Button) findViewById(R.id.button2);
        booking.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i= new Intent(CompanyDetail.this,Booking.class);
                i.putExtra("COMPANY_NAME",name);
                startActivity(i);

            }
        });

    }

    public static String getCompanyname(){
        return name;
    }

    @Override
    public void onClick(View v) {
        Intent i =new Intent(this, chatFunction.class);
        startActivity(i);
    }


}
