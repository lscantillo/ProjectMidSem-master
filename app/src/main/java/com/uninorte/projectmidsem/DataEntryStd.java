package com.uninorte.projectmidsem;

public class DataEntryStd extends DataEntry {
    int idSubj;
    String field0;
    String field1;
    String field2;
    String field3;
    String field4;

    public DataEntryStd() {}

    public DataEntryStd(int idSubj, String field0, String field1, String field2, String field3, String field4) {
        this.idSubj = idSubj;
        this.field0 = field0;
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
    }

    public DataEntryStd(String field0, String field1, String field2, String field3, String field4) {
        this.field0 = field0;
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
    }
}
