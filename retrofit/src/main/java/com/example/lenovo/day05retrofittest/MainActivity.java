package com.example.lenovo.day05retrofittest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jiyun.model.PhoneLocation;
import com.jiyun.net.LocationService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity implements View.OnClickListener {

    private EditText etNumber;
    private Button btRequest;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = (EditText) findViewById(R.id.et_number);
        btRequest = (Button) findViewById(R.id.bt_request);
        tvResult = (TextView) findViewById(R.id.tv_result);
        btRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_request:
                String baseUrl = "http://apis.juhe.cn/";
                //String key = "daf8fa858c330b22e342c882bcbac622";
                String key = "89d021b65a3691f635b7a86a0119a85f";
                String number = etNumber.getText().toString().trim();

                Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();

                LocationService locationService = retrofit.create(LocationService.class);
                Map<String, String> map = new HashMap<>();
                map.put("phone", number);
                map.put("key", key);
                Call<PhoneLocation> location = locationService.getLocation(number, key);
                location.enqueue(new Callback<PhoneLocation>() {
                    @Override
                    public void onResponse(Call<PhoneLocation> call, Response<PhoneLocation> response) {

                        PhoneLocation body = response.body();
                        Log.e("tag", "请求结果：" + body.getResult().getProvince() + "  " + body.getResult().getCity());
                        String province = body.getResult().getProvince();
                        String company = body.getResult().getCompany();
                        String city = body.getResult().getCity();
                        tvResult.setText(province + " " + city + " " + company);
                    }

                    @Override
                    public void onFailure(Call<PhoneLocation> call, Throwable t) {

                    }
                });
                break;
        }
    }
}
