package com.jiyun.model;

/**
 * Created by 赵玮 on 2017/4/11.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("areacode")
    @Expose
    private String areacode;
    @SerializedName("card")
    @Expose
    private String card;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("province")
    @Expose
    private String province;
    @SerializedName("zip")
    @Expose
    private String zip;

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Result{" +
                "areacode='" + areacode + '\'' +
                ", card='" + card + '\'' +
                ", city='" + city + '\'' +
                ", company='" + company + '\'' +
                ", province='" + province + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
