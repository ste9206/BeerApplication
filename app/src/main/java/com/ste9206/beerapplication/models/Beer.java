package com.ste9206.beerapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by stefano on 29/05/17.
 */

public class Beer {

    @SerializedName("currentPage")
    @Expose
    public long currentPage;
    @SerializedName("numberOfPages")
    @Expose
    public long numberOfPages;
    @SerializedName("totalResults")
    @Expose
    public long totalResults;
    @SerializedName("data")
    @Expose
    public List<Data> data = null;
    @SerializedName("status")
    @Expose
    public String status;

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(long numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(long totalResults) {
        this.totalResults = totalResults;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
