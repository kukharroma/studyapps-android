package com.cook.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.cook.databinding.databinding.ActivityDatabindingBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

/**
 * Created by roma on 09.02.16.
 */
public class DataBindingActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDatabindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);

        //  user
        final User user = new User();
        user.setAge(15);
        user.setName("Roma");
        user.setImageUrl("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcS5eDs9VOSShXa5_ws0FJLguy5H-9_2YOzW3jcXqWMj6eEJUT2n6YaqZg");

        // userList
        List<User> userList = new ArrayList<>();
        userList.add(0, user);

        // userObservable
        final UserObservable userObservable = new UserObservable();
        userObservable.setFirstName("firstName");
        userObservable.setLastName("lastName");


        // binding
        binding.setUserObservable(userObservable);
        binding.setUserList(userList);
        binding.setUser(user);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    userObservable.setFirstName("NewFirstName");
                    userObservable.setLastName("NewLastName");
                    showToast("UserObservable has been updated");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void showToast(final String message){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
