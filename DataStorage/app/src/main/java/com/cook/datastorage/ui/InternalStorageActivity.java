package com.cook.datastorage.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.cook.datastorage.R;
import com.cook.datastorage.databinding.ActivityInternalStorageBinding;
import com.cook.datastorage.internalStorage.InternalStorageManager;

/**
 * Created by roma on 19.02.16.
 */
public class InternalStorageActivity extends AppCompatActivity {

    private ActivityInternalStorageBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_internal_storage);
        binding.setViewModel(new InternalStorageViewModel());
        InternalStorageManager.init(getApplicationContext());
    }

    public class InternalStorageViewModel {

        public ObservableField<String> text = new ObservableField<>();

        public InternalStorageViewModel() {
        }

        public void save(View view) {
            Log.i(getClass().getSimpleName(), "Name has been saved ----> " + binding.editText.getText().toString());
            InternalStorageManager.saveName(binding.editText.getText().toString());
        }

        public void get(View view) {
            text.set(InternalStorageManager.getName());
            Log.i(getClass().getSimpleName(), "Name is ----> " + InternalStorageManager.getName());
        }

        public void getDirCache(View view) {

        }

        public void getDir(View view) {

        }

        public void deleteFile(View view) {

        }

        public void fileList(View view) {

        }
    }
}
