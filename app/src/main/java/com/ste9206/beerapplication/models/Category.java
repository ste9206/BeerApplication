package com.ste9206.beerapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by stefano on 29/05/17.
 */

    public class Category {

        @SerializedName("id")
        @Expose
        public long id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("createDate")
        @Expose
        public String createDate;

    }

