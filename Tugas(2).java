import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class tgs2 {
    // Map 
    private static Map<String, String> mahasiswaMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Daftar Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Update Data Mahasiswa");
            System.out.println("4. Hapus Data Mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilihan: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    createMahasiswa();
                    break;
                case 2:
                    readMahasiswa();
                    break;
                case 3:
                    updateMahasiswa();
                    break;
                case 4:
                    deleteMahasiswa();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silahkan coba lagi ya.");
            }
        } while (choice != 5);
    }

    // Create
    private static void createMahasiswa() {
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        if (mahasiswaMap.containsKey(nim)) {
            System.out.println("Mahasiswa dengan NIM tersebut sudah terdaftar.");
        } else {
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            mahasiswaMap.put(nim, nama);
            System.out.println("Mahasiswa berhasil ditambahkan.");
        }
    }

    // Read
    private static void readMahasiswa() {
        if (mahasiswaMap.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa.");
        } else {
            System.out.println("Data Mahasiswa:");
            for (Map.Entry<String, String> entry : mahasiswaMap.entrySet()) {
                System.out.println("NIM: " + entry.getKey() + ", Nama: " + entry.getValue());
            }
        }
    }

    // Update
    private static void updateMahasiswa() {
        System.out.print("Masukkan NIM yang ingin diupdate: ");
        String nim = scanner.nextLine();
        if (mahasiswaMap.containsKey(nim)) {
            System.out.print("Masukkan Nama baru: ");
            String namaBaru = scanner.nextLine();
            mahasiswaMap.put(nim, namaBaru);
            System.out.println("Data mahasiswa berhasil diupdate.");
        } else {
            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
        }
    }

    // Delete
    private static void deleteMahasiswa() {
        System.out.print("Masukkan NIM yang ingin dihapus: ");
        String nim = scanner.nextLine();
        if (mahasiswaMap.containsKey(nim)) {
            mahasiswaMap.remove(nim);
            System.out.println("Mahasiswa berhasil dihapus.");
        } else {
            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
        }
    }
}