package com.world.jasonloh95.relaxhome.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.world.jasonloh95.relaxhome.R;
import com.world.jasonloh95.relaxhome.data.companyDetail;
import com.world.jasonloh95.relaxhome.data.listViewDetail;
import com.world.jasonloh95.relaxhome.listView.listViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by JasonLoh95 on 2/10/2017.
 */

public class Plumber extends Fragment {
    private ListView listView;
    private String[] listView2;

    ArrayList<HashMap<String, String>> data;
    SimpleAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.plumber, container, false);

        listView = (ListView) rootView.findViewById(R.id.plumber);

        listViewAdapter adapter =new listViewAdapter(this.getActivity(),getlistView());

        listView.setAdapter(adapter);
        return rootView;
    }

    public static ArrayList<companyDetail> getlistView(){
        ArrayList<companyDetail> cleanings= new ArrayList<>();
        companyDetail cleaning = null;

        cleaning = new companyDetail();
        cleaning.setName("HDB Plumbers in Singapore");
        cleaning.setaddress("Block 153\n" +
                "Batok Street 11, #02-294,\n" +
                "Singapore 650153");
        cleaning.setemail("hdbplumbers@gmail.com");
        cleaning.setphoneNumber("84916116");
        cleaning.setwebsite("-");
        cleaning.setPhoto(R.drawable.plumber1);
        cleanings.add(cleaning);

        cleaning = new companyDetail();
        cleaning.setName("Mr Plumber Singapore ");
        cleaning.setaddress("3 Phillip Street, Singapore 048693 ");
        cleaning.setemail("enquiry@mrplumber.sg ");
        cleaning.setphoneNumber("+65 6653 6258");
        cleaning.setwebsite("http://www.mrplumber.sg/");
        cleaning.setPhoto(R.drawable.plumber2);
        cleanings.add(cleaning);

        cleaning = new companyDetail();
        cleaning.setName("SGPlumbing");
        cleaning.setaddress("-");
        cleaning.setemail("william@sgplumbing.sg");
        cleaning.setphoneNumber("(+65) 9227 9333");
        cleaning.setwebsite("http://www.sgplumbing.sg/");
        cleaning.setPhoto(R.drawable.plumber3);
        cleanings.add(cleaning);
        return cleanings;
    }

    @Override
    public String toString(){
        String title = "Plumber";
        return title;
    }

}