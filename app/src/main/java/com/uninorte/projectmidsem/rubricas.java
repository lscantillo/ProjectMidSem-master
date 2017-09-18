package com.uninorte.projectmidsem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class rubricas extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_rubricas, frameLayout);

//        setContentView(R.layout.activity_rubricas);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getLayoutInflater().inflate(R.layout.activity_rubricas, frameLayout);
//        setContentView(R.layout.activity_rubricas);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
