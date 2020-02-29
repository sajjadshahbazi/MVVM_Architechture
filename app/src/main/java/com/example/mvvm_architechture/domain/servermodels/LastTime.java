package com.example.mvvm_architechture.domain.servermodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LastTime {
    public LastTime(String responseValue) {
        this.responseValue = responseValue;
    }

    @SerializedName("last_get_time")
    @Expose
    private String responseValue="20200101000000";
}
