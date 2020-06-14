package com.erank.boradcasttutorial;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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
        Intent intent = new Intent(ACTION).putExtra("name", "Eran");
        sendBroadcast(intent);
    }
}
