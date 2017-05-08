package com.jiyun.model;

/**
 * Created by 赵玮 on 2017/4/11.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhoneLocation {

    @SerializedName("error_code")
    @Expose
    private Integer errorCode;
    @SerializedName("reason")
    @Expose
    private String reason;
    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("resultcode")
    @Expose
    private String resultcode;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    @Override
    public String toString() {
        return "PhoneLocation{" +
                "errorCode=" + errorCode +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                ", resultcode='" + resultcode + '\'' +
                '}';
    }
}



