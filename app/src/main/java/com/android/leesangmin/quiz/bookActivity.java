package com.android.leesangmin.quiz;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class bookActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }
}