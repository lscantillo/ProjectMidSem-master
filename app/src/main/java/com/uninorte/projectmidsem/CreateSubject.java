package com.uninorte.projectmidsem;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

// Class for executing "Create Subject" activity
public class CreateSubject extends MainActivity  {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_create_subject, frameLayout);

//        setContentView(R.layout.activity_create_subject);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);




    }

    @Override
    protected void onStart() {
        super.onStart();
        getLayoutInflater().inflate(R.layout.activity_create_subject, frameLayout);

//        setContentView(R.layout.activity_create_subject);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }




        public void onClick(View view) {
            AlertDialog.Builder builder =new AlertDialog.Builder(CreateSubject.this);
            View mView = getLayoutInflater().inflate(R.layout.dialog_subject,null);
            final EditText namesubj = mView.findViewById(R.id.etnamesubject);
            final Button btnewsubject = mView.findViewById(R.id.btn_newsubject);
            btnewsubject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!namesubj.getText().toString().isEmpty()){
                        Toast.makeText(CreateSubject.this,"Asignatura Agregada",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(CreateSubject.this,"Campo vacío",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            builder.setView(mView);
            builder.setNegativeButton(getString(android.R.string.cancel),null);
            AlertDialog dialog= builder.create();
            dialog.show();
        }


    /*public void onclicksubject(View view) {
        AlertDialog.Builder builder =new AlertDialog.Builder(CreateSubject.this);
        final EditText namesubject = new EditText(this);
        builder.setTitle(getString(R.string.titulo));
        namesubject.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        builder.setMessage(getString(R.string.dialogo_meg));
        builder.setPositiveButton(getString(android.R.string.ok),null);
        builder.setNegativeButton(getString(android.R.string.cancel),null);
        AlertDialog dialog =builder.create();
        dialog.show();
    }*/
}
