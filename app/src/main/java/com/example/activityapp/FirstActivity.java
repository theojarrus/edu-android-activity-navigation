package com.example.activityapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult;
import androidx.appcompat.app.AppCompatActivity;

import com.example.activityapp.databinding.ActivityFirstBinding;

public class FirstActivity extends AppCompatActivity {

    private ActivityFirstBinding binding;

    private ActivityResultLauncher<Intent> defaultContractLauncher = registerForActivityResult(
            new StartActivityForResult(),
            result -> showToast(String.valueOf(result.getResultCode()))
    );

    private ActivityResultLauncher<String> customContractLauncher = registerForActivityResult(
            new SecondActivityContract(),
            result -> showToast(String.valueOf(result.getResultCode()))
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.primaryButton.setOnClickListener(v -> startSecondActivityForResultWithoutIntent());
    }

    private String getFieldData() {
        return binding.field.getText().toString();
    }

    private void startSecondActivityWithIntent() {
        Intent intent = SecondActivity.createIntent(this, getFieldData());
        startActivity(intent);
    }

    private void startSecondActivityForResultWithIntent() {
        Intent intent = SecondActivity.createIntent(this, getFieldData());
        defaultContractLauncher.launch(intent);
    }

    private void startSecondActivityForResultWithoutIntent() {
        customContractLauncher.launch(getFieldData());
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
