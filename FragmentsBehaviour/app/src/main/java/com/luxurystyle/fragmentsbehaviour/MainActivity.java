package com.luxurystyle.fragmentsbehaviour;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static int commitId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().popBackStack(commitId, 0);
            }
        });

        commitId = getSupportFragmentManager().beginTransaction()
                .add(R.id.first_container, TestFragment.newInstance(R.layout.fragment_test1), "1")
                .addToBackStack("1").commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.second_container, TestFragment.newInstance(R.layout.fragment_test2), "2")
                .addToBackStack("2").commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.third_container, TestFragment.newInstance(R.layout.fragment_test3), "3")
                .addToBackStack("3").commit();

    }


}
