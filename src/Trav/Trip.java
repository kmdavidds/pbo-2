/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trav;

/**
 *
 * @author kmdav
 */
public class Trip {
    private String asal;
    private String tujuan;
    private String tanggal;
    private int harga;
    private Kendaraan kendaraan;
    private Driver driver;
    private String kode;

    public Trip(String asal, String tujuan, String tanggal, int harga, Kendaraan kendaraan, Driver driver) {
        this.asal = asal;
        this.tujuan = tujuan;
        this.tanggal = tanggal;
        this.harga = harga;
        this.kendaraan = kendaraan;
        this.driver = driver;
        this.kode = generateCode();
    }
    
    public String generateCode() {
        String res = "";
        asal = asal.toUpperCase();
        tujuan = tujuan.toUpperCase();
        for (int i = 0; i < 3; i++) {
            res += asal.charAt(i);
        }
        res += "-";
        for (int i = 0; i < 3; i++) {
            res += tujuan.charAt(i);
        }
        res += "_";
        String[] splitTanggal = tanggal.split("/");
        for (String string : splitTanggal) {
            res += string;
        }
        return res;
    }

    public String generateVerbose() {
        String res = "";
        res += asal + " -> ";
        res += tujuan + " ";
        res += "*" + tanggal + "* ";
        res += "Rp. " + harga;
        // res += " (" + kendaraan.getPlatNomor() + ") ";
        // res += "[" + driver.getNama() + "] ";
        res += " (Kapasitas: ";
        if (kendaraan instanceof Minibus) {
            res += ((Minibus) kendaraan).getSisaKursi() + "/" + ((Minibus) kendaraan).getKapasitas();
        } else if (kendaraan instanceof Elf) {
            res += ((Elf) kendaraan).getSisaKursi() + "/" + ((Elf) kendaraan).getKapasitas();
        } 
        res += ")";
        return res;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }
}
