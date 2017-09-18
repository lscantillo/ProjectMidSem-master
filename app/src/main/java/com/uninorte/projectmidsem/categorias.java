package com.uninorte.projectmidsem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class categorias extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_categorias, frameLayout);
        // setContentView(R.layout.activity_categorias);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getLayoutInflater().inflate(R.layout.activity_categorias, frameLayout);
     // setContentView(R.layout.activity_create_subject);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
