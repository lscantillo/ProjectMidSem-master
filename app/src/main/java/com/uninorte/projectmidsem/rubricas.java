package com.uninorte.projectmidsem;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class rubricas extends MainActivity {

    Button aceptarRub;
    EditText etnumcat,etnombreRub;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_rubricas, frameLayout);

        aceptarRub= (Button) findViewById(R.id.btnaceptarRub);
        etnumcat= (EditText) findViewById(R.id.numcat);
        etnombreRub= (EditText) findViewById(R.id.nombrerubrica);
        final dbrubricas rubricasdb = new dbrubricas(getApplicationContext());

        aceptarRub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*SQLiteDatabase sqLiteDatabase= rubricasdb.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(dbrubricas.FeedEntry.TABLE_NAME,etnombreRub.getText().toString());
                values.put(dbrubricas.FeedEntry.COLUMN_NAME_CATEGORIAS,etnumcat.getText().toString());
                long newRowId = sqLiteDatabase.insert(dbrubricas.FeedEntry.TABLE_NAME,dbrubricas.FeedEntry.TABLE_NAME,values);
                Toast.makeText(getApplicationContext(),"Se guardó el dato: "+ newRowId,Toast.LENGTH_LONG).show();*/
                Intent rub = new Intent(rubricas.this, categorias.class);
                startActivity(rub);
            }
        });

    }



}