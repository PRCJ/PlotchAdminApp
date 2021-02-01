package com.plotch.sdk.ChatBotService.adapter;

import android.view.View;

import com.plotch.sdk.data.OrdersInChat;


public interface RecyclerViewOrdersInChatClickListener {

    void onClick(View view, int position, OrdersInChat oic);

}
