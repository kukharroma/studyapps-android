package com.cook.datastorage.externalStorage;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
        ExternalStorageManager.init(getApplicationContext());
        ((Toolbar) findViewById(R.id.toolbar)).setTitle("External Storage");
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
    }

    public class ExternalStorageViewModel {

        public ObservableField<String> data = new ObservableField<>();
        public ObservableField<String> tvExternalDir = new ObservableField<>();
        public ObservableField<String> tvExternalCacheDir = new ObservableField<>();
        public ObservableField<String> tvExternalSdCardDir = new ObservableField<>();
        public ObservableField<String> tvExternalSdcardCacheDir = new ObservableField<>();
        public ObservableField<String> tvLoadExternalDir = new ObservableField<>();
        public ObservableField<String> tvLoadExternalCacheDir = new ObservableField<>();

        public ExternalStorageViewModel() {

//            // todo /storage/emulated/0
            Log.i(TAG, "" + Environment.getExternalStorageDirectory().getAbsolutePath());
//
//            // todo /system
            Log.i(TAG, "" + Environment.getRootDirectory().getAbsolutePath());
//
//            // todo /storage/emulated/0/Android/media/com.cook.datastorage - creates automatically after call this method
//            // todo /storage/external_SD/Android/media/com.cook.datastorage - creates automatically after call this method
            for (int i = 0; i < getExternalMediaDirs().length; i++) {
                Log.i(TAG, "" + getExternalMediaDirs()[i].getAbsolutePath());
            }
        }

        public void getExternalDir(View view) {
            Log.i(TAG, "dir ---> " + tvExternalDir.get());
            tvExternalDir.set(ExternalStorageManager.getExternalDir().getAbsolutePath());
        }

        public void getExternalCacheDir(View view) {
            Log.i(TAG, "cache dir ---> " + tvExternalCacheDir.get());
            tvExternalCacheDir.set(ExternalStorageManager.getExternalCacheDir().getAbsolutePath());
        }

        public void getExternalSdCardDir(View view) {
            Log.i(TAG, "sd dir ---> " + tvExternalSdCardDir.get());
            tvExternalSdCardDir.set(ExternalStorageManager.getExternalSdCardDir().getAbsolutePath());
        }

        public void getExternalSdCardCacheDir(View view) {
            Log.i(TAG, "sd cache dir ---> " + tvExternalSdcardCacheDir.get());
            tvExternalSdcardCacheDir.set(ExternalStorageManager.getExternalSdCardCacheDir().getAbsolutePath());
        }

        public void saveInExternaldDir(View view) {
            Toast.makeText(getApplicationContext(), "Text has been saved in external dir", Toast.LENGTH_LONG).show();
            ExternalStorageManager.saveInExternalDir(binding.edFileData.getText().toString());
            data.set("");
        }

        public void loadExternalDir(View view) {
            String data = FileHelper.loadFromFile(ExternalStorageManager.getExternalDir());
            Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
        }

        public void saveInExternalCacheDir(View view) {
            Toast.makeText(getApplicationContext(), "Text has been saved in external cache dir", Toast.LENGTH_LONG).show();
            ExternalStorageManager.saveInExternalCacheDir(binding.edFileData.getText().toString());
            data.set("");
        }

        public void loadExternalCahceDir(View view) {
            String data = FileHelper.loadFromFile(ExternalStorageManager.getExternalCacheDir());
            Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
        }


        public void saveInExternalSdCardDir(View view) {
            Toast.makeText(getApplicationContext(), "Text has been saved in external sd card", Toast.LENGTH_LONG).show();
            ExternalStorageManager.saveInExternalSdCardDir(binding.edFileData.getText().toString());
            data.set("");
        }

        public void loadExternalSdCardDir(View view) {
            String data = FileHelper.loadFromFile(ExternalStorageManager.getExternalSdCardDir());
            Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
        }

        public void saveInExternalSdCardCacheDir(View view) {
            Toast.makeText(getApplicationContext(), "Text has been saved in external sd card cache dir", Toast.LENGTH_LONG).show();
            ExternalStorageManager.saveInExternalSdCardCacheDir(binding.edFileData.getText().toString());
            data.set("");
        }

        public void loadExternalSdCardCacheDir(View view) {
            String data = FileHelper.loadFromFile(ExternalStorageManager.getExternalSdCardCacheDir());
            Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
        }
    }
}
