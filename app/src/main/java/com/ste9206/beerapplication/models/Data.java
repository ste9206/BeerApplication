package com.ste9206.beerapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by stefano on 29/05/17.
 */

public class Data {

        @SerializedName("id")
        @Expose
        public String id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("nameDisplay")
        @Expose
        public String nameDisplay;
        @SerializedName("description")
        @Expose
        public String description;
        @SerializedName("abv")
        @Expose
        public String abv;
        @SerializedName("ibu")
        @Expose
        public String ibu;
        @SerializedName("availableId")
        @Expose
        public long availableId;
        @SerializedName("styleId")
        @Expose
        public long styleId;
        @SerializedName("isOrganic")
        @Expose
        public String isOrganic;
        @SerializedName("status")
        @Expose
        public String status;
        @SerializedName("statusDisplay")
        @Expose
        public String statusDisplay;
        @SerializedName("createDate")
        @Expose
        public String createDate;
        @SerializedName("updateDate")
        @Expose
        public String updateDate;
        @SerializedName("available")
        @Expose
        public Available available;
        @SerializedName("style")
        @Expose
        public Style style;
        @SerializedName("glasswareId")
        @Expose
        public long glasswareId;
        @SerializedName("labels")
        @Expose
        public Label labels;
        @SerializedName("glass")
        @Expose
        public Glass glass;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameDisplay() {
        return nameDisplay;
    }

    public void setNameDisplay(String nameDisplay) {
        this.nameDisplay = nameDisplay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbv() {
        return abv;
    }

    public void setAbv(String abv) {
        this.abv = abv;
    }

    public String getIbu() {
        return ibu;
    }

    public void setIbu(String ibu) {
        this.ibu = ibu;
    }

    public long getAvailableId() {
        return availableId;
    }

    public void setAvailableId(long availableId) {
        this.availableId = availableId;
    }

    public long getStyleId() {
        return styleId;
    }

    public void setStyleId(long styleId) {
        this.styleId = styleId;
    }

    public String getIsOrganic() {
        return isOrganic;
    }

    public void setIsOrganic(String isOrganic) {
        this.isOrganic = isOrganic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDisplay() {
        return statusDisplay;
    }

    public void setStatusDisplay(String statusDisplay) {
        this.statusDisplay = statusDisplay;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Available getAvailable() {
        return available;
    }

    public void setAvailable(Available available) {
        this.available = available;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public long getGlasswareId() {
        return glasswareId;
    }

    public void setGlasswareId(long glasswareId) {
        this.glasswareId = glasswareId;
    }

    public Label getLabels() {
        return labels;
    }

    public void setLabels(Label labels) {
        this.labels = labels;
    }

    public Glass getGlass() {
        return glass;
    }

    public void setGlass(Glass glass) {
        this.glass = glass;
    }
}
