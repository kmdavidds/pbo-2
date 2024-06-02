/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Trav;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kmdav
 */
public class Storage {
    public ArrayList<Penumpang> p;
    public ArrayList<Trip> t;
    public ArrayList<Driver> d;
    public ArrayList<Minibus> m;
    public ArrayList<Elf> el;
    public ArrayList<String> l;
    public ArrayList<String> o;
    
    public Storage() {
        p = new ArrayList<>();
        t = new ArrayList<>();
        d = new ArrayList<>();
        m = new ArrayList<>();
        el = new ArrayList<>();
        l = new ArrayList<>();
        readP();
        readD();
        readMinibus();
        readElf();
        readL();
        readT();
    }

    public Kendaraan getKendaraan(String platNomor) {
        platNomor = platNomor.trim();
        for (Minibus minibus : m) {
            if (minibus.platNomor.equalsIgnoreCase(platNomor)) {
                return minibus;
            }
        }
        for (Elf elf : el) {
            if (elf.platNomor.equalsIgnoreCase(platNomor)) {
                return elf;
            }
        }
        return null;
    }

    public Driver getDriver(String nama) {
        nama = nama.trim();
        for (Driver driver : d) {
            if (driver.getNama().equalsIgnoreCase(nama)) {
                return driver;
            }
        }
        return null;
    }

    public void readP() {
        try {
            File file = new File("penumpang.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split("\\$");
                String nama = data[0];
                String jenisKelamin = data[1];
                String tempatDuduk = data[2];
                long saldo = Long.parseLong(data[3]);
                String id = data[4];
                String password = data[5];
                ArrayList<Trip> orders = new ArrayList<>();
                if (data.length > 6) {
                    String[] ordersData = data[6].split("&&");
                    for (String order : ordersData) {
                        for (Trip trip : t) {
                            if (trip.getKode().equals(order)) {
                                orders.add(trip);
                            }
                        }
                    }
                }
                Penumpang penumpang = new Penumpang(nama, jenisKelamin, tempatDuduk, saldo, id, password);
                penumpang.orders = orders;
                p.add(penumpang);
            }
            scanner.close();
            System.out.println("Successfully read from the file.");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readL() {
        try {
            File file = new File("location.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String location = scanner.nextLine();
                l.add(location);
            }
            scanner.close();
            System.out.println("Successfully read from the file.");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readD() {
        try {
            File file = new File("driver.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split("\\$");
                String nama = data[0];
                nama = nama.trim();
                int gaji = Integer.parseInt(data[1]);
                boolean status = Boolean.parseBoolean(data[2]);
                Driver driver = new Driver(nama, gaji, status);
                d.add(driver);
            }
            scanner.close();
            System.out.println("Successfully read from the file.");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readMinibus() {
        try {
            File file = new File("minibus.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split("\\$");
                String idKendaraan = data[0];
                String platNomor = data[1].trim();
                boolean status = Boolean.parseBoolean(data[2]);
                Minibus minibus = new Minibus(idKendaraan, platNomor, status);
                m.add(minibus);
            }
            scanner.close();
            System.out.println("Successfully read from the file.");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readElf() {
        try {
            File file = new File("elf.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split("\\$");
                String idKendaraan = data[0];
                String platNomor = data[1].trim();
                boolean status = Boolean.parseBoolean(data[2]);
                Elf elf = new Elf(idKendaraan, platNomor, status);
                el.add(elf);
            }
            scanner.close();
            System.out.println("Successfully read from the file.");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readT() {
        try {
            File file = new File("trip.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split("\\$");
                String asal = data[0];
                String tujuan = data[1];
                String tanggal = data[2];
                int harga = Integer.parseInt(data[3]);
                Kendaraan kendaraan = getKendaraan(data[4]);
                int sisaKursi = Integer.parseInt(data[5]);
                Driver driver = getDriver(data[6]);
                Trip trip = new Trip(asal, tujuan, tanggal, harga, kendaraan, sisaKursi, driver);
                t.add(trip);
            }
            scanner.close();
            System.out.println("Successfully read from the file.");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readOrders() {
        try {
            File file = new File("orders.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split("\\$");
                String id = data[0];
                Penumpang penumpang = null;
                for (Penumpang penumpang1 : p) {
                    if (penumpang1.getId().equals(id)) {
                        penumpang = penumpang1;
                    }
                }
                ArrayList<Trip> orders = new ArrayList<>();
                String[] ordersData = data[1].split("&&");
                for (String order : ordersData) {
                    for (Trip trip : t) {
                        if (trip.getKode().equals(order)) {
                            orders.add(trip);
                        }
                    }
                }
                penumpang.orders = orders;
            }
            scanner.close();
            System.out.println("Successfully read from the file.");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void addP(Penumpang pn) {
        try {
            FileWriter writer = new FileWriter("penumpang.txt", true);
            String result = "";
            result += pn.getNama();
            result += "$";
            result += pn.getJenisKelamin();
            result += "$";
            result += pn.getTempatDuduk();
            result += "$";
            result += Long.toString(pn.getSaldo());
            result += "$";
            result += pn.getId();
            result += "$";
            result += pn.getPassword();
            result += "$";
            result += "\n";
            writer.write(result);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void addL(String location) {
        try {
            FileWriter writer = new FileWriter("location.txt", true);
            String result = "";
            result += location;
            result += "\n";
            writer.write(result);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void addD(Driver dr) {
        try {
            FileWriter writer = new FileWriter("driver.txt", true);
            String result = "";
            result += dr.getNama();
            result += "$";
            result += Integer.toString(dr.getGaji());
            result += "$";
            result += Boolean.toString(!dr.isFree());
            result += "$";
            result += "\n";
            writer.write(result);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void addMinibus(Minibus mb) {
        try {
            FileWriter writer = new FileWriter("minibus.txt", true);
            String result = "";
            result += mb.idKendaraan;
            result += "$";
            result += mb.platNomor;
            result += "$";
            result += Boolean.toString(mb.status);
            result += "$"; 
            result += "\n";
            writer.write(result);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void addElf(Elf e) {
        try {
            FileWriter writer = new FileWriter("elf.txt", true);
            String result = "";
            result += e.idKendaraan;
            result += "$";
            result += e.platNomor;
            result += "$";
            result += Boolean.toString(e.status);
            result += "$";
            result += "\n";
            writer.write(result);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }
    }

    public void addTrip(Trip tr) {
        try {
            FileWriter writer = new FileWriter("trip.txt", true);
            String result = "";
            result += tr.getAsal();
            result += "$";
            result += tr.getTujuan();
            result += "$";
            result += tr.getTanggal();
            result += "$";
            result += Integer.toString(tr.getHarga());
            result += "$";
            if (tr.getKendaraan() instanceof Minibus) {
                Minibus mb = (Minibus) tr.getKendaraan();
                result += mb.platNomor;
                result += "$";
                result += mb.getSisaKursi();
                result += "$";
            } else {
                Elf e = (Elf) tr.getKendaraan();
                result += e.platNomor;
                result += "$";
                result += e.getSisaKursi();
                result += "$";
            }
            result += tr.getDriver().getNama();
            result += "$";
            result += tr.getKode();
            result += "$";
            result += "\n";
            writer.write(result);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void addOrders(Penumpang pn, String tr) {
        try {
            FileWriter writer = new FileWriter("orders.txt", true);
            String result = "";
            result += pn.getId();
            result += "$";
            result += tr;
            result += "$";
            result += "\n";
            writer.write(result);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
