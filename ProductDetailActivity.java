package com.example.practical_list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import android.view.MenuItem;
import android.widget.TextView;

import com.example.practical_list.Model.ProductDataModel;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;


public class ProductDetailActivity extends AppCompatActivity {
    ViewPager moVPProductDetail;
    DotsIndicator moDTProductDetail;
    ProductDetailAdapter moADProductDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail_activity);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        moVPProductDetail = findViewById(R.id.vpProduct);
        moDTProductDetail = findViewById(R.id.dtProduct);

        TextView loTVProductDetailProductName = findViewById(R.id.tvProductName);
        TextView loTVProductDetailProductPrice = findViewById(R.id.tvProductPrice);
        TextView loTVProductDetailProductDealer = findViewById(R.id.tvProductDealer);
        TextView loTVProductDetailProductDesc = findViewById(R.id.tvProductDesc);

        ProductDataModel listProduct = (ProductDataModel) getIntent().getSerializableExtra("list_1");

        loTVProductDetailProductName.setText(listProduct.getTitle());
        loTVProductDetailProductPrice.setText(listProduct.getPrice());
        loTVProductDetailProductDealer.setText(listProduct.getDealer());
        loTVProductDetailProductDesc.setText(listProduct.getDescription());


        moADProductDetail = new ProductDetailAdapter(this, listProduct.getImages());
        moVPProductDetail.setAdapter(moADProductDetail);
        moDTProductDetail.setViewPager(moVPProductDetail);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
