/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ROG
 */
public class IsiTempatUsaha {
    String provinsi;
    String kabupaten;
    String kota;
    String kecamatan;
    String kelurahan;
    String alamat;
    String tipe;

    public IsiTempatUsaha(String provinsi, String kabupaten, String kota, String kecamatan, String kelurahan, String alamat, String tipe) {
        this.provinsi = provinsi;
        this.kabupaten = kabupaten;
        this.kota = kota;
        this.kecamatan = kecamatan;
        this.kelurahan = kelurahan;
        this.alamat = alamat;
        this.tipe = tipe;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKabupaten() {
        return kabupaten;
    }

    public void setKabupaten(String kabupaten) {
        this.kabupaten = kabupaten;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    @Override
    public String toString() {
        return "IsiTempatUsaha{" + "provinsi=" + provinsi + ", kabupaten=" + kabupaten + ", kota=" + kota + ", kecamatan=" + kecamatan + ", kelurahan=" + kelurahan + ", alamat=" + alamat + ", tipe=" + tipe + '}';
    }    
}
