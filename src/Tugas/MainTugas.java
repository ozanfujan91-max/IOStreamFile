package tugas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

// ==========================================
// 1. CLASS BARANG (Class Model)
// ==========================================
class Barang {
    private String nama;
    private double harga;
    private int stok;

    // Constructor
    public Barang(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter
    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // Format teks untuk disimpan ke berkas teks (dipisah menggunakan ';')
    public String keBaris() {
        return nama + ";" + harga + ";" + stok;
    }

    // Mengembalikan keterangan barang untuk ditampilkan di layar
    public String info() {
        return nama + " - Harga: Rp" + harga + " | Stok: " + stok;
    }
}

// ==========================================
// 2. CLASS GUDANG (Class Pengelola)
// ==========================================
class Gudang {
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private String namaBerkas;

    public Gudang(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    // Menambahkan objek Barang ke koleksi ArrayList
    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    // Menampilkan seluruh isi koleksi gudang beserta nomor urut
    public void tampilkanSemua() {
        if (daftarBarang.isEmpty()) {
            System.out.println("(Gudang Kosong)");
        } else {
            for (int i = 0; i < daftarBarang.size(); i++) {
                System.out.println((i + 1) + ". " + daftarBarang.get(i).info());
            }
        }
    }

    // Menyimpan data barang ke berkas eksternal
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Barang b : daftarBarang) {
                penulis.println(b.keBaris());
            }
            System.out.println("Sistem: Data barang berhasil disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Sistem Error [Simpan]: " + e.getMessage());
        }
    }

    // Memuat ulang data barang dari berkas teks ke dalam memori ArrayList
    public void muatDariBerkas() {
        daftarBarang.clear(); // Bersihkan memori sebelum memuat data dari file
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) {
                    String nama = bagian[0];
                    double harga = Double.parseDouble(bagian[1]);
                    int stok = Integer.parseInt(bagian[2]);
                    daftarBarang.add(new Barang(nama, harga, stok));
                }
            }
            System.out.println("Sistem: Data berhasil dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Sistem Error [Muat]: " + e.getMessage());
        }
    }

    // Menghitung total nilai aset persediaan (Harga dikali Stok dari seluruh barang)
    public double totalNilai() {
        double total = 0;
        for (Barang b : daftarBarang) {
            total += b.getHarga() * b.getStok();
        }
        return total;
    }
}

// ==========================================
// 3. CLASS MAINTUGAS (Main Runner Class)
// ==========================================
public class MainTugas {
    public static void main(String[] args) {
        
        // Kebutuhan Tambahan 1: Array Kategori Berukuran Tetap (Minimal 3)
        String[] kategori = {"Elektronik", "Pakaian", "Makanan & Minuman", "Alat Tulis"};
        
       
        for (int i = 0; i < kategori.length; i++) {
            System.out.println("- " + kategori[i]);
        }
        System.out.println();

        // Kebutuhan Utama: Membuat objek Gudang pertama untuk input data
        
        Gudang gudangPusat = new Gudang("barang.txt");

        // Menambahkan minimal 5 objek barang ke gudang
        gudangPusat.tambahBarang(new Barang("Laptop ASUS", 8500000, 10));
        gudangPusat.tambahBarang(new Barang("Mouse Wireless", 150000, 25));
        gudangPusat.tambahBarang(new Barang("Keyboard Mekanik", 450000, 15));
        gudangPusat.tambahBarang(new Barang("Monitor LED", 1750000, 8));
        gudangPusat.tambahBarang(new Barang("Printer Inkjet", 1200000, 5));

        // Menampilkan data awal dan menyimpannya ke berkas
        gudangPusat.tampilkanSemua();
        gudangPusat.simpanKeBerkas();
        System.out.println();

        // Kebutuhan Tambahan 3: Membuat objek Gudang baru untuk pembuktian
        
        Gudang gudangBaru = new Gudang("barang.txt");
        
        // Memuat kembali data yang tersimpan di dalam file barang.txt
        gudangBaru.muatDariBerkas();
        
        // Menampilkan seluruh data yang berhasil dibaca ulang
        gudangBaru.tampilkanSemua();
        
        // Menampilkan akumulasi total nilai persediaan barang gudang
        System.out.println("Total Nilai Persediaan Barang: Rp" + gudangBaru.totalNilai());
    }
}