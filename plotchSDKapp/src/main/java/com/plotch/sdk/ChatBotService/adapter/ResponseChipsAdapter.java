package com.plotch.sdk.ChatBotService.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.plotch.sdk.Constants.PreferenceManager;
import com.plotch.sdk.R;
import com.plotch.sdk.data.OptionList;

import java.util.ArrayList;

public class ResponseChipsAdapter extends RecyclerView.Adapter<ResponseChipsAdapter.RowViewHolder> {

    String language = "english";
    private RecyclerViewChipClickListener mListener;
    private ArrayList<OptionList> mDataset = new ArrayList<>();
    private String targ = "";


    public ResponseChipsAdapter(RecyclerViewChipClickListener listener) {
        mListener = listener;
    }

    public void updateData(ArrayList<OptionList> dataset, String language) {
        mDataset.clear();
        mDataset.addAll(dataset);
        this.language = language;
        notifyDataSetChanged();
    }

    @Override
    public RowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.conv_layout, parent, false);
        return new RowViewHolder(v, mListener);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(RowViewHolder holder, final int position) {
        if (language.equalsIgnoreCase("hindi")) {
            holder.chips.setText(mDataset.get(position).getStatement_hindi());
        } else {
            holder.chips.setText(mDataset.get(position).getStatement_english());
        }


        if (!TextUtils.isEmpty(mDataset.get(position).getTarget())) {
            holder.avatar_c.setVisibility(View.VISIBLE);
            if (mDataset.get(position).getTarget().equalsIgnoreCase("back")) {
                holder.avatar_c.setImageDrawable(ContextCompat.getDrawable(holder.avatar_c.getContext(), R.drawable.chat_back_15dp));
                holder.avatar_c.setColorFilter(Color.parseColor(PreferenceManager.getInstance(holder.avatar_c.getContext()).getDefaultButtonColor()));
            } else if (mDataset.get(position).getTarget().equalsIgnoreCase("exit")) {
                holder.avatar_c.setImageDrawable(ContextCompat.getDrawable(holder.avatar_c.getContext(), R.drawable.chat_exit));
                holder.avatar_c.setColorFilter(Color.parseColor(PreferenceManager.getInstance(holder.avatar_c.getContext()).getDefaultButtonColor()));
            } else if (mDataset.get(position).getTarget().equalsIgnoreCase("saree")) {
                holder.avatar_c.setImageDrawable(ContextCompat.getDrawable(holder.avatar_c.getContext(), R.drawable.ic_indian));
                holder.avatar_c.setColorFilter(Color.parseColor(PreferenceManager.getInstance(holder.avatar_c.getContext()).getDefaultButtonColor()));
            } else if (mDataset.get(position).getTarget().equalsIgnoreCase("jewelry")) {
                holder.avatar_c.setImageDrawable(ContextCompat.getDrawable(holder.avatar_c.getContext(), R.drawable.ic_necklace));
                holder.avatar_c.setColorFilter(Color.parseColor(PreferenceManager.getInstance(holder.avatar_c.getContext()).getDefaultButtonColor()));
            } else if (mDataset.get(position).getTarget().equalsIgnoreCase("lehenga")) {
                holder.avatar_c.setImageDrawable(ContextCompat.getDrawable(holder.avatar_c.getContext(), R.drawable.ic_gown));
                holder.avatar_c.setColorFilter(Color.parseColor(PreferenceManager.getInstance(holder.avatar_c.getContext()).getDefaultButtonColor()));
            } else if (mDataset.get(position).getTarget().equalsIgnoreCase("kurti")) {
                holder.avatar_c.setImageDrawable(ContextCompat.getDrawable(holder.avatar_c.getContext(), R.drawable.ic_kurta));
                holder.avatar_c.setColorFilter(Color.parseColor(PreferenceManager.getInstance(holder.avatar_c.getContext()).getDefaultButtonColor()));
            } else if (mDataset.get(position).getTarget().equalsIgnoreCase("salwar")) {
                holder.avatar_c.setImageDrawable(ContextCompat.getDrawable(holder.avatar_c.getContext(), R.drawable.ic_salwar));
                holder.avatar_c.setColorFilter(Color.parseColor(PreferenceManager.getInstance(holder.avatar_c.getContext()).getDefaultButtonColor()));
            } else {
                holder.avatar_c.setImageDrawable(ContextCompat.getDrawable(holder.avatar_c.getContext(), R.drawable.ic_chat_option));
                holder.avatar_c.setColorFilter(Color.parseColor(PreferenceManager.getInstance(holder.avatar_c.getContext()).getDefaultButtonColor()));
            }
        } else {
            holder.avatar_c.setVisibility(View.VISIBLE);
            holder.avatar_c.setImageDrawable(ContextCompat.getDrawable(holder.avatar_c.getContext(), R.drawable.ic_chat_option));
            holder.avatar_c.setColorFilter(Color.parseColor(PreferenceManager.getInstance(holder.avatar_c.getContext()).getDefaultButtonColor()));
        }

        holder.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(v, position, mDataset.get(position).getTarget(), mDataset.get(position).getOptionId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class RowViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar_c;
        LinearLayout back;
        private TextView chips;

        RowViewHolder(View itemView, RecyclerViewChipClickListener listner) {
            super(itemView);
            chips = itemView.findViewById(R.id.chips);
            avatar_c = itemView.findViewById(R.id.ava);
            back = itemView.findViewById(R.id.back);

        }
    }
}