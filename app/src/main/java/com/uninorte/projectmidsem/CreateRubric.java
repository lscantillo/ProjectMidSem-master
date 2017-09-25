package com.uninorte.projectmidsem;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class CreateRubric extends MainActivity {

    // Make private the DataEntryDAO variable.
    private DataEntryDAO mDataEntryDAO;
    private String TAG = Constants.TAG;
    private ListView listView;
    private CustomAdapterRubric adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_rubricas, frameLayout);

        // Get the list view id from layout
        listView = (ListView) findViewById(R.id.lvRubricList);

        // Calls the function from the other java file.
        mDataEntryDAO = new DataEntryDAO(this);

        List<DataEntry> entryList = mDataEntryDAO.getAllEntries(DatabaseHandler.TABLE_RUBRIC);

        adapter = new CustomAdapterRubric(this, entryList);

        listView.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mDataEntryDAO.close();
        super.onDestroy();
    }


    public void onClickBtnCreateRubric(View view) {
        AlertDialog.Builder builder =new AlertDialog.Builder(CreateRubric.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_rubric_field,null);
        final EditText nameRubric = mView.findViewById(R.id.etNameRubric);
        final EditText categNRubric = mView.findViewById(R.id.etCategoryRubric);
        final EditText categWRubric = mView.findViewById(R.id.etCategoryWeight);
        final EditText elemNRubric = mView.findViewById(R.id.etElementName);
        final EditText elemWRubric = mView.findViewById(R.id.etElementWeight);
        final EditText lvlOneRubric = mView.findViewById(R.id.etLevelOne);
        final EditText lvlTwoRubric = mView.findViewById(R.id.etLevelTwo);
        final EditText lvlThreeRubric = mView.findViewById(R.id.etLevelThree);
        final EditText lvlFourRubric = mView.findViewById(R.id.etLevelFour);
        final Button btnNewRubric = mView.findViewById(R.id.btnNewRubric);
        btnNewRubric.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!nameRubric.getText().toString().isEmpty()){
                    Toast.makeText(CreateRubric.this,"Rubrica " + nameRubric.getText().toString() + " Agregada",Toast.LENGTH_SHORT).show();
                    DataEntryRubric dbRubric = new DataEntryRubric(nameRubric.getText().toString());
                    long index = mDataEntryDAO.addDataEntryRubric(dbRubric);
                    Log.d(TAG, " ID RUBRICA "+ index);
                    DataEntryCategory dbCategory = new DataEntryCategory((int) index, categNRubric.getText().toString(),
                            Integer.parseInt(categWRubric.getText().toString()));
                    mDataEntryDAO.addDataEntryCategory(dbCategory);

                    List<DataEntry> entryList = mDataEntryDAO.getAllEntries(DatabaseHandler.TABLE_RUBRIC);
                    adapter.setData(entryList);
                    listView.setAdapter(adapter);
                    nameRubric.setText(null);
                }
                else {
                    Toast.makeText(CreateRubric.this,"Campo vacío",Toast.LENGTH_SHORT).show();
                }
            }
        });
//        AlertDialog.Builder builder =new AlertDialog.Builder(CreateRubric.this);
//        View mView = getLayoutInflater().inflate(R.layout.dialog_rubric_name,null);
//        final EditText nameRubric = mView.findViewById(R.id.etNameRubric);
//        final Button btnNewRubric = mView.findViewById(R.id.btnNewRubric);
//        btnNewRubric.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!nameRubric.getText().toString().isEmpty()){
//                    Toast.makeText(CreateRubric.this,"Rubrica " + nameRubric.getText().toString() + " Agregada",Toast.LENGTH_SHORT).show();
//                    DataEntryRubric dbRubric = new DataEntryRubric(nameRubric.getText().toString());
//                    mDataEntryDAO.addDataEntryRubric(dbRubric);
//                    List<DataEntry> entryList = mDataEntryDAO.getAllEntries(DatabaseHandler.TABLE_RUBRIC);
//                    adapter.setData(entryList);
//                    listView.setAdapter(adapter);
//                    nameRubric.setText(null);
//                }
//                else {
//                    Toast.makeText(CreateRubric.this,"Campo vacío",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        builder.setView(mView);
        builder.setNegativeButton(getString(android.R.string.cancel),null);
        AlertDialog dialog= builder.create();
        dialog.show();
    }

    public void onClickEditRubricFields(View view) {
//        DataEntryRubric dataEntry = (DataEntryRubric) view.getTag();
////        String rubricName = dataEntry.get_rbcfield0();
//        Intent std_list = new Intent(CreateRubric.this, CategoryRubric.class);
////        std_list.putExtra("SubjectName", rubricName);
//        startActivity(std_list);
    }

    public void onClickBtnDeleteRubric(View view) {
        DataEntryRubric dataEntry = (DataEntryRubric) view.getTag();
        mDataEntryDAO.deleteEntryRubric(dataEntry);
        List<DataEntry> entryList = mDataEntryDAO.getAllEntries(DatabaseHandler.TABLE_RUBRIC);
        adapter.setData(entryList);
        listView.setAdapter(adapter);
    }
}