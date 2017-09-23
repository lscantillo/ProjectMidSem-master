package com.uninorte.projectmidsem;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private List<DataEntry> listEntries;

    public CustomAdapter(Context context, List<DataEntry> listEntries) {
        this.context = context;
        this.listEntries = listEntries;
    }

    @Override
    public int getCount() {
        return listEntries.size();
    }

    @Override
    public Object getItem(int i) {
        return listEntries.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        DataEntry entry = listEntries.get(position);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.subject_list, null);
        }

        TextView f1 = view.findViewById(R.id.tvSubjectName);

        f1.setText(String.valueOf(entry.field1));

        Log.d(CustomAdapter.class.getSimpleName(), "id " + entry.id);
        Log.d(CustomAdapter.class.getSimpleName(), "field1 " + entry.field1);

        ImageButton btnRemoveSubject = view.findViewById(R.id.btnDeleteSubject);
        btnRemoveSubject.setFocusableInTouchMode(false);
        btnRemoveSubject.setFocusable(false);
        btnRemoveSubject.setTag(entry);

        view.setTag(entry);

        return view;
    }

    public void setData(List<DataEntry> listEntries) {
        this.listEntries = listEntries;
    }
}
