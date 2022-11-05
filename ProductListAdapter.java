package com.example.practical_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.practical_list.Model.ProductDataModel;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {
    private final ProductListInterface moRvIProductList;
    Context moContext;
    List<ProductDataModel> moProductList;

    public ProductListAdapter(Context foContext, List<ProductDataModel> foProductList, ProductListInterface foRvIProductList) {
        this.moRvIProductList = foRvIProductList;
        this.moContext = foContext;
        this.moProductList = foProductList;
    }

    @NonNull
    @Override
    public ProductListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater loInflater = LayoutInflater.from(moContext);
        View loView = loInflater.inflate(R.layout.row_product, parent, false);
        ViewHolder loViewHolder = new ViewHolder(loView);
        return loViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.loTVProductName.setText(moProductList.get(position).getTitle());
        holder.loTVProductPrice.setText(moProductList.get(position).getPrice());
        holder.loTVProductDealer.setText(moProductList.get(position).getDealer());
        Glide.with(moContext).load(moProductList.get(position).getImages().get(0).getImageURL()).into(holder.loIVProduct);
    }


    @Override
    public int getItemCount() {
        return moProductList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView loTVProductName, loTVProductPrice, loTVProductDealer;
        ImageView loIVProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            loTVProductName = itemView.findViewById(R.id.tvProductName);
            loTVProductPrice = itemView.findViewById(R.id.tvProductPrice);
            loTVProductDealer = itemView.findViewById(R.id.tvProductDealer);
            loIVProduct = itemView.findViewById(R.id.ivProduct);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (moRvIProductList != null) {
                        int liPos = getAdapterPosition();
                        if (liPos != RecyclerView.NO_POSITION) {
                            moRvIProductList.onItemClick(liPos);
                        }
                    }
                }
            });
        }
    }
}
