package com.world.jasonloh95.relaxhome.Fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.world.jasonloh95.relaxhome.R;
import com.world.jasonloh95.relaxhome.data.companyDetail;
import com.world.jasonloh95.relaxhome.data.listViewDetail;
import com.world.jasonloh95.relaxhome.listView.listViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeCleaning extends Fragment{

    private ListView listView;
    private String[] listView2;

    ArrayList<HashMap<String, String>> data;
    SimpleAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.homecleaning, container, false);

       listView = (ListView) rootView.findViewById(R.id.homeCleaning);

        listViewAdapter adapter =new listViewAdapter(this.getActivity(),getlistView());

        listView.setAdapter(adapter);
        return rootView;

    }

    public static ArrayList<companyDetail> getlistView(){

        ArrayList<companyDetail> cleanings= new ArrayList<>();
        companyDetail cleaning = null;

        cleaning = new companyDetail();
        cleaning.setName("HOME CLEANZ CLEANING & LAUNDRY SERVICES");
        cleaning.setaddress("Home Cleanz Cleaning & Laundry Services\n" +
                "332 Changi Road, Singapore 419807");
        cleaning.setemail("salesenquiry@homecleanz.com");
        cleaning.setphoneNumber("(65) 6440 3342");
        cleaning.setwebsite("www.homecleanz.com");
        cleaning.setPhoto(R.drawable.cleaning1);
        cleanings.add(cleaning);

        cleaning = new companyDetail();
        cleaning.setName("HOUSE CLEANER SINGAPORESINGAPORE");
        cleaning.setaddress("538 Bedok North Street 3 Singapore, Singapore 460538");
        cleaning.setemail("-");
        cleaning.setphoneNumber("(65) 6844 3382");
        cleaning.setwebsite("www.housecleanersingapore.com ");
        cleaning.setPhoto(R.drawable.cleaning2);
        cleanings.add(cleaning);

        cleaning = new companyDetail();
        cleaning.setName("NTUC DOMESTIC CLEANING SERVICE");
        cleaning.setaddress("75 Bras Basah Road, NTUC Income Centre, Singapore 189557");
        cleaning.setemail("referralsvc@income.com.sg");
        cleaning.setphoneNumber("(65) 6788 8788");
        cleaning.setwebsite("www.income.com.sg/domestic");
        cleaning.setPhoto(R.drawable.cleaning3);
        cleanings.add(cleaning);
        return cleanings;
    }

    @Override
    public String toString(){
        String title = "Home Cleaning";
        return title;
    }


}


