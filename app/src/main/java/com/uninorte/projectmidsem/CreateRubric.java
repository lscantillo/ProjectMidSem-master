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
    private DataEntryDAO mDataEntryDAO2;
    private String TAG = Constants.TAG;
    private ListView listView;
    private ListView listView2;
    private CustomAdapterRubric adapter;
    private CustomAdapterCategory adapter2;

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

        // Setting the adapter for the category list
        // Add new adapter for the listview inside CustomAdapterRubric -> Inflated Layout rubric_list
        View inflatedViewA = getLayoutInflater().inflate(R.layout.rubric_list, null);
        listView2 = inflatedViewA.findViewById(R.id.lvCategoryList);
        mDataEntryDAO2 = new DataEntryDAO(this);
        List<DataEntry> entryList2 = mDataEntryDAO2.getAllEntries(DatabaseHandler.TABLE_CTG);
        adapter2 = new CustomAdapterCategory(this,entryList2);
        listView2.setAdapter(adapter2);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        mDataEntryDAO.close();
        mDataEntryDAO2.close();
        super.onDestroy();
    }


    public void onClickBtnCreateRubric(View view) {
        AlertDialog.Builder builder =new AlertDialog.Builder(CreateRubric.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_rubric_name,null);
        final EditText nameRubric = mView.findViewById(R.id.etNameRubric);
        final Button btnNewRubric = mView.findViewById(R.id.btnNewRubric);
        btnNewRubric.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!nameRubric.getText().toString().isEmpty()){
                    Toast.makeText(CreateRubric.this,"Rubrica " + nameRubric.getText().toString() + " Agregada",Toast.LENGTH_SHORT).show();
                    DataEntryRubric dbRubric = new DataEntryRubric(nameRubric.getText().toString());
                    mDataEntryDAO.addDataEntryRubric(dbRubric);

                    List<DataEntry> entryList = mDataEntryDAO.getAllEntries(DatabaseHandler.TABLE_RUBRIC);
                    adapter.setData(entryList);
                    listView.setAdapter(adapter);

//                    listView2 = (ListView) findViewById(R.id.lvCategoryList);
//                    Log.d(TAG,"ListView de la categoryList " + listView2);
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


//    final EditText categNRubric = mView.findViewById(R.id.etCategoryRubric);
//    final EditText categWRubric = mView.findViewById(R.id.etCategoryWeight);
//    final EditText elemNRubric = mView.findViewById(R.id.etElementName);
//    final EditText elemWRubric = mView.findViewById(R.id.etElementWeight);
//    final EditText lvlOneRubric = mView.findViewById(R.id.etLevelOne);
//    final EditText lvlTwoRubric = mView.findViewById(R.id.etLevelTwo);
//    final EditText lvlThreeRubric = mView.findViewById(R.id.etLevelThree);
//    final EditText lvlFourRubric = mView.findViewById(R.id.etLevelFour);
//    DataEntryCategory dbCategory = new DataEntryCategory((int) index, categNRubric.getText().toString(),
//            Integer.parseInt(categWRubric.getText().toString()));
//                    mDataEntryDAO.addDataEntryCategory(dbCategory);


    public void onClickEditRubricFields(View view) {
        DataEntryRubric dataEntryA = (DataEntryRubric) view.getTag();
        final String dbRubricID = String.valueOf(dataEntryA.get_idRubric());

        // Open a Dialog to fill category name and weight
        AlertDialog.Builder builder2 = new AlertDialog.Builder(CreateRubric.this);
        View mView2 = getLayoutInflater().inflate(R.layout.dialog_rubric_category,null);
        final EditText categNRubric = mView2.findViewById(R.id.etNameCategory);
        final EditText categWRubric = mView2.findViewById(R.id.etWeightCategory);
        final Button btnNewCategory = mView2.findViewById(R.id.btnNewCategory);
        btnNewCategory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!categNRubric.getText().toString().isEmpty() && !categWRubric.getText().toString().isEmpty() ){
                    Toast.makeText(CreateRubric.this,"Categoria " + categNRubric.getText().toString() + " Agregada",Toast.LENGTH_SHORT).show();

                    Log.d(TAG,"ID Rubrica " + dbRubricID);

                    // Add category text fields to database
                    DataEntryCategory dbCategory = new DataEntryCategory( dbRubricID , categNRubric.getText().toString(),
                            categWRubric.getText().toString());
                    mDataEntryDAO2.addDataEntryCategory(dbCategory);

                    List<DataEntry> entryList2 = mDataEntryDAO2.getAllEntries(DatabaseHandler.TABLE_CTG);
                    adapter2.setData(entryList2);
                    listView2.setAdapter(adapter2);
                    Log.d(TAG,"ListView de la categoryList " + dbRubricID + " CategoryN " + categNRubric.getText().toString() + " CategoryW "+ categWRubric.getText().toString());


                    categNRubric.setText(null);
                    categWRubric.setText(null);

                }
                else {
                    Toast.makeText(CreateRubric.this,"Campo vacío",Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder2.setView(mView2);
        builder2.setNegativeButton(getString(android.R.string.cancel),null);
        AlertDialog dialog= builder2.create();
        dialog.show();


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