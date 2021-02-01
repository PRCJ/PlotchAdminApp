package com.craftsvilla.plotchadminapp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.craftsvilla.plotchadminapp.R;
import com.craftsvilla.plotchadminapp.model.Notification;

import java.util.ArrayList;

public class NotifiicationAdapter  extends RecyclerView.Adapter<NotifiicationAdapter.NotifiView> {




    ArrayList<Notification> addNotiModel;
    public NotifiicationAdapter(ArrayList<Notification> addNotiModel) {
        this.addNotiModel = addNotiModel;
    }




    @NonNull
    @Override
    public NotifiicationAdapter.NotifiView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_notification,parent,false);
        return new NotifiView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotifiicationAdapter.NotifiView holder, int position) {

holder.productImage.setImageResource(addNotiModel.get(position).getProductImage());
holder.productName.setText(addNotiModel.get(position).getProductName());
holder.productOffer.setText(addNotiModel.get(position).getProductOffer());
holder.receivedHours.setText(addNotiModel.get(position).getReceivedHours());
holder.time.setText(addNotiModel.get(position).getTime());
holder.shopText.setText(addNotiModel.get(position).getShopText());

//holder.productImage.setImageResource(Integer.parseInt(addNotiModel.get(position).getProductImage()));


    }

    @Override
    public int getItemCount() {
        return addNotiModel.size();
    }

    public class NotifiView extends RecyclerView.ViewHolder {

ImageView productImage;
TextView productName,productOffer,receivedHours,time,shopText;
        public NotifiView(@NonNull View itemView) {
            super(itemView);
productImage=itemView.findViewById(R.id.productImage);
productName=itemView.findViewById(R.id.productName);
productOffer=itemView.findViewById(R.id.productOffer);
receivedHours=itemView.findViewById(R.id.receivedHours);
time=itemView.findViewById(R.id.time);
shopText=itemView.findViewById(R.id.shopText);

        }
    }
}
