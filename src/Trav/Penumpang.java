package Trav;

import java.util.ArrayList;

public class Penumpang {
    private String nama;
    private String jenisKelamin;
    private String tempatDuduk;
    private long saldo;
    private String id;
    private String password;
    public ArrayList<Trip> orders;
    public boolean banned;

    public Penumpang(String nama, String jenisKelamin, String tempatDuduk, long saldo, String id, String password) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.tempatDuduk = tempatDuduk;
        this.saldo = saldo;
        this.id = id;
        this.password = password;
        this.orders = new ArrayList<>();
        this.banned = false;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTempatDuduk() {
        return tempatDuduk;
    }

    public void setTempatDuduk(String tempatDuduk) {
        this.tempatDuduk = tempatDuduk;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
