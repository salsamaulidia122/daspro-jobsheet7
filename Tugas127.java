import java.util.Scanner;

public class Tugas127 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int jumlahTiket, totalTiketHariIni = 0;
        double hargaTiket = 50000, totalHargaPenjualan = 0;
        String pilihan;
        
        System.out.println("=== Program Penghitungan Penjualan Tiket Bioskop ===");
        
        do {
            System.out.print("Masukkan jumlah tiket yang dibeli (atau ketik 'keluar' untuk selesai): ");
            if (sc.hasNext("keluar") || sc.hasNext("KELUAR")) {
                break;
            }
            
            if (sc.hasNextInt()) {
                jumlahTiket = sc.nextInt();
                sc.nextLine(); 
                
                if (jumlahTiket < 0) {
                    System.out.println("Jumlah tiket tidak valid! Masukkan angka positif.");
                    continue; 
                }
                
                if (jumlahTiket == 0) {
                    System.out.println("Transaksi selesai untuk pelanggan ini.\n");
                    continue;
                }
                
                double hargaTotal = jumlahTiket * hargaTiket;
                double diskon = 0;
                if (jumlahTiket > 10) {
                    diskon = 0.15; 
                } else if (jumlahTiket > 4) {
                    diskon = 0.10; 
                }
                
                double totalBayar = hargaTotal - (hargaTotal * diskon);
                totalTiketHariIni += jumlahTiket;
                totalHargaPenjualan += totalBayar;
                System.out.println("Diskon yang didapat: " + (int)(diskon * 100) + "%");
                System.out.println("Total harga untuk transaksi ini: Rp " + totalBayar);
                System.out.println("--------------------------------------------------");
                
            } else {
                System.out.println("Input tidak valid! Harap masukkan angka atau ketik 'keluar'.");
                sc.next(); 
            }
            
        } while (true);
        
        System.out.println("\n=== REKAPITULASI PENJUALAN KESELURUHAN HARI INI ===");
        System.out.println("Total seluruh tiket terjual : " + totalTiketHariIni + " tiket");
        System.out.println("Total pendapatan penjualan  : Rp " + totalHargaPenjualan);
        
        sc.close();
    }
}