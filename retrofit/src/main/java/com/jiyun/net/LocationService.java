package com.jiyun.net;


import com.jiyun.model.PhoneLocation;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by 赵玮 on 2017/4/11.
 */

public interface LocationService {

    //http://apis.juhe.cn/
    // mobile/get?phone=13812345678&key=daf8fa858c330b22e342c882bcbac622

    @GET("/mobile/get?phone=13812345678&key=daf8fa858c330b22e342c882bcbac622")
    Call<PhoneLocation> getLocation();

    //http://apis.juhe.cn/mobile/get?phone=1234567890&key=23423423424242
    @GET("/mobile/get")
    Call<PhoneLocation> getLocation(@Query("phone") String number, @Query("key") String key);

    @GET("/mobile/get")
    Call<PhoneLocation> getLocation(@QueryMap Map<String, String> map);

    @FormUrlEncoded
    @POST("/mobile/get")
    Call<PhoneLocation> getLocationPost(@Field("phone") String phone, @Field("key") String key);

    @FormUrlEncoded
    @POST("/mobile/get")
    Call<PhoneLocation> getLocationPost(@FieldMap Map<String, String> map);

    @GET("/{api}/get")
    Call<PhoneLocation> getLocationPath(@Path("api") String api, @QueryMap Map<String, String> map);

    @GET
    Call<PhoneLocation> getLocationUrl(@Url String url);


}
