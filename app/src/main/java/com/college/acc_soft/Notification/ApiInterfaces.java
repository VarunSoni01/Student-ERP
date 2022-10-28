package com.college.acc_soft.Notification;

import static com.college.acc_soft.Notification.Constants.Content_Type;
import static com.college.acc_soft.Notification.Constants.Server_Key;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterfaces {
    @Headers({"Authorization: key="+Server_Key,"Content-Type:"+Content_Type})
    @POST("/fcm/send")
    Call<PushNotification> sendNotification(@Body PushNotification notification);
}
