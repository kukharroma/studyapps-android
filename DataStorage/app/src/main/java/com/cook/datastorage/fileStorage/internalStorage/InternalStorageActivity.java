package com.cook.datastorage.fileStorage.internalStorage;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cook.datastorage.R;
import com.cook.datastorage.databinding.ActivityInternalStorageBinding;

import java.util.Arrays;

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
            Toast.makeText(getApplicationContext(), "Text has been saved", Toast.LENGTH_LONG).show();
            InternalStorageManager.saveName(binding.editText.getText().toString());
            text.set("");
        }

        public void get(View view) {
            binding.tvLoad.setText(InternalStorageManager.getName());
        }

        public void getDir(View view) {
            Log.i(getClass().getSimpleName(), InternalStorageManager.getDir(InternalStorageManager.FILE_NAME).getAbsolutePath());
            binding.tvGetDir.setText(InternalStorageManager.getDir(InternalStorageManager.FILE_NAME).getAbsolutePath());
        }

        public void getDirCache(View view) {
            Log.i(getClass().getSimpleName(),InternalStorageManager.getDirCache().getAbsolutePath());
            binding.tvDirCache.setText(InternalStorageManager.getDirCache().getAbsolutePath());
        }

        public void deleteFile(View view) {
            Toast.makeText(getApplicationContext(), "File has been deleted", Toast.LENGTH_LONG).show();
            InternalStorageManager.deleteFile(InternalStorageManager.FILE_NAME);
        }

        public void fileList(View view) {
            Log.i(getClass().getSimpleName(), Arrays.toString(InternalStorageManager.fileList()));
            binding.tvFileList.setText(Arrays.toString(InternalStorageManager.fileList()));
        }
    }
}
