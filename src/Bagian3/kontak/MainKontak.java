package bagian3.kontak;

public class MainKontak {
    public static void main(String[] args) {
        // 1. Membuat data awal dengan email baru
        BukuKontak buku = new BukuKontak("kontak.txt");
        buku.tambahKontak(new Kontak("Andi", "0811111", "andi@email.com"));
        buku.tambahKontak(new Kontak("Budi", "0822222", "budi@email.com"));
        buku.tambahKontak(new Kontak("Citra", "0833333", "citra@email.com"));
        
        buku.tampilkanSemua();
        buku.simpanKeBerkas();
        
        System.out.println("\n=== PENGUJIAN NO 1: CARI KONTAK ===");
        buku.cariKontak("Budi");  // Skenario: Ada
        buku.cariKontak("Dewi");  // Skenario: Tidak ada
        
        System.out.println("\n=== PENGUJIAN NO 3: HAPUS KONTAK ===");
        buku.hapusKontak("Andi"); // Menghapus Andi dan otomatis update file berkas
        
        System.out.println("\n=== MEMBUAT OBJEK BARU & MUAT DARI FILE ===");
        // Memastikan file kontak.txt yang diperbarui bisa dibaca ulang dengan benar
        BukuKontak bukuBaru = new BukuKontak("kontak.txt");
        bukuBaru.muatDariBerkas();
        bukuBaru.tampilkanSemua();
        System.out.println("Jumlah kontak saat ini: " + bukuBaru.jumlahKontak());
    }
}