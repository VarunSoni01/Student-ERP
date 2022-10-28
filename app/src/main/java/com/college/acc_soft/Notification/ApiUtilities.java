package com.college.acc_soft.Notification;

import static com.college.acc_soft.Notification.Constants.Base_Url;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {
    private static Retrofit retrofit = null;

    public static ApiInterfaces getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(Base_Url).addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(ApiInterfaces.class);
    }


}
