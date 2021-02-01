package com.craftsvilla.plotchadminapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.craftsvilla.plotchadminapp.R;
import com.craftsvilla.plotchadminapp.model.Notification;
import com.craftsvilla.plotchadminapp.view.adapter.NotifiicationAdapter;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.plotch.sdk.PlotchChatbotService;
import com.plotch.sdk.PlotchNotificationService;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {


    private String manifestKey = "";
    private String notification_instance_id = "";
    private String chatbot_instance_id = "";
    ImageView fab;
    EditText token, userid;
    private Button button;


    private final static int ID_HOME = 1;
    private final static int ID_EXPLORE = 2;
    private final static int ID_MESSAGE = 3;
    private final static int ID_NOTIFICATION = 4;
    private final static int ID_ACCOUNT = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        chatbot_instance_id = getString(R.string.chatbot_instance_id);
        notification_instance_id = getString(R.string.notification_instance_id);
        token = findViewById(R.id.token);
        token.setText("7021543_0c016394666e38ad5b6fab7c9d9d7566");
        userid = findViewById(R.id.userid);
        userid.setText("7021543");
        button = findViewById(R.id.button);

        final TextView tvSelected = findViewById(R.id.tv_selected);
        tvSelected.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-Regular.ttf"));

        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomNavigation);

        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_EXPLORE, R.drawable.ic_explore));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_MESSAGE, R.drawable.ic_message));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_NOTIFICATION, R.drawable.ic_notification));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_ACCOUNT, R.drawable.ic_account));

        bottomNavigation.setCount(ID_NOTIFICATION, "115");

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(HomeActivity.this, "clicked item : " + item.getId(), Toast.LENGTH_SHORT).show();
                if(item.getId()==4){
                    Intent i = new Intent(HomeActivity.this, NotificationActivity.class);
                    startActivity(i);
                }
            }
        });

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Toast.makeText(HomeActivity.this, "showing item : " + item.getId(), Toast.LENGTH_SHORT).show();

                String name;
                switch (item.getId()) {
                    case ID_HOME:
                        name = "HOME";
                        break;
                    case ID_EXPLORE:
                        name = "EXPLORE";
                        break;
                    case ID_MESSAGE:
                        name = "MESSAGE";
                        break;
                    case ID_NOTIFICATION:
                        name = "NOTIFICATION";
                        break;
                    case ID_ACCOUNT:
                        name = "ACCOUNT";
                        break;
                    default:
                        name = "";
                }
                tvSelected.setText(getString(R.string.main_page_selected, name));
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Toast.makeText(HomeActivity.this, "reselected item : " + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.setCount(ID_NOTIFICATION, "115");

        bottomNavigation.show(ID_NOTIFICATION,true);



        PlotchNotificationService.init(HomeActivity.this);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fab.performClick();
            }
        });



    }
}