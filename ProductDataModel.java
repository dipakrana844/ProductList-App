package com.example.practical_list.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class  ProductDataModel implements Serializable {

    @SerializedName("ProductId")
    @Expose
    private Integer productId;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("Price")
    @Expose
    private String price;
    @SerializedName("Dealer")
    @Expose
    private String dealer;
    @SerializedName("Images")
    @Expose
    private ArrayList<ProductImageModel> images = null;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public ArrayList<ProductImageModel> getImages() {
        return images;
    }

    public void setImages(ArrayList<ProductImageModel> images) {
        this.images = images;
    }
}
