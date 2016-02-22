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
import com.cook.datastorage.internalStorage.InternalStorageManager;

/**
 * Created by roma on 19.02.16.
 */
public class ExternalStorageActivity extends AppCompatActivity {

    private ActivityExternalStorageBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_external_storage);

    }

    public class ExternalStorageViewModel{

        public ObservableField<String> text = new ObservableField<>();

        public ExternalStorageViewModel() {
        }

        public void save(View view){
            Toast.makeText(getApplicationContext(), "Text has been saved", Toast.LENGTH_LONG).show();
            ExternalStorageManager.();
            text.set("");
        }

        public void load(View view){

        }

        public void getDir(View view){

        }

        public void getCahceDir(View view){

        }

        public void fileList(View view){

        }

    }
}
