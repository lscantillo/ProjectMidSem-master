package com.uninorte.projectmidsem;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

// Class for student list by user at MainActivity / Subject / SubItem 2
public class StudentListByUser extends MainActivity {
    // Make private the DataEntryDAO variable.
    private DataEntryDAO mDataEntryDAO;
    private String TAG = Constants.TAG;
    private ListView listView;
    private CustomAdapterStudentList adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_student_user, frameLayout);

        // Get the list view id from layout
        listView = (ListView) findViewById(R.id.lvStudentListByUser);

        // Calls the function from the other java file.
        mDataEntryDAO = new DataEntryDAO(this);

        List<DataEntry> entryList = mDataEntryDAO.getAllEntries(DatabaseHandler.TABLE_STD);

        adapter = new CustomAdapterStudentList(this, entryList);

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

    public void onClickBtnEditStudentListBU(View view) {

    }
}
