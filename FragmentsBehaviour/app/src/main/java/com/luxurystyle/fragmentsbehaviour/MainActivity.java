package com.luxurystyle.fragmentsbehaviour;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment2 = TestFragment.newInstance(R.layout.fragment_test2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .remove(fragment2)
                        .addToBackStack("2")
                        .commit();
            }
        });

        getSupportFragmentManager().beginTransaction()
                .add(R.id.first_container, TestFragment.newInstance(R.layout.fragment_test1), "1")
                .addToBackStack("1").commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.second_container, fragment2, "2")
                .commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.third_container, TestFragment.newInstance(R.layout.fragment_test3), "3")
                .addToBackStack("3").commit();


    }


}
