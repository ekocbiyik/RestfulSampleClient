package model;

import java.util.List;

/**
 * Created by enbiya on 02.05.2017.
 */
public class Personel {

    private int personelId;
    private String ad;
    private String soyad;
    private List<Araba> arabalar;

    public Personel() {
    }

    public Personel(String ad, String soyad, List<Araba> arabalar) {
        this.ad = ad;
        this.soyad = soyad;
        this.arabalar = arabalar;
    }

    public int getPersonelId() {
        return personelId;
    }

    public void setPersonelId(int personelId) {
        this.personelId = personelId;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public List<Araba> getArabalar() {
        return arabalar;
    }

    public void setArabalar(List<Araba> arabalar) {
        this.arabalar = arabalar;
    }
}
