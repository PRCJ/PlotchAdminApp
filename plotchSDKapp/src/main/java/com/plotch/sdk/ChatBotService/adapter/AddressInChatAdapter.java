package com.plotch.sdk.ChatBotService.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.plotch.sdk.R;
import com.plotch.sdk.data.AddressListData;

import java.util.ArrayList;

public class AddressInChatAdapter extends RecyclerView.Adapter<AddressInChatAdapter.RowViewHolder> {

    String language = "english";
    private RecyclerViewChipClickListener mListener;
    private ArrayList<AddressListData> mDataset = new ArrayList<>();

    public AddressInChatAdapter(ArrayList<AddressListData> dataset, RecyclerViewChipClickListener listener) {
        mListener = listener;
        mDataset = dataset;
    }


    @Override
    public RowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.address_item_layout_sdk, parent, false);
        return new RowViewHolder(v, mListener);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(RowViewHolder holder, final int position) {
        holder.name.setText(mDataset.get(position).getFirstName() + " " + mDataset.get(position).getLastName());
        holder.address.setText(mDataset.get(position).getStreet() + ", " + mDataset.get(position).getCity() + ", " + mDataset.get(position).getRegion() + ", " + mDataset.get(position).getPostcode());
        holder.mobile.setText(mDataset.get(position).getCountryPhoneCode() + " " + mDataset.get(position).getTelephone());
        holder.address_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(v, position, "", 0);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class RowViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout address_back;
        private TextView name, address, mobile;

        RowViewHolder(View itemView, RecyclerViewChipClickListener listner) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            mobile = itemView.findViewById(R.id.mobile);
            address_back = itemView.findViewById(R.id.address_back);

        }
    }
}