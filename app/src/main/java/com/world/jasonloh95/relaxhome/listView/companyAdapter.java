package com.world.jasonloh95.relaxhome.listView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.world.jasonloh95.relaxhome.CompanyDetail;
import com.world.jasonloh95.relaxhome.R;
import com.world.jasonloh95.relaxhome.data.companyDetail;

import java.util.ArrayList;

/**
 * Created by JasonLoh95 on 11/10/2017.
 */

public class companyAdapter extends BaseAdapter{

    Context c;
    ArrayList<companyDetail> companyDetails;
    LayoutInflater inflater;

    public companyAdapter(Context c, ArrayList<companyDetail> companyDetails){
        this.c = c;
        this.companyDetails = companyDetails;

        inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return companyDetails.size();
    }

    @Override
    public Object getItem(int position) {
        return companyDetails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.activity_company_detail,parent,false);
        }

        TextView nameTxt = (TextView) convertView.findViewById(R.id.CompanyName);
        TextView website = (TextView) convertView.findViewById(R.id.Website);
        TextView phoneNumber = (TextView) convertView.findViewById(R.id.PhoneNumber);
        TextView Email = (TextView) convertView.findViewById(R.id.Email);
        TextView Address = (TextView) convertView.findViewById(R.id.Address);
        final ImageView image = (ImageView) convertView.findViewById(R.id.imageView2);

        final String name= companyDetails.get(position).getName();
        final String websites= companyDetails.get(position).getwebsite();
        final String phoneNumbers= companyDetails.get(position).getphoneNumber();
        final String Emails= companyDetails.get(position).getemail();
        final String address= companyDetails.get(position).getaddress();
        final int images= companyDetails.get(position).getPhoto();

        nameTxt.setText(name);
        website.setText(websites);
        phoneNumber.setText(phoneNumbers);
        Email.setText(Emails);
        Address.setText(address);
        image.setImageResource(images);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDetailActivity(name,images,position);
            }
        });

        return convertView;
    }

    private void openDetailActivity(String name,int image,int position){

        Intent i = new Intent(c, CompanyDetail.class);

        i.putExtra("NAME_KEY",name);
        i.putExtra("IMAGE_KEY",image);
        i.putExtra("POSITION",position);

        c.startActivity(i);
    }
}
