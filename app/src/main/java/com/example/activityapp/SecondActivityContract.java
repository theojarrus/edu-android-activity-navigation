package com.example.activityapp;

import android.content.Context;
import android.content.Intent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class SecondActivityContract extends ActivityResultContract<String, ActivityResult> {

    @NonNull
    @Override
    public Intent createIntent(@NonNull Context context, String data) {
        return SecondActivity.createIntent(context, data);
    }

    @Override
    public ActivityResult parseResult(int resultCode, @Nullable Intent intent) {
        return new ActivityResult(resultCode, intent);
    }
}
