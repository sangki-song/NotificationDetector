package org.techtown.notificationdetector;

import android.app.Notification;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.IBinder;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import androidx.core.app.NotificationManagerCompat;

import java.util.Set;

public class NotificationListenerService extends android.service.notification.NotificationListenerService {
    public final static String TAG = "NotificationListener";
    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        super.onNotificationRemoved(sbn);

        Log.d(TAG, "onNotificationRemoved ~ " +
                " packageName: " + sbn.getPackageName() +
                " id: " + sbn.getId());
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        super.onNotificationPosted(sbn);

        Notification notification = sbn.getNotification();
        Bundle extras = sbn.getNotification().extras;
        String title = extras.getString(Notification.EXTRA_TITLE);
        CharSequence text = extras.getCharSequence(Notification.EXTRA_TEXT);
        CharSequence subText = extras.getCharSequence(Notification.EXTRA_SUB_TEXT);
        Icon smallIcon = notification.getSmallIcon();
        Icon largeIcon = notification.getLargeIcon();

        Log.d("***알림확인", "onNotificationPosted ~ " +
                " packageName: " + sbn.getPackageName() +
                " id: " + sbn.getId() +
                " postTime: " + sbn.getPostTime() +
                " title: " + title +
                " text : " + text +
                " subText: " + subText);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}