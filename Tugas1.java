import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Input Nama Mahasiswa : ");
        String nama = scanner.nextLine();

        System.out.print("Input NIM : ");
        String nim = scanner.nextLine();

        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        
        scanner.close();
    }
}
