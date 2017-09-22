package com.uninorte.projectmidsem;

public class DataEntry {
    int id;
    String field1;

    public DataEntry() {}

    public DataEntry(int id, String field1) {
        this.id = id;
        this.field1 = field1;
    }

    public DataEntry(String field1) {
        this.field1 = field1;
    }
}
