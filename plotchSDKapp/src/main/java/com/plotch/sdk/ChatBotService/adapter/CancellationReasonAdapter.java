package com.plotch.sdk.ChatBotService.adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
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
import com.plotch.sdk.data.CancelReason;

import java.util.ArrayList;

public class CancellationReasonAdapter extends RecyclerView.Adapter<CancellationReasonAdapter.RowViewHolder> {

    String language = "english";
    private RecyclerViewChipClickListener mListener;
    private ArrayList<CancelReason> mDataset = new ArrayList<>();
    private String targ = "";


    public CancellationReasonAdapter(RecyclerViewChipClickListener listener) {
        mListener = listener;
    }

    public void updateData(ArrayList<CancelReason> dataset, String language) {
        mDataset.clear();
        mDataset.addAll(dataset);
        this.language = language;
        notifyDataSetChanged();
    }

    @Override
    public RowViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.conv_layout, parent, false);
        return new RowViewHolder(v, mListener);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(RowViewHolder holder, final int position) {

        holder.chips.setText(mDataset.get(position).getDisplayText());
        holder.avatar.setVisibility(View.VISIBLE);
        holder.avatar.setImageDrawable(ContextCompat.getDrawable(holder.avatar.getContext(), R.drawable.ic_chat_option));
        holder.avatar.setColorFilter(Color.parseColor(PreferenceManager.getInstance(holder.avatar.getContext()).getDefaultButtonColor()));

//        Drawable background = holder.avatar.getBackground();
//        int color = ContextCompat.getColor(holder.avatar.getContext(), R.color.color_535353);
//        background.setTint(color);


        holder.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(v, position, mDataset.get(position).getDisplayText(), mDataset.get(position).getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class RowViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        LinearLayout back;
        private TextView chips;

        RowViewHolder(View itemView, RecyclerViewChipClickListener listner) {
            super(itemView);
            chips = itemView.findViewById(R.id.chips);
            avatar = itemView.findViewById(R.id.ava);
            back = itemView.findViewById(R.id.back);

        }
    }
}