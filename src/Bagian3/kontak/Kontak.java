package bagian3.kontak;

public class Kontak {
    // Atribut: data yang dimiliki setiap kontak
    private String nama;
    private String nomor;
    private String email; // Tambahan Atribut Baru (No. 2)

    // Constructor: disesuaikan untuk menerima 3 parameter
    public Kontak(String nama, String nomor, String email) {
        this.nama = nama;
        this.nomor = nomor;
        this.email = email;
    }

    // Getter
    public String getNama() {
        return nama;
    }

    public String getNomor() {
        return nomor;
    }

    public String getEmail() {
        return email;
    }

    // Mengubah objek menjadi teks 3 bagian untuk disimpan ke berkas
    public String keBaris() {
        return nama + ";" + nomor + ";" + email;
    }

    // Mengembalikan keterangan kontak lengkap dengan email
    public String info() {
        return nama + " - " + nomor + " (" + email + ")";
    }
}