package com.ste9206.beerapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by stefano on 29/05/17.
 */

public class Label
{
    @SerializedName("icon")
    @Expose
    public String icon;
    @SerializedName("medium")
    @Expose
    public String medium;
    @SerializedName("large")
    @Expose
    public String large;
}
