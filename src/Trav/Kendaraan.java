package Trav;

public abstract class Kendaraan implements Bookable {
    protected String idKendaraan;
    protected String platNomor;
    protected boolean status;

    public boolean isFree() {
        return !status;
    }

    public void book() {
        status = true;
    }

    public void setFree() {
        status = false;
    }

    public String getIdKendaraan() {
        return idKendaraan;
    }

    public void setIdKendaraan(String idKendaraan) {
        this.idKendaraan = idKendaraan;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }
}