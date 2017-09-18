package com.uninorte.projectmidsem;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class campos extends AppCompatActivity {

    TextView campos;
    EditText texto;
    ConstraintLayout lycampos;
    FrameLayout principal;
    Button boton;
    TextView num;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        campos=(TextView) findViewById(R.id.tvcampo);
        texto=(EditText) findViewById(R.id.ettexto);
        lycampos=(ConstraintLayout) findViewById(R.id.camposly) ;
        principal= (FrameLayout) findViewById(R.id.principal);
        boton=(Button) findViewById(R.id.button);
        num=(TextView) findViewById(R.id.numero);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                lycampos = (ConstraintLayout) View.inflate(campos.this,R.layout.activity_campos, null);
//                principal.addView(lycampos);
//                ((TextView) lycampos.findViewById(R.id.numero)).setText(String.valueOf(i+1));
//                i++;
//
//            }
//        });


    }
}
