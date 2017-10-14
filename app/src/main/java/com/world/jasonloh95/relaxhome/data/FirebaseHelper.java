package com.world.jasonloh95.relaxhome.data;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by JasonLoh95 on 14/10/2017.
 */

public class FirebaseHelper {
    DatabaseReference db;
    Boolean saved;
            ArrayList<orders> orders=new ArrayList<>();
    /*
 PASS DATABASE REFRENCE
  */
public FirebaseHelper(DatabaseReference db) {
        this.db = db;
        }
//WRITE IF NOT NULL
public Boolean save(orders order)
        {
        if(order==null)
        {
        saved=false;
        }else
        {
        try
        {
        db.child("orders").push().setValue(order);
        saved=true;
        }catch (DatabaseException e)
        {
        e.printStackTrace();
        saved=false;
        }
        }
        return saved;
        }
//IMPLEMENT FETCH DATA AND FILL ARRAYLIST
private void fetchData(DataSnapshot dataSnapshot)
        {
            orders.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            orders spacecraft=ds.getValue(orders.class);
            orders.add(spacecraft);
        }
        }
//RETRIEVE
public ArrayList<orders> retrieve()
        {
        db.addChildEventListener(new ChildEventListener() {
@Override
public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        fetchData(dataSnapshot);
        }
@Override
public void onChildChanged(DataSnapshot dataSnapshot, String s) {
        fetchData(dataSnapshot);
        }
@Override
public void onChildRemoved(DataSnapshot dataSnapshot) {
        }
@Override
public void onChildMoved(DataSnapshot dataSnapshot, String s) {
        }
@Override
public void onCancelled(DatabaseError databaseError) {
        }
        });
        return orders;
        }
        }