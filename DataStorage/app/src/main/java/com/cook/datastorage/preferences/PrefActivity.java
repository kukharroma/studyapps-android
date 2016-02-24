package com.cook.datastorage.preferences;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.cook.datastorage.R;
import com.cook.datastorage.databinding.ActivityPreferencesBinding;

/**
 * Created by roma on 24.02.16.
 */
public class PrefActivity extends AppCompatActivity {

    ActivityPreferencesBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_preferences);
        binding.setViewModel(new PrefViewModel());
    }

    public class PrefViewModel {
        public ObservableField<String> data = new ObservableField<>();


        public void saveInPrefs(View view) {
            String data = binding.etPrefs.getText().toString();
            PrefManager.saveData(data);
            Toast.makeText(getApplicationContext(), "saved in prefs", Toast.LENGTH_LONG).show();
        }

        public void loadFromPrefs(View view) {
            String data = PrefManager.getData();
            Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
            this.data.set("");
        }

    }
}
