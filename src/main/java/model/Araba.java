package model;

/**
 * Created by enbiya on 02.05.2017.
 */
public class Araba {

    private int arabaId;
    private String marka;
    private String renk;

    public Araba() {
    }

    public Araba(String marka, String renk) {
        this.marka = marka;
        this.renk = renk;
    }

    public int getArabaId() {
        return arabaId;
    }

    public void setArabaId(int arabaId) {
        this.arabaId = arabaId;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    @Override
    public String toString() {
        return "{" + arabaId + " " + marka + " " + renk + "}";
    }
}


