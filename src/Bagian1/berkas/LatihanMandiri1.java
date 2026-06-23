package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanMandiri1 {

    public static void main(String[] args) {

        // SOAL 1
        File laporan = new File("laporan.txt");

        
        System.out.println("Apakah laporan.txt ada? " + laporan.exists());

        if (laporan.exists()) {
            System.out.println("Ukuran berkas : " + laporan.length() + " byte");
        }

        // SOAL 2
        

        File arsip = new File("arsip");

        if (arsip.mkdir()) {
            System.out.println("Folder arsip berhasil dibuat.");
        } else {
            System.out.println("Folder arsip gagal dibuat atau sudah ada.");
        }

        // SOAL 3
    

        try {

            File sementara = new File("sementara.txt");

            sementara.createNewFile();

            System.out.println("Sebelum dihapus : "
                    + sementara.exists());

            sementara.delete();

            System.out.println("Sesudah dihapus : "
                    + sementara.exists());

        } catch (IOException e) {

            System.out.println("Terjadi kesalahan : "
                    + e.getMessage());

        }
    }
}