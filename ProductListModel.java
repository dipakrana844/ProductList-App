package com.example.practical_list.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductListModel implements Serializable {
    @SerializedName("flgIsSuccess")
    @Expose
    private Boolean flgIsSuccess;
    @SerializedName("stMessage")
    @Expose
    private String stMessage;
    @SerializedName("Products")
    @Expose
    private List<ProductDataModel> products = null;

    public Boolean getFlgIsSuccess() {
        return flgIsSuccess;
    }

    public void setFlgIsSuccess(Boolean flgIsSuccess) {
        this.flgIsSuccess = flgIsSuccess;
    }

    public String getStMessage() {
        return stMessage;
    }

    public void setStMessage(String stMessage) {
        this.stMessage = stMessage;
    }

    public ArrayList<ProductDataModel> getProducts() {
        return (ArrayList<ProductDataModel>) products;
    }

    public void setProducts(ArrayList<ProductDataModel> products) {
        this.products = products;
    }
}
