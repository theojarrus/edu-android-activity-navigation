package com.example.activityapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.activityapp.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.d("ActivityLifecycle", "SecondActivity: onCreate()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ActivityLifecycle", "SecondActivity: onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityLifecycle", "SecondActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ActivityLifecycle", "SecondActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ActivityLifecycle", "SecondActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityLifecycle", "SecondActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityLifecycle", "SecondActivity: onDestroy()");
    }
}
