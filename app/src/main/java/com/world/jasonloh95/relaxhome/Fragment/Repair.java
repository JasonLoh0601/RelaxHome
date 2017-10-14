package com.world.jasonloh95.relaxhome.Fragment;

/**
 * Created by JasonLoh95 on 2/10/2017.
 */


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

public class Repair extends Fragment{

    private ListView listView;
    private String[] listView2;

    ArrayList<HashMap<String, String>> data;
    SimpleAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.repair, container, false);

        listView = (ListView) rootView.findViewById(R.id.Electrician);

        listViewAdapter adapter =new listViewAdapter(this.getActivity(),getRepair());

        listView.setAdapter(adapter);
        return rootView;

    }

    public static ArrayList<companyDetail> getRepair(){
        ArrayList<companyDetail> cleanings= new ArrayList<>();
        companyDetail cleaning = null;

        cleaning = new companyDetail();
        cleaning.setName("24 Hour Electrician Singapore");
        cleaning.setaddress("-");
        cleaning.setemail("-");
        cleaning.setphoneNumber("9133 3845");
        cleaning.setwebsite("http://24hourelectriciansingapore.com/");
        cleaning.setPhoto(R.drawable.electrician1);
        cleanings.add(cleaning);

        cleaning = new companyDetail();
        cleaning.setName("DAYLIGHT ELECTRICIAN SINGAPORE");
        cleaning.setaddress("34 Boon Leat Terrace #04-12F Singapore 119866 ");
        cleaning.setemail("enquiry@daylightelectrician.com ");
        cleaning.setphoneNumber("+65 6653 6261");
        cleaning.setwebsite("Http://Www.Daylightelectrician.Com");
        cleaning.setPhoto(R.drawable.electrician2);
        cleanings.add(cleaning);

        return cleanings;
    }

    @Override
    public String toString(){
        String title = "Electrician";
        return title;
    }


}


