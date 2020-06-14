package com.erank.boradcasttutorial;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static String ACTION = "com.erank.boradcasttutorial.GetStuff";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(v -> sendDataOut());
    }

    private void sendDataOut() {
        PackageManager pm = getPackageManager();
        Intent i = new Intent(ACTION).putExtra("name", "Eran");
        List<ResolveInfo> matches = pm.queryBroadcastReceivers(i, 0);
        for (ResolveInfo resolveInfo : matches) {
            String packageName = resolveInfo.activityInfo.applicationInfo.packageName;
            ComponentName cn = new ComponentName(packageName, resolveInfo.activityInfo.name);
            i.setComponent(cn);
            sendBroadcast(i);
        }
    }
}
