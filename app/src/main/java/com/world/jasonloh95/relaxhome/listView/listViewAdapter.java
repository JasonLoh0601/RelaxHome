package com.world.jasonloh95.relaxhome.listView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.world.jasonloh95.relaxhome.CompanyDetail;
import com.world.jasonloh95.relaxhome.R;
import com.world.jasonloh95.relaxhome.data.companyDetail;
import com.world.jasonloh95.relaxhome.data.listViewDetail;

import java.util.ArrayList;

/**
 * Created by JasonLoh95 on 10/10/2017.
 */

public class listViewAdapter extends BaseAdapter {
    Context c;
    ArrayList<companyDetail> listView;
    LayoutInflater inflater;
    int position;
    public listViewAdapter (Context c, ArrayList<companyDetail> listView){
        this.c = c;
        this.listView = listView;
    }

    @Override
    public int getCount(){
        return listView.size();
    }

    @Override
    public Object getItem (int position){
        return listView.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        if (inflater == null){
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView= inflater.inflate(R.layout.list_item,parent,false);
        }
        TextView company = (TextView) convertView.findViewById(R.id.textViewName);
        ImageView logo = (ImageView) convertView.findViewById(R.id.imageView);

        final String name = listView.get(position).getName();
        final String websites= listView.get(position).getwebsite();
        final String phoneNumbers= listView.get(position).getphoneNumber();
        final String Emails= listView.get(position).getemail();
        final String address= listView.get(position).getaddress();
        final int image = listView.get(position).getPhoto();


        company.setText(name);
        logo.setImageResource(image);


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity(name,websites,phoneNumbers,Emails,address,image);
            }
        });
        return convertView;
    }
    private void openDetailActivity(String name,String website, String phoneNumbers,String Emails,String address,int image){

        Intent i = new Intent(c, CompanyDetail.class);

        i.putExtra("NAME_KEY",name);
        i.putExtra("WEBSITE_KEY",website);
        i.putExtra("PHONENUMBERS_KEY",phoneNumbers);
        i.putExtra("EMAILS_KEY",Emails);
        i.putExtra("ADDRESS_KEY",address);
        i.putExtra("IMAGE_KEY",image);

        c.startActivity(i);
    }
}
