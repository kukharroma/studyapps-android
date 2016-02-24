package com.cook.datastorage;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cook.datastorage.databinding.ActivityMainBinding;
import com.cook.datastorage.fileStorage.externalStorage.ExternalStorageActivity;
import com.cook.datastorage.fileStorage.internalStorage.InternalStorageActivity;
import com.cook.datastorage.preferences.PrefActivity;
import com.cook.datastorage.sqlite.SqliteActivity;

/**
 * Created by roma on 24.02.16.
 */
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(new MainViewModel());
    }

    public class MainViewModel {

        public void showPrefsStorageActivity(View view) {
            startActivity(new Intent(getApplicationContext(), PrefActivity.class));
        }

        public void showInternalStorageActivity(View view) {
            startActivity(new Intent(getApplicationContext(), InternalStorageActivity.class));
        }

        public void showExternalStorageActivity(View view) {
            startActivity(new Intent(getApplicationContext(), ExternalStorageActivity.class));
        }

        public void showSqliteStorageActivity(View view) {
            startActivity(new Intent(getApplicationContext(), SqliteActivity.class));
        }
    }
}
