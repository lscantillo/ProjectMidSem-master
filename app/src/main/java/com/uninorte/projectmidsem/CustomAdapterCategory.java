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

public class CustomAdapterCategory extends BaseAdapter {
    private Context context;
    private List<DataEntry> listEntries;

    public CustomAdapterCategory(Context context, List<DataEntry> listEntries) {
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
        DataEntryCategory entry = (DataEntryCategory) listEntries.get(position);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.category_list, null);
        }

        TextView c1 = view.findViewById(R.id.tvCategoryName);
        TextView c2 = view.findViewById(R.id.tvCategoryWeight);
        TextView c3 = view.findViewById(R.id.tvCategoryRubric);

        c1.setText(String.valueOf(entry.catfield1));
        c2.setText(String.valueOf(entry.catfield2));
        c3.setText(String.valueOf(entry.catfield0));

//        Log.d(CustomAdapter.class.getSimpleName(), "id " + entry.id);
//        Log.d(CustomAdapter.class.getSimpleName(), "field1 " + entry.field1);

        ImageButton btnRemoveCategory = view.findViewById(R.id.btnDeleteCategory);
        btnRemoveCategory.setFocusableInTouchMode(false);
        btnRemoveCategory.setFocusable(false);
        btnRemoveCategory.setTag(entry);

        ImageButton btnCheckElements = view.findViewById(R.id.btnEditElementFields);
        btnCheckElements.setFocusableInTouchMode(false);
        btnCheckElements.setFocusable(false);
        btnCheckElements.setTag(entry);

        view.setTag(entry);

        System.out.println(c1.getText().toString());
        System.out.println(c2.getText().toString());
        System.out.println(c3.getText().toString());

        return view;
    }

    public void setData(List<DataEntry> listEntries) {
        this.listEntries = listEntries;
    }
}
