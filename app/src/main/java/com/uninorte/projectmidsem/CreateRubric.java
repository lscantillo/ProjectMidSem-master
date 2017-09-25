package com.uninorte.projectmidsem;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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
    private CustomAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_rubricas, frameLayout);

        // Get the list view id from layout
        listView = (ListView) findViewById(R.id.lvRubricList);

        // Calls the function from the other java file.
        mDataEntryDAO = new DataEntryDAO(this);

        List<DataEntry> entryList = mDataEntryDAO.getAllEntries(DatabaseHandler.TABLE_RUBRIC);

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


    public void onClickBtnCreateRubric(View view) {

    }
}