package com.uninorte.projectmidsem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

// Class for executing "Create Subject" activity
public class CreateSubject extends MainActivity  {

    // Make private the DataEntryDAO variable.
    private DataEntryDAO mDataEntryDAO;
    private String TAG = Constants.TAG;
    private ListView listView;
    private CustomAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_create_subject, frameLayout);

        // Get the list view id from layout
        listView = (ListView) findViewById(R.id.lista_asignatura);

        // Calls the function from the other java file.
        mDataEntryDAO = new DataEntryDAO(this);

        List<DataEntry> entryList = mDataEntryDAO.getAllEntries(DatabaseHandler.TABLE);

        adapter = new CustomAdapter(this, entryList);

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

    public void onClickCreateSubject(View view) {
        AlertDialog.Builder builder =new AlertDialog.Builder(CreateSubject.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_subject,null);
        final EditText namesubj = mView.findViewById(R.id.etnamesubject);
        final Button btnewsubject = mView.findViewById(R.id.btn_newsubject);
        btnewsubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!namesubj.getText().toString().isEmpty()){
                    Toast.makeText(CreateSubject.this,"Asignatura " + namesubj.getText().toString() + " Agregada",Toast.LENGTH_SHORT).show();
                    DataEntry de = new DataEntry(namesubj.getText().toString());
                    mDataEntryDAO.addDataEntry(de);
                    List<DataEntry> entryList = mDataEntryDAO.getAllEntries(DatabaseHandler.TABLE);
                    adapter.setData(entryList);
                    listView.setAdapter(adapter);
                    namesubj.setText(null);
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

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == 1){
//            if (resultCode == Activity.RESULT_OK) {
//                DataEntry de = (DataEntry) data.getSerializableExtra("entry");
//                mDataEntryDAO.addDataEntry(de);
//                List<DataEntry> entryList = mDataEntryDAO.getAllEntries();
//                adapter.setData(entryList);
//                listView.setAdapter(adapter);
//            }
//        }
//    }

    public void onClickBtnDeleteSubject(View view) {
        DataEntry dataEntry = (DataEntry) view.getTag();
        Log.d(TAG,"Delete TAG " + dataEntry.id);
        mDataEntryDAO.deleteEntry(dataEntry);
        List<DataEntry> entryList = mDataEntryDAO.getAllEntries(DatabaseHandler.TABLE);
        adapter.setData(entryList);
        listView.setAdapter(adapter);
    }

    public void onClickBtnCheckStudentList(View view) {
        DataEntry dataEntry = (DataEntry) view.getTag();
        Log.d(TAG,"Selected ID ROW "+ dataEntry.field1 );
        String subjectName = dataEntry.field1;
//        DataEntry nm = mDataEntryDAO.getDataEntry(dataEntry.id, DatabaseHandler.TABLE, DatabaseHandler.KEY_ID, DatabaseHandler.KEY_FIELD1);
        Intent std_list = new Intent(CreateSubject.this, StudentList.class);
        std_list.putExtra("SubjectName", subjectName);
        startActivity(std_list);
    }


}
