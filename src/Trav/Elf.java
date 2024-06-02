package Trav;

import java.util.HashMap;

public class Elf extends Kendaraan {
    private final int kapasitas = 9;
    public HashMap<String, String> kursi;

    public Elf(String idKendaraan, String platNomor) {
        this.idKendaraan = idKendaraan;
        this.platNomor = platNomor;
        this.status = false;
        this.kursi = new HashMap<>();
        for (int i = 1; i <= kapasitas; i++) {
            kursi.put(Integer.toString(i), "kosong");
        }
    }

    public Elf(String idKendaraan, String platNomor, boolean status) {
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
