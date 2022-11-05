package com.example.practical_list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import com.example.practical_list.Model.ProductDataModel;
import com.example.practical_list.Model.ProductListModel;
import com.example.practical_list.Model.RetrofitClient;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class ProductListActivity extends AppCompatActivity implements ProductListInterface {
    RecyclerView moRvProduct;
    RecyclerView.LayoutManager moLmProduct;
    ProductListModel moProductListModel;
    ProgressBar moPbProduct;
    RecyclerView.Adapter moADProduct;
    ArrayList<ProductDataModel> moProductListEmpty = new ArrayList<>();
    int loPage = 1, loLimit = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row_product_loader);

        moRvProduct = findViewById(R.id.rvProduct);
        moPbProduct = findViewById(R.id.pbProduct);

        getData(loPage, loLimit);

        moRvProduct.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    loPage++;
                    moPbProduct.setVisibility(View.GONE);
                    getData(loPage, loLimit);
                }
            }
        });
    }

    private void getData(int fiPage, int fiLimit) {

        int liPage = fiPage;
        int liLimit = fiLimit;

        if (loPage > loLimit) {
            moPbProduct.setVisibility((View.GONE));
            return;
        }

        Call<ProductListModel> call = RetrofitClient.getInstance().getMyApi().getData(loPage, loLimit);
        call.enqueue(new Callback<ProductListModel>() {
            @Override
            public void onResponse(Call<ProductListModel> call, retrofit2.Response<ProductListModel> response) {
                if (response.body() != null && response.isSuccessful()) {
                    moProductListModel = response.body();
                    if (moProductListModel.getProducts() != null && moProductListModel.getProducts().size() > 0) {
                        moProductListEmpty.addAll(moProductListModel.getProducts());
                        if (moProductListModel.getFlgIsSuccess()) {
                            moLmProduct = new LinearLayoutManager(ProductListActivity.this, LinearLayoutManager.VERTICAL, false);
                            moRvProduct.setLayoutManager(moLmProduct);
                            moADProduct = new ProductListAdapter(ProductListActivity.this, moProductListEmpty, ProductListActivity.this);
                            moRvProduct.setAdapter(moADProduct);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ProductListModel> call, Throwable t) {

            }
        });
    }
    @Override
    public void onItemClick(int position) {
        Intent loIntent = new Intent(ProductListActivity.this, ProductDetailActivity.class);
        loIntent.putExtra("list_1", moProductListEmpty.get(position));
        startActivity(loIntent);
    }
}
