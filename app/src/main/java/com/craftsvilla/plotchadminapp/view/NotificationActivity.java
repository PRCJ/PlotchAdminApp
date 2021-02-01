package com.craftsvilla.plotchadminapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.craftsvilla.plotchadminapp.R;
import com.craftsvilla.plotchadminapp.model.Notification;
import com.craftsvilla.plotchadminapp.view.adapter.NotifiicationAdapter;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {
    ArrayList<Notification> addNotiModel = new ArrayList<Notification>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        recyclerView = findViewById(R.id.notification_recyclerView);

        addNotiModel.add(new Notification(R.drawable.gowns,"Craftsvilla Curated - Gowns","Up to 48% Off | Click on Shop now","Received 6 hours ago","09:45 AM","Shop"));

        addNotiModel.add(new Notification(R.drawable.gowns,"Craftsvilla Curated - Gowns","Up to 48% Off | Click on Shop now","Received 6 hours ago","09:45 AM","Shop"));

        addNotiModel.add(new Notification(R.drawable.gowns,"Craftsvilla Curated - Gowns","Up to 48% Off | Click on Shop now","Received 6 hours ago","09:45 AM","Shop"));

        addNotiModel.add(new Notification(R.drawable.gowns,"Craftsvilla Curated - Gowns","Up to 48% Off | Click on Shop now","Received 6 hours ago","09:45 AM","Shop"));

        addNotiModel.add(new Notification(R.drawable.gowns,"Craftsvilla Curated - Gowns","Up to 48% Off | Click on Shop now","Received 6 hours ago","09:45 AM","Shop"));

        addNotiModel.add(new Notification(R.drawable.gowns,"Craftsvilla Curated - Gowns","Up to 48% Off | Click on Shop now","Received 6 hours ago","09:45 AM","Shop"));

        addNotiModel.add(new Notification(R.drawable.gowns,"Craftsvilla Curated - Gowns","Up to 48% Off | Click on Shop now","Received 6 hours ago","09:45 AM","Shop"));
        addNotiModel.add(new Notification(R.drawable.gowns,"Craftsvilla Curated - Gowns","Up to 48% Off | Click on Shop now","Received 6 hours ago","09:45 AM","Shop"));
        addNotiModel.add(new Notification(R.drawable.gowns,"Craftsvilla Curated - Gowns","Up to 48% Off | Click on Shop now","Received 6 hours ago","09:45 AM","Shop"));

        addNotiModel.add(new Notification(R.drawable.gowns,"Craftsvilla Curated - Gowns","Up to 48% Off | Click on Shop now","Received 6 hours ago","09:45 AM","Shop"));





        recyclerView.setAdapter(new NotifiicationAdapter(addNotiModel));
    }
}