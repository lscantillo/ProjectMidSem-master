package com.uninorte.projectmidsem;


import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class StudentList extends MainActivity {

    // Make private the DataEntryDAO variable.
    private DataEntryDAO mDataEntryDAO;
    private String TAG = Constants.TAG;
    private ListView listView;
    private CustomAdapterStd adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_add_student, frameLayout);
        String subjectName = getIntent().getStringExtra("SubjectName");

        Log.d(TAG, " NOMBRE MATERIA " + subjectName);

        // Get the list view id from layout
        listView = (ListView) findViewById(R.id.StudentList);

        // Calls the function from the other java file.
        mDataEntryDAO = new DataEntryDAO(this);

        // If you wanna see the complete student list without filter, uncomment the next line.
        // List<DataEntry> entryList = mDataEntryDAO.getAllEntries(DatabaseHandler.TABLE_STD);

        // Filter student list by subject name.
        List<DataEntry> entryList = mDataEntryDAO.selectStudentBySubject(DatabaseHandler.TABLE_STD, DatabaseHandler.KEY_FIELD_SUBJECT, subjectName);
        adapter = new CustomAdapterStd(this, entryList);

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

    public void onClickBtnAddStudent(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(StudentList.this);
        View eView = getLayoutInflater().inflate(R.layout.dialog_student,null);
        final String subjectName = getIntent().getStringExtra("SubjectName");
        final EditText nameStd = eView.findViewById(R.id.etNameStudent);
        final EditText codeStd = eView.findViewById(R.id.etCodeStudent);
        final EditText semStd = eView.findViewById(R.id.etSemStudent);
        final EditText mailStd = eView.findViewById(R.id.etEmailStudent);
        final Button btnNewStd = eView.findViewById(R.id.btnNewStudent);
        btnNewStd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStdText = nameStd.getText().toString();
                String codeStdText = codeStd.getText().toString();
                String semStdText = semStd.getText().toString();
                String mailStdText = mailStd.getText().toString();
                if (!nameStdText.isEmpty() && !codeStdText.isEmpty() && !semStdText.isEmpty() && !mailStdText.isEmpty()) {
                    Toast.makeText(StudentList.this,"Estudiante " + nameStdText + " Agregado",Toast.LENGTH_SHORT).show();
                    DataEntryStd dbStd = new DataEntryStd(subjectName, nameStdText, codeStdText, semStdText, mailStdText);
                    mDataEntryDAO.addDataEntryStd(dbStd);

                    // If you wanna see the complete student list without filter, uncomment the next line.
                    // List<DataEntry> entryList = mDataEntryDAO.getAllEntries(DatabaseHandler.TABLE_STD);

                    // Filter student list by subject name.
                    List<DataEntry> entryList = mDataEntryDAO.selectStudentBySubject(DatabaseHandler.TABLE_STD, DatabaseHandler.KEY_FIELD_SUBJECT, subjectName);

                    adapter.setData(entryList);
                    listView.setAdapter(adapter);
                    nameStd.setText(null);
                    codeStd.setText(null);
                    semStd.setText(null);
                    mailStd.setText(null);
                }
                else {
                    Toast.makeText(StudentList.this,"¡Debes completar todos los campos!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setView(eView);
        builder.setNegativeButton(getString(android.R.string.cancel),null);
        AlertDialog dialog= builder.create();
        dialog.show();
    }

    public void onClickBtnDeleteStudent(View view) {
        DataEntryStd dataEntry = (DataEntryStd) view.getTag();
        final String subjectName = getIntent().getStringExtra("SubjectName");
        Toast.makeText(StudentList.this,"Estudiante " + dataEntry.stdfield2 + " Eliminado",Toast.LENGTH_SHORT).show();
        mDataEntryDAO.deleteEntryStd(dataEntry);
        List<DataEntry> entryList = mDataEntryDAO.selectStudentBySubject(DatabaseHandler.TABLE_STD, DatabaseHandler.KEY_FIELD_SUBJECT, subjectName);
        adapter.setData(entryList);
        listView.setAdapter(adapter);
    }
}
