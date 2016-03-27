package com.chensi.exampl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.chensi.exampl.activity.DateTimeActivity;
import com.chensi.exampl.activity.ITTestActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Click
    void btnITTest() {
        Intent intent = new Intent(this, ITTestActivity.class);
        startActivity(intent);
    }

    @Click
    void btnDateTime() {
        Intent intent = new Intent(this, DateTimeActivity.class);
        startActivity(intent);
    }
}
