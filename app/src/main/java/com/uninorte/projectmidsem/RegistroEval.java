package com.uninorte.projectmidsem;


import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by luise on 25/09/2017.
 */

public class RegistroEval extends SugarRecord {
    @Unique
    String inntentid,nombreeval,peso,rubricalink;

    public RegistroEval(String toString, String s) {
    }

    public RegistroEval(String inntentid, String nombreeval, String peso, String rubricalink) {
        this.inntentid = inntentid;
        this.nombreeval = nombreeval;
        this.peso = peso;
        this.rubricalink = rubricalink;
    }

    public String getInntentid() {
        return inntentid;
    }

    public void setInntentid(String inntentid) {
        this.inntentid = inntentid;
    }

    public String getNombreeval() {
        return nombreeval;
    }

    public void setNombreeval(String nombreeval) {
        this.nombreeval = nombreeval;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getRubricalink() {
        return rubricalink;
    }

    public void setRubricalink(String rubricalink) {
        this.rubricalink = rubricalink;
    }
}
