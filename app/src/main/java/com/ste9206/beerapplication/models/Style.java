package com.ste9206.beerapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by stefano on 29/05/17.
 */

public class Style {

        @SerializedName("id")
        @Expose
        public long id;
        @SerializedName("categoryId")
        @Expose
        public long categoryId;
        @SerializedName("category")
        @Expose
        public Category category;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("shortName")
        @Expose
        public String shortName;
        @SerializedName("description")
        @Expose
        public String description;
        @SerializedName("ibuMin")
        @Expose
        public String ibuMin;
        @SerializedName("ibuMax")
        @Expose
        public String ibuMax;
        @SerializedName("abvMin")
        @Expose
        public String abvMin;
        @SerializedName("abvMax")
        @Expose
        public String abvMax;
        @SerializedName("srmMin")
        @Expose
        public String srmMin;
        @SerializedName("srmMax")
        @Expose
        public String srmMax;
        @SerializedName("ogMin")
        @Expose
        public String ogMin;
        @SerializedName("fgMin")
        @Expose
        public String fgMin;
        @SerializedName("fgMax")
        @Expose
        public String fgMax;
        @SerializedName("createDate")
        @Expose
        public String createDate;
        @SerializedName("updateDate")
        @Expose
        public String updateDate;

    }
