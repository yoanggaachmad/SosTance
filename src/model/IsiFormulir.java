/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lenovo
 */
public class IsiFormulir {
    String pekerjaanm;
    String Agamam;
    String NamaLengkapm;
    String NIKm;
    String KKm;
    String Alamatm;
    String RadioButn;

    public IsiFormulir(String pekerjaanm, String Agamam, String NamaLengkapm, String NIKm, String KKm, String Alamatm, String RadioButn) {
        this.pekerjaanm = pekerjaanm;
        this.Agamam = Agamam;
        this.NamaLengkapm = NamaLengkapm;
        this.NIKm = NIKm;
        this.KKm = KKm;
        this.Alamatm = Alamatm;
        this.RadioButn = RadioButn;
    }

    public String getPekerjaanm() {
        return pekerjaanm;
    }

    public void setPekerjaanm(String pekerjaanm) {
        this.pekerjaanm = pekerjaanm;
    }

    public String getAgamam() {
        return Agamam;
    }

    public void setAgamam(String Agamam) {
        this.Agamam = Agamam;
    }

    public String getNamaLengkapm() {
        return NamaLengkapm;
    }

    public void setNamaLengkapm(String NamaLengkapm) {
        this.NamaLengkapm = NamaLengkapm;
    }

    public String getNIKm() {
        return NIKm;
    }

    public void setNIKm(String NIKm) {
        this.NIKm = NIKm;
    }

    public String getKKm() {
        return KKm;
    }

    public void setKKm(String KKm) {
        this.KKm = KKm;
    }

    public String getAlamatm() {
        return Alamatm;
    }

    public void setAlamatm(String Alamatm) {
        this.Alamatm = Alamatm;
    }

    public String getRadioButn() {
        return RadioButn;
    }

    public void setRadioButn(String RadioButn) {
        this.RadioButn = RadioButn;
    }

    @Override
    public String toString() {
        return "IsiFormulir{" + "pekerjaanm=" + pekerjaanm + ", Agamam=" + Agamam + ", NamaLengkapm=" + NamaLengkapm + ", NIKm=" + NIKm + ", KKm=" + KKm + ", Alamatm=" + Alamatm + ", RadioButn=" + RadioButn + '}';
    }
    
}
