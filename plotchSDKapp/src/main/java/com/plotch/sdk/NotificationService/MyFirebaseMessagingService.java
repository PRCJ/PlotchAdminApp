package com.plotch.sdk.NotificationService;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.plotch.sdk.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMessagingServ";

    Target target = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            sendNotification(bitmap);
        }

        @Override
        public void onBitmapFailed(Exception e, Drawable errorDrawable) {

        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }
    };

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if (remoteMessage.getData() != null)
            getImage(remoteMessage);
    }

    private void sendNotification(Bitmap bitmap) {


        NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle();
        style.bigPicture(bitmap);

        Uri defaultSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Intent intent = null;
        try {
            intent = new Intent(getApplicationContext(), Class.forName("com.plotch.sdk.ChatBotService.ui.ChatbotActivity"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String NOTIFICATION_CHANNEL_ID = "101";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            @SuppressLint("WrongConstant") NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "Notification", NotificationManager.IMPORTANCE_MAX);

            //Configure Notification Channel
            notificationChannel.setDescription("Notifications");
            notificationChannel.enableLights(true);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);

            notificationManager.createNotificationChannel(notificationChannel);
        }
        Context ctx = this;
        final SharedPreferences sharedPreferences = ctx.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

        NotificationCompat.Builder notificationBuilder = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {


            notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
//                    .setSmallIcon(Icon.createWithBitmap(getBitmapFromURL))
                    .setSmallIcon(R.drawable.ic_lens_black_24dp)
                    .setContentTitle(sharedPreferences.getString("title", ""))
                    .setAutoCancel(true)
                    .setSound(defaultSound)
                    .setContentText(sharedPreferences.getString("content", ""))
                    .setContentIntent(pendingIntent)
                    .setStyle(style)
                    .setLargeIcon(bitmap)
                    .setWhen(System.currentTimeMillis())
                    .setPriority(Notification.PRIORITY_MAX);
        } else {
            notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_lens_black_24dp)
                    .setContentTitle(sharedPreferences.getString("title", ""))
                    .setAutoCancel(true)
                    .setSound(defaultSound)
                    .setContentText(sharedPreferences.getString("content", ""))
                    .setContentIntent(pendingIntent)
                    .setStyle(style)
                    .setLargeIcon(bitmap)
                    .setWhen(System.currentTimeMillis())
                    .setPriority(Notification.PRIORITY_MAX);
        }


        notificationManager.notify(1, notificationBuilder.build());


    }

    private void getImage(final RemoteMessage remoteMessage) {

        Map<String, String> data = remoteMessage.getData();

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        myEdit.putString("notification_title", data.get("title"));
        myEdit.putString("notification_content", data.get("content"));
        myEdit.putString("notification_image_url", data.get("imageUrl"));

        //Create thread to fetch image from notification

        String Img = data.get("imageUrl");

        if (remoteMessage.getData() != null) {

            Handler uiHandler = new Handler(Looper.getMainLooper());
            uiHandler.post(new Runnable() {
                @Override
                public void run() {
                    // Get image from data Notification
                    if (TextUtils.isEmpty(Img)) {
                        Picasso.get().load(Img).into(target);
                    }
                }
            });
        }
    }

    public Bitmap getBitmapFromURL(String strURL) {
        try {
            URL url = new URL(strURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
