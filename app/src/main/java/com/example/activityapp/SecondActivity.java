package com.example.activityapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.activityapp.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private static final String EXTRA_DATA = "extra_data";

    private ActivitySecondBinding binding;

    public static Intent createIntent(Context context, String data) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(EXTRA_DATA, data);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String data = getIntent().getStringExtra(EXTRA_DATA);
        binding.textView.setText(data);

        binding.okButton.setOnClickListener(v -> setResultAndFinish(100));
        binding.cancelButton.setOnClickListener(v -> setResultAndFinish(200));
    }

    private void setResultAndFinish(int resultCode) {
        setResult(resultCode);
        finish();
    }
}
