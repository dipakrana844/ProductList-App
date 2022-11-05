package com.example.practical_list.Model;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL = "https://mobileinterview.azurewebsites.net";
    @GET("/api/products?")
    Call<ProductListModel> getData(@Query("PageIndex") int page, @Query("PageSize") int limit);
}
