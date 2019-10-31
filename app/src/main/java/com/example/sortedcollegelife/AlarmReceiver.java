package com.example.sortedcollegelife;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

import static android.content.Context.NOTIFICATION_SERVICE;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        /*Toast.makeText(context, "hi", Toast.LENGTH_SHORT).show();
        int notification=intent.getIntExtra("notification",0);

        Intent mainintent=new Intent(context,timetable.class);
        PendingIntent contextintent=PendingIntent.getActivity(context,0,mainintent,0);

        NotificationManager mynotification=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);


        Notification.Builder builder=new Notification.Builder(context);
        builder.setSmallIcon(android.R.drawable.ic_menu_camera)
                .setContentTitle("reach class")
                .setContentText("ok").setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentIntent(contextintent);

        mynotification.notify(notification, builder.build());*/

        Toast.makeText(context, "Alarm Started", Toast.LENGTH_LONG).show();
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(3000);


        Notification noti=new Notification.Builder(context)
                .setContentTitle("New Message")
                .setContentText("hello here's the notification").setSmallIcon(R.mipmap.ic_launcher).build();

        NotificationManager manager = (NotificationManager)context.getSystemService(NOTIFICATION_SERVICE);
        noti.flags |= Notification.FLAG_AUTO_CANCEL;
        manager.notify(0, noti);

    }
}
