package com.uninorte.projectmidsem;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapterStudentList extends BaseAdapter {
    private Context context;
    private List<DataEntry> listEntries;

    public CustomAdapterStudentList(Context context, List<DataEntry> listEntries) {
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
        DataEntryStd entry = (DataEntryStd) listEntries.get(position);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.student_card, null);
        }

        TextView f1 = view.findViewById(R.id.tvStudentFullName);
        TextView f2 = view.findViewById(R.id.tvStudentCode);
        TextView f3 = view.findViewById(R.id.tvStudentSemester);
        TextView f4 = view.findViewById(R.id.tvStudentMail);

        f1.setText(String.valueOf(entry.stdfield1));
        f2.setText(String.valueOf(entry.stdfield2));
        f3.setText(String.valueOf(entry.stdfield3));
        f4.setText(String.valueOf(entry.stdfield4));

        view.setTag(entry);

        return view;
    }

    public void setData(List<DataEntry> listEntries) {
        this.listEntries = listEntries;
    }
}

