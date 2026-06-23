package bagian2.bacatulis;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class LatihanMandiri2 {
    public static void main(String[] args) {
        
        
        String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};
        
        // Menulis awal ke berkas hari.txt
        try (PrintWriter penulis = new PrintWriter(new FileWriter("hari.txt"))) {
            for (String h : hari) {
                penulis.println(h);
            }
            System.out.println("Data awal berhasil ditulis ke hari.txt.");
        } catch (IOException e) {
            System.out.println("Gagal menulis: " + e.getMessage());
        }

        // Membaca kembali isi hari.txt
        bacaDanTampilkanFile();


        
        // Menambahkan (append) Sabtu dan Minggu tanpa menghapus isi sebelumnya
        try (PrintWriter penulis = new PrintWriter(new FileWriter("hari.txt", true))) {
            penulis.println("Sabtu");
            penulis.println("Minggu");
            System.out.println("Berhasil menambahkan Sabtu dan Minggu.");
        } catch (IOException e) {
            System.out.println("Gagal menambah data: " + e.getMessage());
        }

        // Membaca kembali setelah di-append
        bacaDanTampilkanFile();


        
        int jumlah = 0;
        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            while (pembaca.readLine() != null) {
                jumlah++;
            }
            System.out.println("Jumlah seluruh baris di dalam berkas: " + jumlah);
        } catch (IOException e) {
            System.out.println("Gagal membaca: " + e.getMessage());
        }
    }

    // Helper method untuk membaca berkas hari.txt agar tidak menulis ulang kodenya
    private static void bacaDanTampilkanFile() {
        try (BufferedReader pembaca = new BufferedReader(new FileReader("hari.txt"))) {
            String baris;
            System.out.println("--- Isi berkas hari.txt saat ini ---");
            while ((baris = pembaca.readLine()) != null) {
                System.out.println(baris);
            }
            System.out.println("------------------------------------");
        } catch (IOException e) {
            System.out.println("Gagal membaca berkas: " + e.getMessage());
        }
    }
}