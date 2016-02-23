package com.cook.datastorage.externalStorage;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.cook.datastorage.R;
import com.cook.datastorage.databinding.ActivityExternalStorageBinding;
import com.cook.datastorage.helper.FileHelper;
import com.cook.datastorage.internalStorage.InternalStorageManager;

import org.apache.commons.io.FileUtils;

/**
 * Created by roma on 19.02.16.
 */
public class ExternalStorageActivity extends AppCompatActivity {

    private ActivityExternalStorageBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_external_storage);
        binding.setViewModel(new ExternalStorageViewModel());
    }

    public class ExternalStorageViewModel {

        public ObservableField<String> data = new ObservableField<>();
        public ObservableField<String> tvExternalDir = new ObservableField<>();
        public ObservableField<String> tvExternalCacheDir = new ObservableField<>();
        public ObservableField<String> tvLoadExternalDir = new ObservableField<>();
        public ObservableField<String> tvLoadExternalCacheDir = new ObservableField<>();

        public ExternalStorageViewModel() {
        }

        public void getDir(View view) {
            tvExternalDir.set(ExternalStorageManager.getExternalDir().getAbsolutePath());
        }

        public void getCahceDir(View view) {
            tvExternalDir.set(ExternalStorageManager.getExternalCacheDir().getAbsolutePath());
        }

        public void saveInExternalDir(View view) {
            Toast.makeText(getApplicationContext(), "Text has been saved", Toast.LENGTH_LONG).show();
            ExternalStorageManager.saveInExternalDir(binding.etFileData.getText().toString());
            data.set("");
        }

        public void loadExternalDir(View view) {
            tvLoadExternalDir.set(FileHelper.loadFromFile(ExternalStorageManager.getExternalDir()));
        }

        public void saveInExternalCacheDir(View view) {
            Toast.makeText(getApplicationContext(), "Text has been saved in external cache dir", Toast.LENGTH_LONG).show();
            ExternalStorageManager.saveInExternalCacheDir(binding.etFileData.getText().toString());
            data.set("");
        }

        public void loadExternalCahceDir(View view) {
            tvLoadExternalDir.set(FileHelper.loadFromFile(ExternalStorageManager.getExternalCacheDir()));
        }

    }
}
