package com.plotch.sdk.ChatBotService.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.plotch.sdk.R;
import com.plotch.sdk.data.TransactionList;
import com.plotch.sdk.utils.GeneralUtils;

import java.util.ArrayList;

public class WalletTransactionAdapter extends RecyclerView.Adapter<WalletTransactionAdapter.MyViewHolder> {

    private ArrayList<TransactionList> dataSet;
    private OnItemClickListener mListener;
    private String from;

    public WalletTransactionAdapter(ArrayList<TransactionList> data, String from, OnItemClickListener mListener) {
        this.dataSet = data;
        this.mListener = mListener;
        this.from = from;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_wallet_earning_item_sdk, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

//        try {
        holder.remark.setText(dataSet.get(listPosition).getRemark() != null ? dataSet.get(listPosition).getRemark() : "--");

        String order_id = "Order Id #" + dataSet.get(listPosition).getOrderId();
        holder.orderId.setText(order_id != null ? order_id : "--");
        if (dataSet.get(listPosition).getAmountType() != null) {
            if (dataSet.get(listPosition).getAmountType().equalsIgnoreCase("coin")) {
                holder.coinTypeText.setText("Coin");
                holder.cointypeImage.setImageDrawable(ContextCompat.getDrawable(holder.cointypeImage.getContext(), R.drawable.ic_craftsvilla_coins));
                holder.coinBackground.setBackgroundColor(ContextCompat.getColor(holder.cointypeImage.getContext(), R.color.craftsvilla_coin_backgroud));
                holder.coinTypeText.setTextColor(ContextCompat.getColor(holder.cointypeImage.getContext(), R.color.coin_color));

                if (!TextUtils.isEmpty(dataSet.get(listPosition).getExpiryData())) {
                    holder.expiryDate.setText("Expires on : " + dataSet.get(listPosition).getExpiryData());
                } else {
                    holder.expiryDate.setText(" -- ");

                }

            } else if (dataSet.get(listPosition).getAmountType().equalsIgnoreCase("money")) {
                holder.coinTypeText.setText("Money");
                holder.cointypeImage.setImageDrawable(ContextCompat.getDrawable(holder.cointypeImage.getContext(), R.drawable.ic_craftsvilla_rupee));
                holder.coinBackground.setBackgroundColor(ContextCompat.getColor(holder.cointypeImage.getContext(), R.color.craftsvilla_money_bac));
                holder.coinTypeText.setTextColor(ContextCompat.getColor(holder.cointypeImage.getContext(), R.color.money_color));
                holder.expiryDate.setText("Has no expiry ");

            }

            if (dataSet.get(listPosition).getAmount() > 0) {
                holder.amount.setTextColor(ContextCompat.getColor(holder.cointypeImage.getContext(), R.color.green));
                holder.amount.setText(GeneralUtils.getAmountString(String.valueOf(dataSet.get(listPosition).getAmount())));

                if (!TextUtils.isEmpty(dataSet.get(listPosition).getCreatedAt())) {
                    holder.createdAt.setText("Credited on : " + dataSet.get(listPosition).getCreatedAt());
                } else {
                    holder.createdAt.setText(" -- ");
                }


            } else {
                holder.amount.setTextColor(ContextCompat.getColor(holder.cointypeImage.getContext(), R.color.color_ff4242));
                holder.amount.setText(GeneralUtils.getAmountString(String.valueOf(dataSet.get(listPosition).getAmount())));

                if (!TextUtils.isEmpty(dataSet.get(listPosition).getCreatedAt())) {
                    holder.createdAt.setText("Deducted on : " + dataSet.get(listPosition).getCreatedAt());
                } else {
                    holder.createdAt.setText(" -- ");
                }
                holder.expiryDate.setText(" -- ");


            }
        }

        if (from.equalsIgnoreCase("wallet_fragment")) {
            holder.createdAt.setVisibility(View.VISIBLE);
            holder.expiryDate.setVisibility(View.VISIBLE);
        } else {
            holder.createdAt.setVisibility(View.GONE);
            holder.expiryDate.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int collections);
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout coinBackground;
        TextView remark, coinTypeText, createdAt, orderId, amount, expiryDate;
        ImageView cointypeImage;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.coinBackground = itemView.findViewById(R.id.coinBackground);
            this.remark = itemView.findViewById(R.id.remark);
            this.coinTypeText = itemView.findViewById(R.id.coinTypeText);
            this.createdAt = itemView.findViewById(R.id.createdAt);
            this.orderId = itemView.findViewById(R.id.orderId);
            this.amount = itemView.findViewById(R.id.amount);
            this.expiryDate = itemView.findViewById(R.id.expiryDate);
            this.cointypeImage = itemView.findViewById(R.id.cointypeImage);
        }
    }


}
