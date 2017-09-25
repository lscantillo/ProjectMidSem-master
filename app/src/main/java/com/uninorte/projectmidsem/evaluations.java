package com.uninorte.projectmidsem;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class evaluations extends MainActivity {

    ListView listaResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_evaluations);
        getLayoutInflater().inflate(R.layout.activity_evaluations, frameLayout);
    }


    public void onClickBtnCreateEval(View view) {
        AlertDialog.Builder builder =new AlertDialog.Builder(evaluations.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_eval,null);
        final EditText nameEval = mView.findViewById(R.id.etNameEval);
        final EditText peso = mView.findViewById(R.id.etpeso);
        final Button btneweval= mView.findViewById(R.id.btnNewEval);
        listaResultado = (ListView) findViewById(R.id.lvEvalList);

        btneweval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nameEval.getText().toString().isEmpty() && !peso.getText().toString().isEmpty()){
                    Toast.makeText(evaluations.this,"Asignatura " + nameEval.getText().toString() + " Agregada",Toast.LENGTH_SHORT).show();
                    nameEval.setText(null);
                    peso.setText(null);
                    RegistroEval registro1 = new RegistroEval(nameEval.getText().toString(),peso.getText().toString());
                    registro1.save();
                }
                else {
                    Toast.makeText(evaluations.this,"Algún campo vacío",Toast.LENGTH_SHORT).show();
                }



            }
        });


        builder.setView(mView);
        builder.setNegativeButton(getString(android.R.string.cancel),null);
        AlertDialog dialog= builder.create();
        dialog.show();


    }


            private void cargarListViewSQLite(){

                List<RegistroEval> registro1Lista= RegistroEval.listAll(RegistroEval.class);
                ArrayList<String> lista1 =new ArrayList<String>();

                for(int i=0;i< registro1Lista.size();i++){
                    RegistroEval result = registro1Lista.get(i);
                    lista1.add(""+ result.getNombreeval()+" - "+ result.getPeso());
                }

                ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.activity_list_item,lista1);
                listaResultado.setAdapter(adaptador);
            }

            public void onClickBtnVerEval(View view) {
                cargarListViewSQLite();

            }


}
