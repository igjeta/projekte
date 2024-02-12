package klinike.dentare;

import java.time.LocalDate;

public class Person {
    private String emri;
    private String mbiemri;
    private String nid;
    private LocalDate dataLindjes;

    public Person(String emri, String mbiemri, String nid, LocalDate dataLindjes) {
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.nid = nid;
        this.dataLindjes = dataLindjes;
    }


    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public LocalDate getDataLindjes() {
        return dataLindjes;
    }

    public void setDataLindjes(LocalDate dataLindjes) {
        this.dataLindjes = dataLindjes;
    }
}
