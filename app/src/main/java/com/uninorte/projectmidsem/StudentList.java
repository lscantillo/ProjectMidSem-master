package com.uninorte.projectmidsem;


import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
    private CustomAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.student_list, frameLayout);

        // Get the list view id from layout
        listView = (ListView) findViewById(R.id.StudentList);

        // Calls the function from the other java file.
        mDataEntryDAO = new DataEntryDAO(this);

        List<DataEntry> entryList = mDataEntryDAO.getAllEntries();

        adapter = new CustomAdapter(this, entryList);

        listView.setAdapter(adapter);

    }

    public void onClickBtnAddStudent(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(StudentList.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_student,null);
        final EditText nameStd = mView.findViewById(R.id.etNameStudent);
        final EditText codeStd = mView.findViewById(R.id.etCodeStudent);
        final EditText semStd = mView.findViewById(R.id.etSemStudent);
        final EditText mailStd = mView.findViewById(R.id.etEmailStudent);
        final Button btnNewStd = mView.findViewById(R.id.btnAddStudent);
        btnNewStd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStdText = nameStd.getText().toString();
                String codeStdText = nameStd.getText().toString();
                String semStdText = nameStd.getText().toString();
                String mailStdText = nameStd.getText().toString();
                if (!nameStdText.isEmpty() && !codeStdText.isEmpty() && !semStdText.isEmpty() && !mailStdText.isEmpty()) {
                    Toast.makeText(StudentList.this,"Estudiante " + nameStdText + " Agregado",Toast.LENGTH_SHORT).show();
                    DataEntryStd dbStd = new DataEntryStd(nameStdText, codeStdText, semStdText, mailStdText);
                    mDataEntryDAO.addDataEntryStd(dbStd);
                    List<DataEntry> entryList = mDataEntryDAO.getAllEntries();
                    adapter.setData(entryList);
                    listView.setAdapter(adapter);
                    nameStd.setText(null);
                }
                else {
                    Toast.makeText(StudentList.this,"Campo vacío",Toast.LENGTH_SHORT).show();
                }
            }
        });
    };
}
