package com.example.activityapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.activityapp.databinding.ActivityFirstBinding;

public class FirstActivity extends AppCompatActivity {

    private static final String KEY_COUNTER = "key_counter";

    private ActivityFirstBinding binding;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textViewOne.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        });

        binding.textViewTwo.setOnClickListener(v -> {
            counter += 1;
            binding.textViewTwo.setText(String.valueOf(counter));
        });

        Log.d("ActivityLifecycle", String.valueOf(savedInstanceState));

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(KEY_COUNTER);
            binding.textViewTwo.setText(String.valueOf(counter));

            binding.textViewStatus.setText("Activity recreated");
        } else {
            binding.textViewStatus.setText("Activity created for first time");
        }

        Log.d("ActivityLifecycle", "FirstActivity: onCreate()");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER, counter);
        Log.d("ActivityLifecycle", "FirstActivity: onSaveInstanceState()");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("ActivityLifecycle", "FirstActivity: onRestoreInstanceState()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ActivityLifecycle", "FirstActivity: onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityLifecycle", "FirstActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ActivityLifecycle", "FirstActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ActivityLifecycle", "FirstActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityLifecycle", "FirstActivity: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityLifecycle", "FirstActivity: onDestroy()");
    }
}
