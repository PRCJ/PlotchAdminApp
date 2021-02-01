package com.plotch.sdk.ChatBotService.adapter;

import android.view.View;

import com.plotch.sdk.data.SimilarProductData;

public interface RecyclerViewProductClickListener {

    void onClick(View view, int position, SimilarProductData spd, String type);

}
