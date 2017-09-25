package com.uninorte.projectmidsem;

public class DataEntryRubric extends DataEntry {
    int idRubric;
    String rbcfield0;

    public DataEntryRubric() {}

    public DataEntryRubric(int id, String field0) {
        this.idRubric = id;
        this.rbcfield0 = field0;
    }

    public DataEntryRubric(String field0) {
        this.rbcfield0 = field0;
    }

    public int get_idRubric() {
        return idRubric;
    }

    public void set_idRubric(int id) {
        this.idRubric = id;
    }

    public String get_rbcfield0() {
        return rbcfield0;
    }

    public void set_rbcfield0(String field0) {
        this.rbcfield0 = field0;
    }
}
