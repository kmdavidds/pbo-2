package Trav;

import java.util.HashMap;

public class Minibus extends Kendaraan {
    private final int kapasitas = 20;
    public HashMap<String, String> kursi;

    public Minibus(String idKendaraan, String platNomor) {
        this.idKendaraan = idKendaraan;
        this.platNomor = platNomor;
        this.status = false;
        this.kursi = new HashMap<>();
        for (int i = 1; i <= kapasitas; i++) {
            kursi.put(Integer.toString(i), "kosong");
        }
    }

    public Minibus(String idKendaraan, String platNomor, boolean status) {
        this.idKendaraan = idKendaraan;
        this.platNomor = platNomor;
        this.status = status;
        this.kursi = new HashMap<>();
        for (int i = 1; i <= kapasitas; i++) {
            kursi.put(Integer.toString(i), "kosong");
        }
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public int getSisaKursi() {
        int sisa = kapasitas;
        for (String key : kursi.keySet()) {
            if (kursi.get(key).equals("kosong")) {
                sisa--;
            }
        }
        return sisa;
    }
}
