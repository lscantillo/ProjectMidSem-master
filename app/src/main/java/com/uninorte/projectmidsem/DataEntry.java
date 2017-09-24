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

    public int get_id() {
        return id;
    }

    public void set_id(int id) {
        this.id = id;
    }

    public String get_field1() {
        return field1;
    }

    public void set_field1(String field1) {
        this.field1 = field1;
    }

}