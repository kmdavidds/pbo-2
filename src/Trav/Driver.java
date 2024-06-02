package Trav;

public class Driver implements Bookable {
    private String nama;
    private int gaji;
    private boolean status;

    public Driver(String nama, int gaji, boolean status) {
        this.nama = nama;
        this.gaji = gaji;
        this.status = status;
    }

    public boolean isFree() {
        return !status;
    }

    public void book() {
        status = true;
    }

    public void setFree() {
        status = false;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getGaji() {
        return gaji;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    
}
