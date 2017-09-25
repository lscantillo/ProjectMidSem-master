package com.uninorte.projectmidsem;

public class DataEntryCategory extends DataEntry {
    int idCategory;
    int catfield0;
    String catfield1;
    int catfield2;

    public DataEntryCategory() {}

    public DataEntryCategory(int id, int field0, String field1, int field2) {
        this.idCategory = id;
        this.catfield0 = field0;
        this.catfield1 = field1;
        this.catfield2 = field2;
    }

    public DataEntryCategory(int field0, String field1, int field2) {
        this.catfield0 = field0;
        this.catfield1 = field1;
        this.catfield2 = field2;
    }

    public int get_idCategory() {
        return idCategory;
    }

    public void set_idCategory(int id) {
        this.idCategory = id;
    }

    public int get_catfield0() {
        return catfield0;
    }

    public void set_catfield0(int field0) {
        this.catfield0 = field0;
    }

    public String get_catfield1() {
        return catfield1;
    }

    public void set_catfield1(String field1) {
        this.catfield1 = field1;
    }

    public int get_catfield2() {
        return catfield2;
    }

    public void set_catfield2(int field2) {
        this.catfield2 = field2;
    }


}
