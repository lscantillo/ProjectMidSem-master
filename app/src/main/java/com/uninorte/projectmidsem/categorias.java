package com.uninorte.projectmidsem;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class categorias extends MainActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_categorias, frameLayout);
        // setContentView(R.layout.activity_categorias);
        final TextView nombrecategorias= (TextView) findViewById(R.id.etCategory);
        final TextView peso= (TextView) findViewById(R.id.etWeight);
        final TextView elemento= (TextView) findViewById(R.id.etElement);
        final TextView L1= (TextView) findViewById(R.id.etLevelOne);
        final TextView L2= (TextView) findViewById(R.id.etLevelTwo);
        final TextView L3= (TextView) findViewById(R.id.etLevelThree);
        final TextView L4= (TextView) findViewById(R.id.etLevelFour);
        final Button agregar = (Button) findViewById(R.id.btnagregar);
        Log.d("DEBUG", " " + L1.toString());

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListView lista = (ListView) findViewById(R.id.lista);
                String []cadena={nombrecategorias.getText().toString(),peso.getText().toString(),elemento.getText().toString(),L1.getText().toString(),L2.getText().toString(),L3.getText().toString(),L4.getText().toString()};

                TableRow row= new TableRow(getBaseContext());
                TextView textView;
                for (int i =0 ;i<3;i++){

                    textView = new TextView(getBaseContext());
                    textView.setGravity(Gravity.CENTER_VERTICAL);
                    textView.setPadding(15,15,15,15);
                    textView.setBackgroundResource(R.color.colorPrimaryLight);
                    textView.setText(cadena[i]);
                    textView.setTextColor(Color.WHITE);
                    row.addView(textView);

                }

                lista.addView(row);

            }
        });

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