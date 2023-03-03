package org.techtown.notificationdetector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Button button;
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        mContext = MainActivity.this;

        if (!permissionGranted()) {
            Intent intent = new Intent(
                    "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            startActivity(intent);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private boolean permissionGranted() {
        Set<String> sets = NotificationManagerCompat.getEnabledListenerPackages(this);
        if (sets != null && sets.contains(getPackageName())) {
            return true;
        } else {
            return false;
        }
    }

}