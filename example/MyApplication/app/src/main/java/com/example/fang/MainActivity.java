package com.example.fang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MiPushClient.registerPush(getApplicationContext(), "2882303761517719672", "5521771985672");
    }
}
