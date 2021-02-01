package com.plotch.sdk.ChatBotService.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.plotch.sdk.Constants.PreferenceManager;
import com.plotch.sdk.R;
import com.plotch.sdk.data.Statements;
import com.plotch.sdk.network.URLConstants;
import com.plotch.sdk.utils.GeneralUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ConversationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int RECIVE = 1;
    private static final int SENT = 0;
    private final Activity ctx;
    String language = "english";
    private ArrayList<Statements> mList;
    private int typ;
    private Animation zoom_in;
    private String chatBotName, chatBotIcon;


    public ConversationAdapter(ArrayList<Statements> list, Activity ctx) {
        this.mList = list;
        this.ctx = ctx;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case SENT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_my_conversation_sdk, parent, false);
                return new PaiViewHolder(view);
            case RECIVE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_their_conversation_sdk, parent, false);
                return new FilhoViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Statements object = mList.get(position);
        zoom_in = AnimationUtils.loadAnimation(ctx, R.anim.normal_zoom);


        if (object.getType().equalsIgnoreCase("remote"))
            typ = 1;
        else
            typ = 0;

        if (object != null) {
            switch (typ) {
                case SENT:
                    ((PaiViewHolder) holder).convos.setVisibility(View.GONE);
                    chatBotName = PreferenceManager.getInstance(((PaiViewHolder) holder).mTitle.getContext()).getChatBotName();
                    chatBotIcon = PreferenceManager.getInstance(((PaiViewHolder) holder).mTitle.getContext()).getChatBotIcon();

                    if (language.equalsIgnoreCase("hindi")) {
                        if (!object.messageHindi.equalsIgnoreCase("showLoadingNow")) {
                            if (position == mList.size() - 1) {
                                ((PaiViewHolder) holder).convos.setVisibility(View.VISIBLE);
                                ((PaiViewHolder) holder).convos.startAnimation(zoom_in);
                            } else {
                                ((PaiViewHolder) holder).convos.setVisibility(View.VISIBLE);
                            }
                        } else {
                            ((PaiViewHolder) holder).convos.setVisibility(View.VISIBLE);
                        }
                        ((PaiViewHolder) holder).mTitle.setText(object.messageHindi);
                    } else {
                        if (!object.messageEnglish.equalsIgnoreCase("showLoadingNow")) {
                            if (position == mList.size() - 1) {
                                ((PaiViewHolder) holder).convos.setVisibility(View.VISIBLE);
                                ((PaiViewHolder) holder).convos.startAnimation(zoom_in);
                            } else {
                                ((PaiViewHolder) holder).convos.setVisibility(View.VISIBLE);
                            }
                        } else {
                            ((PaiViewHolder) holder).convos.setVisibility(View.VISIBLE);
                        }
                        ((PaiViewHolder) holder).mTitle.setText(object.messageEnglish);
                    }


                    ((PaiViewHolder) holder).product_card.setVisibility(View.GONE);
                    if (object.getSpd() != null) {
                        ((PaiViewHolder) holder).product_card.setVisibility(View.VISIBLE);
                        ((PaiViewHolder) holder).mTitle.setVisibility(View.GONE);
                        String imageUrl = URLConstants.getImageUrl(((PaiViewHolder) holder).mTitle.getContext(), object.getImageUrl(), URLConstants.ImageType.LARGE);
                        if (Build.VERSION.SDK_INT >= 21)
                            Picasso.get().load(imageUrl).placeholder(R.drawable.ic_placeholder).error(R.drawable.ic_placeholder).into(((PaiViewHolder) holder).obj_image);
                        else Picasso.get().load(imageUrl).into(((PaiViewHolder) holder).obj_image);

                        if (!TextUtils.isEmpty(object.getSpd().getName())) {
                            ((PaiViewHolder) holder).obj_name.setText(object.getSpd().getName());
                        } else {
                            ((PaiViewHolder) holder).obj_name.setVisibility(View.GONE);
                        }
                        if (!TextUtils.isEmpty(object.getSpd().getPrice())) {
                            if (language.equalsIgnoreCase("hindi"))
                                ((PaiViewHolder) holder).obj_amount.setText("M.R.P : " + GeneralUtils.getAmountStringWithOutSign(String.valueOf(object.getSpd().getDiscountedPrice())));
                            else
                                ((PaiViewHolder) holder).obj_amount.setText("M.R.P : " + GeneralUtils.getAmountStringWithOutSign(String.valueOf(object.getSpd().getDiscountedPrice())));

                        } else {
                            ((PaiViewHolder) holder).obj_amount.setVisibility(View.GONE);
                        }
//                        if (!TextUtils.isEmpty(object.getSpd().getPrice())) {
//                            if (language.equalsIgnoreCase("hindi"))
//                                ((PaiViewHolder) holder).obj_description.setText("उत्पाद आइ.डि : " + object.getSpd().getEntityId());
//                            else
//                                ((PaiViewHolder) holder).obj_description.setText("Product id : " + object.getSpd().getEntityId());
//
//                        } else {
                        ((PaiViewHolder) holder).obj_description.setVisibility(View.GONE);
//                        }
                    }
                    if (object.getOic() != null) {
                        ((PaiViewHolder) holder).product_card.setVisibility(View.VISIBLE);
                        ((PaiViewHolder) holder).mTitle.setVisibility(View.GONE);
                        String imageUrl = URLConstants.getImageUrl(((PaiViewHolder) holder).mTitle.getContext(), object.getImageUrl(), URLConstants.ImageType.LARGE);
                        if (Build.VERSION.SDK_INT >= 21)
                            Picasso.get().load(imageUrl).placeholder(R.drawable.ic_placeholder).error(R.drawable.ic_placeholder).into(((PaiViewHolder) holder).obj_image);
                        else Picasso.get().load(imageUrl).into(((PaiViewHolder) holder).obj_image);

                        if (!TextUtils.isEmpty(object.getOic().getName())) {
                            if (language.equalsIgnoreCase("hindi"))
                                ((PaiViewHolder) holder).obj_name.setText("दिया गया : " + object.getOic().getCreatedAt());
                            else
                                ((PaiViewHolder) holder).obj_name.setText("Placed on : " + object.getOic().getCreatedAt());


                        } else {
                            ((PaiViewHolder) holder).obj_name.setVisibility(View.GONE);
                        }
                        if (!TextUtils.isEmpty(String.valueOf(object.getOic().getPrice()))) {

                            if (language.equalsIgnoreCase("hindi"))
                                ((PaiViewHolder) holder).obj_amount.setText("वैल्यू : " + GeneralUtils.getAmountStringWithOutSign(String.valueOf(object.getOic().getPrice())));
                            else
                                ((PaiViewHolder) holder).obj_amount.setText("Amount paid : " + GeneralUtils.getAmountStringWithOutSign(String.valueOf(object.getOic().getPrice())));


                        } else {
                            ((PaiViewHolder) holder).obj_amount.setVisibility(View.GONE);
                        }
                        if (!TextUtils.isEmpty(String.valueOf(object.getOic().getPrice()))) {

                            if (language.equalsIgnoreCase("hindi"))
                                ((PaiViewHolder) holder).obj_description.setText("शिपमेंट आइ.डि : " + object.getOic().getShipmentId());
                            else
                                ((PaiViewHolder) holder).obj_description.setText("Shipment id : " + object.getOic().getShipmentId());

                        } else {
                            ((PaiViewHolder) holder).obj_description.setVisibility(View.GONE);
                        }
                    }

                    GradientDrawable gd = (GradientDrawable) ((PaiViewHolder) holder).avatarConv.getBackground().getCurrent();
                    gd.setColor(Color.parseColor(PreferenceManager.getInstance(((PaiViewHolder) holder).avatarConv.getContext()).getDefaultButtonColor()));
                    ((PaiViewHolder) holder).avatarConv.setBackgroundResource(R.drawable.circle_reply);

                    break;
                case RECIVE:
                    chatBotName = PreferenceManager.getInstance(((FilhoViewHolder) holder).convor.getContext()).getChatBotName();
                    chatBotIcon = PreferenceManager.getInstance(((FilhoViewHolder) holder).convor.getContext()).getChatBotIcon();
                    ((FilhoViewHolder) holder).convor.setVisibility(View.GONE);

                    if (position == 0) {
                        ((FilhoViewHolder) holder).chatbot_name.setVisibility(View.VISIBLE);
                    } else {
                        ((FilhoViewHolder) holder).chatbot_name.setVisibility(View.GONE);
                    }
                    if (!TextUtils.isEmpty(chatBotName)) {
                        ((FilhoViewHolder) holder).chatbot_name.setText("" + chatBotName + " ");
                    }
//
                    if (!TextUtils.isEmpty(chatBotIcon)) {
                        if (Build.VERSION.SDK_INT >= 21)
                            Picasso.get().load(chatBotIcon).placeholder(R.drawable.ic_placeholder).error(R.drawable.ic_placeholder).into(((FilhoViewHolder) holder).avatarConv);
                        else
                            Picasso.get().load(chatBotIcon).into(((FilhoViewHolder) holder).avatarConv);
                    }

                    if (!TextUtils.isEmpty(object.getImageUrl())) {
                        ((FilhoViewHolder) holder).image.setVisibility(View.VISIBLE);
                        String imageUrl = URLConstants.getImageUrl(((FilhoViewHolder) holder).image.getContext(), object.getImageUrl(), URLConstants.ImageType.LARGE);
                        if (Build.VERSION.SDK_INT >= 21)
                            Picasso.get().load(imageUrl).placeholder(R.drawable.ic_placeholder).error(R.drawable.ic_placeholder).into(((FilhoViewHolder) holder).image);
                        else Picasso.get().load(imageUrl).into(((FilhoViewHolder) holder).image);

                    } else {
                        ((FilhoViewHolder) holder).image.setVisibility(View.GONE);
                    }
                    if (language.equalsIgnoreCase("hindi")) {
                        ((FilhoViewHolder) holder).mTitle.setText(object.messageHindi);

                        if (object.messageHindi.equalsIgnoreCase("showLoadingNow")) {
                            ((FilhoViewHolder) holder).lotianimation.setVisibility(View.VISIBLE);
                            ((FilhoViewHolder) holder).mTitle.setVisibility(View.GONE);
                        } else {
                            ((FilhoViewHolder) holder).lotianimation.setVisibility(View.GONE);
                            ((FilhoViewHolder) holder).mTitle.setVisibility(View.VISIBLE);

                        }
                        if (!object.messageHindi.equalsIgnoreCase("showLoadingNow")) {
                            if (position == mList.size() - 1) {
                                ((FilhoViewHolder) holder).convor.setVisibility(View.VISIBLE);
                                ((FilhoViewHolder) holder).convor.startAnimation(zoom_in);
                            } else {
                                ((FilhoViewHolder) holder).convor.setVisibility(View.VISIBLE);
                            }
                        } else {
                            ((FilhoViewHolder) holder).convor.setVisibility(View.VISIBLE);

                        }
                    } else {
                        ((FilhoViewHolder) holder).mTitle.setText(object.messageEnglish);

                        if (object.messageEnglish.equalsIgnoreCase("showLoadingNow")) {
                            ((FilhoViewHolder) holder).lotianimation.setVisibility(View.VISIBLE);
                            ((FilhoViewHolder) holder).mTitle.setVisibility(View.GONE);
                        } else {
                            ((FilhoViewHolder) holder).lotianimation.setVisibility(View.GONE);
                            ((FilhoViewHolder) holder).mTitle.setVisibility(View.VISIBLE);

                        }
                        if (!object.messageEnglish.equalsIgnoreCase("showLoadingNow")) {
                            if (position == mList.size() - 1) {
                                ((FilhoViewHolder) holder).convor.setVisibility(View.VISIBLE);
                                ((FilhoViewHolder) holder).convor.startAnimation(zoom_in);
                            } else {
                                ((FilhoViewHolder) holder).convor.setVisibility(View.VISIBLE);
                            }
                        } else {
                            ((FilhoViewHolder) holder).convor.setVisibility(View.VISIBLE);

                        }
                    }


                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mList != null) {
            Statements object = mList.get(position);
            if (object != null) {
                if (object.getType().equalsIgnoreCase("remote"))
                    return typ = 1;
                else
                    return typ = 0;
            }
        }
        return 0;
    }

    public void setLanguage(String language) {
        this.language = language;
        notifyDataSetChanged();
    }

    public static class PaiViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout convos, product_card;
        ImageView obj_image;
        private TextView mTitle, avatarConv, obj_name, obj_description, obj_amount;


        PaiViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.message_body);
            avatarConv = itemView.findViewById(R.id.avatar_conv);
            obj_name = itemView.findViewById(R.id.obj_name);
            obj_description = itemView.findViewById(R.id.obj_description);
            obj_amount = itemView.findViewById(R.id.obj_amount);
            obj_image = itemView.findViewById(R.id.obj_image);
            product_card = itemView.findViewById(R.id.product_card);


            convos = itemView.findViewById(R.id.my_convo);
        }
    }

    public static class FilhoViewHolder extends RecyclerView.ViewHolder {
        LottieAnimationView lotianimation;
        ImageView image, avatarConv;
        RelativeLayout convor;
        private TextView mTitle, chatbot_name;


        FilhoViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.message_body);
            lotianimation = itemView.findViewById(R.id.lotiView);
            chatbot_name = itemView.findViewById(R.id.name);
            avatarConv = itemView.findViewById(R.id.avatar_conv);
            image = itemView.findViewById(R.id.image);
            convor = itemView.findViewById(R.id.their_convo);

        }
    }


}