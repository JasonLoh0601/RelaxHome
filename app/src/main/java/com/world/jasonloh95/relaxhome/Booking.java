package com.world.jasonloh95.relaxhome;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.app.DatePickerDialog;
import  java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.world.jasonloh95.relaxhome.data.Member;
import com.world.jasonloh95.relaxhome.data.orders;

public class Booking extends AppCompatActivity {


    private static final String TAG = "Booking";
    CustomDateTimePicker custom;
    String email;
    private Button btnSubmit;
    private EditText phoneNumber,requirement,Address;
    private TextView company,date,userEmail;
    private String orderID,companyName;

    //add Firebase Database stuff
    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference myRef;

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    int day,month,year,hour,minutes;
    int dayFinal,monthFinal,yearFinal,hourFinal,minutesFinal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        btnSubmit = (Button) findViewById(R.id.button3);
        phoneNumber = (EditText) findViewById(R.id.editText3);
        requirement = (EditText) findViewById(R.id.editText4);
        Address = (EditText) findViewById(R.id.editText2);
        company = (TextView) findViewById(R.id.textView5);
        date = (TextView) findViewById(R.id.textView6);
        userEmail = (TextView) findViewById(R.id.email1);
        Intent i = this.getIntent();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            email = user.getEmail();
        }

        userEmail.setText(email);
        companyName=i.getExtras().getString("COMPANY_NAME");
        company.setText(companyName);

        //declare the database reference object. This is what we use to access the database.
        //NOTE: Unless you are signed in, this will not be useable.
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser order = mAuth.getCurrentUser();
        orderID = order.getUid();

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                year = cal.get(Calendar.YEAR);
                month = cal.get(Calendar.MONTH);
                day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Booking.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String dates = month + "/" + day + "/" + year;
                date.setText(dates);
            }
        };

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    toastMessage("Successfully signed in with: " + user.getEmail());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    toastMessage("Successfully signed out.");
                }
                // ...
            }
        };


        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Log.d(TAG, "onDataChange: Added information to database: \n" +
                        dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Submit pressed.");
                String phoneNumbers = phoneNumber.getText().toString();
                String requirements = requirement.getText().toString();
                String address = Address.getText().toString();
                String dates = date.getText().toString();



                String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());


                Log.d(TAG, "onClick: Attempting to submit to database: \n" +
                        "Company Name: " + companyName + "\n" +
                        "Perform Date: " + dates + "\n" +
                        "phone number: " + phoneNumbers + "\n" +
                        "requirement:  " + requirements + "\n" +
                        "Addess:       " + address+ "\n"    +
                        "Email:        " + email +" \n"
                );

                //handle the exception if the EditText fields are null
                if(!phoneNumbers.equals("") && !requirements.equals("") && !address.equals("")){
                    orders booking = new orders(companyName,currentDateTimeString,dates,phoneNumbers,requirements,address,email);
                    myRef.child("order").push().setValue(booking);
                    toastMessage("Booking Done.");
                    phoneNumber.setText("");
                    requirement.setText("");
                    Address.setText("");
                    Intent i = new Intent(Booking.this,Main2Activity.class);
                    startActivity(i);
                }else{
                    toastMessage("Fill out all the fields");
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


}
