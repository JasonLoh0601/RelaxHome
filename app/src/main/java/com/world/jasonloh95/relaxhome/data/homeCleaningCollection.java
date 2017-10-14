package com.world.jasonloh95.relaxhome.data;

import com.world.jasonloh95.relaxhome.R;

import java.util.ArrayList;

/**
 * Created by JasonLoh95 on 11/10/2017.
 */

public class homeCleaningCollection {

    public static ArrayList<companyDetail> gethomeCleaning(){
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
        cleaning.setPhoto(R.drawable.cleaning1);
        cleanings.add(cleaning);


        return cleanings;
    }


}
