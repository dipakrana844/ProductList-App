package com.example.practical_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.practical_list.Model.ProductImageModel;

import java.util.ArrayList;

public class ProductDetailAdapter extends PagerAdapter {
    private Context moContext;
    private LayoutInflater moLayoutInflater;


    private ArrayList<ProductImageModel> moIMAGES;


    public ProductDetailAdapter(Context foContext, ArrayList<ProductImageModel> foIMAGES) {
        this.moContext = foContext;
        this.moIMAGES = foIMAGES;
    }

    @Override
    public int getCount() {
        return moIMAGES.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        moLayoutInflater = (LayoutInflater) moContext.getSystemService(
                moContext.LAYOUT_INFLATER_SERVICE
        );
        View view = moLayoutInflater.inflate(R.layout.row_productdetail, null);
        ImageView loIvProductImages = view.findViewById(R.id.ivProductDetail);
        Glide.with(moContext).load(moIMAGES.get(position).getImageURL()).into(loIvProductImages);
        ViewPager loVpProduct = (ViewPager) container;
        loVpProduct.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
