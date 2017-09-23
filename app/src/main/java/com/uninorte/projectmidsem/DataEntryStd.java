package com.uninorte.projectmidsem;

public class DataEntryStd {
    String idSubj;
    String field1;
    String field2;
    String field3;
    String field4;

    public DataEntryStd() {}

    public DataEntryStd(String idSubj, String field1, String field2, String field3, String field4) {
        this.idSubj = idSubj;
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
    }

    public DataEntryStd(String field1, String field2, String field3, String field4) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
    }
}
