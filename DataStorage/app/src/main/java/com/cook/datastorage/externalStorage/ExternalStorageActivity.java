package com.cook.datastorage.externalStorage;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cook.datastorage.R;
import com.cook.datastorage.databinding.ActivityExternalStorageBinding;
import com.cook.datastorage.helper.FileHelper;

/**
 * Created by roma on 19.02.16.
 */
public class ExternalStorageActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getSimpleName();

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

//            // todo /storage/emulated/0
//            Log.i(TAG, "" + Environment.getExternalStorageDirectory().getAbsolutePath());
//
//            // todo /system
//            Log.i(TAG, "" + Environment.getRootDirectory().getAbsolutePath());
//
//            // todo /storage/emulated/0/Android/media/com.cook.datastorage - creates automatically after call this method
//            // todo /storage/external_SD/Android/media/com.cook.datastorage - creates automatically after call this method
//            for (int i = 0; i < getExternalMediaDirs().length; i++) {
//                Log.i(TAG, "" + getExternalMediaDirs()[i].getAbsolutePath());
//            }

        }

        public void getDir(View view) {
            tvExternalDir.set(ExternalStorageManager.getExternalDir().getAbsolutePath());
            Log.i(TAG, "dir ---> " + tvExternalDir.get());
        }

        public void getCahceDir(View view) {
            Log.i(TAG, "dir ---> " + tvExternalCacheDir.get());
            tvExternalCacheDir.set(ExternalStorageManager.getExternalCacheDir().getAbsolutePath());
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
