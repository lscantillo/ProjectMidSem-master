package com.uninorte.projectmidsem;

public class DataEntryStd extends DataEntry {
    int idSubj;
    String stdfield0;
    String stdfield1;
    String stdfield2;
    String stdfield3;
    String stdfield4;

    public DataEntryStd() {}

    public DataEntryStd(int idSubj, String field0, String field1, String field2, String field3, String field4) {
        this.idSubj = idSubj;
        this.stdfield0 = field0;
        this.stdfield1 = field1;
        this.stdfield2 = field2;
        this.stdfield3 = field3;
        this.stdfield4 = field4;
    }

    public DataEntryStd(String field0, String field1, String field2, String field3, String field4) {
        this.stdfield0 = field0;
        this.stdfield1 = field1;
        this.stdfield2 = field2;
        this.stdfield3 = field3;
        this.stdfield4 = field4;
    }
}
