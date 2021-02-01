package com.plotch.sdk.ChatBotService.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.plotch.sdk.BuildConfig;
import com.plotch.sdk.R;
import com.plotch.sdk.data.OrdersInChat;
import com.plotch.sdk.network.URLConstants;
import com.plotch.sdk.utils.StringUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

//import com.nostra13.universalimageloader.core.ImageLoader;
//import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

public class ShowOrdersAdapter extends RecyclerView.Adapter<ShowOrdersAdapter.RowViewHolder> {

    private RecyclerViewOrdersInChatClickListener mListener;
    private ArrayList<OrdersInChat> mDataset = new ArrayList<>();
//    private ImageViewAware imageAware;
//    private ImageLoader imageLoader;


    public ShowOrdersAdapter(RecyclerViewOrdersInChatClickListener listener) {
        mListener = listener;
    }

    public void updateData(ArrayList<OrdersInChat> dataset) {
        mDataset.clear();
        mDataset.addAll(dataset);
        notifyDataSetChanged();

    }

    @Override
    public RowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.orders_in_chat_layout_sdk, parent, false);
        return new RowViewHolder(v, mListener);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(RowViewHolder holder, final int position) {
        holder.product_name.setText("Placed: " + mDataset.get(position).getCreatedAt());
        holder.product_amount.setText("Amount Paid:" + StringUtil.formatRsString(String.valueOf(mDataset.get(position).getPrice())));
        holder.product_id.setText("Order id : " + mDataset.get(position).getShipmentId());
        holder.product_status.setText(mDataset.get(position).getStatus());
        if (mDataset.get(position).getStatus().equalsIgnoreCase("cancelled")) {
            holder.product_status.setTextColor(Color.RED);
        } else
            holder.product_status.setTextColor(Color.BLUE);

//        imageAware = new ImageViewAware(holder.product_image, false);
//        imageLoader.displayImage(URLConstants.getImageUrl(holder.product_image.getContext(),mDataset.get(position).getImage(), URLConstants.ImageType.LARGE), imageAware);

        String imgUrl = URLConstants.getImageUrl(holder.product_image.getContext(), mDataset.get(position).getImage(), URLConstants.ImageType.LARGE);
        if (BuildConfig.DEBUG)
            Log.d("imgurl", "onBindViewHolder:img " + imgUrl);

        if (Build.VERSION.SDK_INT >= 21)
            Picasso.get().load(imgUrl).placeholder(R.drawable.ic_placeholder).error(R.drawable.ic_placeholder).into(holder.product_image);
        else Picasso.get().load(imgUrl).into(holder.product_image);

        holder.product_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(v, position, mDataset.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class RowViewHolder extends RecyclerView.ViewHolder {
        ImageView product_image;
        RelativeLayout product_back;
        private TextView product_name, product_status, product_amount, product_id;

        RowViewHolder(View itemView, RecyclerViewOrdersInChatClickListener listner) {
            super(itemView);
            product_name = itemView.findViewById(R.id.product_name);
            product_image = itemView.findViewById(R.id.product_image);
            product_status = itemView.findViewById(R.id.product_status);
            product_amount = itemView.findViewById(R.id.product_amount);
            product_id = itemView.findViewById(R.id.product_id);
            product_back = itemView.findViewById(R.id.product_back);

        }
    }
}