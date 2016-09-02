package br.com.dfn.fcmexample;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import br.com.dfn.fcmexample.R;


public class Notification {

    private static int REQUEST_CODE = 1;
    public static int NOTIFICATION_ID_FCM = 1000;

    public static void showNotification(int notificationID, String content, String title) {

        final Context context = App.getContext();
        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);

        // Creates an Intent for the Activity
        Intent notifyIntent = null;
        int requestCode = REQUEST_CODE;
         notifyIntent = new Intent(context, MainActivity.class);

        // Sets the Activity to start in a new, empty task
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Creates the PendingIntent
        PendingIntent notifyPendingIntent =
                PendingIntent.getActivity(
                        context,
                        requestCode,
                        notifyIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        //Build the mandatory fields
        notification.setContentIntent(notifyPendingIntent);
        notification.setContentText(content);
        notification.setSmallIcon(R.drawable.common_google_signin_btn_icon_dark);
        notification.setContentTitle(title);

        //Build the notification
        NotificationManagerCompat.from(App.getContext()).notify(notificationID, notification.build());

    }
}
