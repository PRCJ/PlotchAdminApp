package com.plotch.sdk.ChatBotService.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.plotch.sdk.BuildConfig;
import com.plotch.sdk.Constants.PreferenceManager;
import com.plotch.sdk.R;
import com.plotch.sdk.data.SimilarProductData;
import com.plotch.sdk.network.URLConstants;
import com.plotch.sdk.utils.StringUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ShowProductsAdapter extends RecyclerView.Adapter<ShowProductsAdapter.RowViewHolder> {

    private RecyclerViewProductClickListener mListener;
    private ArrayList<SimilarProductData> mDataset = new ArrayList<>();


    public ShowProductsAdapter(RecyclerViewProductClickListener listener) {
        mListener = listener;
    }

    public void updateData(ArrayList<SimilarProductData> dataset) {
        mDataset.clear();
        mDataset.addAll(dataset);
        notifyDataSetChanged();

    }

    @Override
    public RowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.products_in_chat_item_sdk, parent, false);
        return new RowViewHolder(v, mListener);
    }

    public static void setStrikeTextViewWithString(TextView view, String text) {
        view.setText(text);
        view.setPaintFlags(view.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public void onBindViewHolder(RowViewHolder holder, final int position) {
        holder.product_name.setText(mDataset.get(position).getName());
        holder.product_status.setText(StringUtil.formatRsString(String.valueOf(mDataset.get(position).getDiscountedPrice())));

        String imgUrl = URLConstants.getImageUrl(holder.product_image.getContext(), mDataset.get(position).getImage(), URLConstants.ImageType.LARGE);
        if (BuildConfig.DEBUG)
            Log.d("imgurl", "onBindViewHolder:img " + imgUrl);
        if (Build.VERSION.SDK_INT >= 21)
            Picasso.get().load(imgUrl).placeholder(R.drawable.ic_placeholder).error(R.drawable.ic_placeholder).into(holder.product_image);
        else Picasso.get().load(imgUrl).into(holder.product_image);

        holder.product_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(v, position, mDataset.get(position), "option");
            }
        });
        holder.buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(v, position, mDataset.get(position), "buy");
            }
        });

        GradientDrawable gd = (GradientDrawable) holder.buy.getBackground().getCurrent();
        gd.setColor(Color.parseColor(PreferenceManager.getInstance(holder.buy.getContext()).getDefaultButtonColor()));
        holder.buy.setBackgroundResource(R.drawable.green_line_back);

        holder.mTextViewOfferPrice.setText(StringUtil.formatRsString(String.valueOf(mDataset.get(position).getPrice())));
        setStrikeTextViewWithString(holder.mTextViewOfferPrice, StringUtil.formatRsString(String.valueOf(mDataset.get(position).getPrice())));
        holder.mtextViewSavePercentage.setText(Math.round(mDataset.get(position).getDiscountPercentage()) + "% OFF");

    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class RowViewHolder extends RecyclerView.ViewHolder {
        ImageView product_image;
        RelativeLayout product_back;
        private TextView product_name, product_status, buy, option, mTextViewOfferPrice, mtextViewSavePercentage;

        RowViewHolder(View itemView, RecyclerViewProductClickListener listner) {
            super(itemView);
            product_name = itemView.findViewById(R.id.product_name);
            product_image = itemView.findViewById(R.id.product_image);
            product_status = itemView.findViewById(R.id.product_status);
            product_back = itemView.findViewById(R.id.product_back);
            buy = itemView.findViewById(R.id.buy);
            option = itemView.findViewById(R.id.option);
            mTextViewOfferPrice = itemView.findViewById(R.id.mTextViewOfferPrice);
            mtextViewSavePercentage = itemView.findViewById(R.id.mtextViewSavePercentage);

        }
    }
}