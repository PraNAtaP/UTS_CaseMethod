import java.util.*;
//Pranata
public class SiakadMain19 {
    static Scanner input19 = new Scanner(System.in);
    static DataSiakad19 data19 = new DataSiakad19();

    public static void main(String[] args) {
        data19.tambahMK19(new MataKuliah19("ALSD19", "ALSD", 3));
        data19.tambahMK19(new MataKuliah19("MATL19", "Matematika", 2));

        int menu;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Input Data Mahasiswa,Matkul, dan Nilai");
            System.out.println("2. Tampilkan Daftar Mahasiswa");
            System.out.println("3. Tampilkan Daftar Mata Kuliah");
            System.out.println("4. Tampilkan Penilaian");
            System.out.println("5. Urutkan Mahasiswa berdasarkan Nama");
            System.out.println("6. Urutkan Penilaian berdasarkan Nilai Akhir");
            System.out.println("7. Cari Mahasiswa berdasarkan Nama");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu: ");
            menu = input19.nextInt();
            input19.nextLine();

            switch (menu) {
                case 1:
                    menuInput19();
                    break;
                case 2:
                    data19.tampilMhs19();
                    break;
                case 3:
                    data19.tampilMk19();
                    break;
                case 4:
                    data19.tampilPenilaian19();
                    break;
                case 5:
                    menuSortNama19();
                    break;
                case 6:
                    menuSortNilai19();
                    break;
                case 7:
                    menuSearch19();
                    break;
                case 0:
                    System.out.println("Terima Kasih!");
                    break;
                default:
                    System.out.println("Pilihan gak valid");
            }
        } while (menu != 0);
        input19.close();
    }

    static void menuInput19() {
        while (true) {
            System.out.print("Masukkan Nama Mahasiswa : "); String nama = input19.nextLine();
            System.out.print("Masukkan NIM : "); String nim = input19.nextLine();
            System.out.print("Masukkan Prodi : "); String prodi = input19.nextLine();
            Mahasiswa19 m = new Mahasiswa19(nama, nim, prodi);
            data19.tambahMHS19(m);

            MataKuliah19 mk;
            while (true) {
                data19.tampilMk19();
                System.out.print("Pilih Kode MK : ");
                String kode = input19.nextLine();
                mk = data19.cariMatkuldariKode19(kode);
                if (mk != null) break;
                System.out.println("Kode MK tidak valid. Coba lagi!");
            }

            System.out.print("Nilai Tugas : "); double tugas = input19.nextDouble();
            System.out.print("Nilai UTS : "); double uts = input19.nextDouble();
            System.out.print("Nilai UAS : "); double uas = input19.nextDouble();
            input19.nextLine();
            data19.tambahPenilaian19(new Penilaian19(m, mk, tugas, uts, uas));

            String lagi;
            while (true) {
                System.out.print("Tambah data lagi? (Y/N) : ");
                lagi = input19.nextLine();
                if (lagi.equalsIgnoreCase("Y")) break;
                if (lagi.equalsIgnoreCase("N")) return;
                System.out.println("Input tidak valid! Masukkan Y atau N.");
            }
        }
    }

    static void menuSortNama19() {
        System.out.println("Pilih Menu tipe Sorting ");
        System.out.println("1. ASC ");
        System.out.println("2. DSC ");
        System.out.print("Silahkan :");
        int t = input19.nextInt();
        input19.nextLine();
        data19.sortMhsdariNama19(t == 1);
        data19.tampilMhs19();
    }

    static void menuSortNilai19() {
        System.out.println("Pilih Menu tipe Sorting ");
        System.out.println("1. ASC ");
        System.out.println("2. DSC ");
        System.out.print("Silahkan :");
        int t = input19.nextInt();
        input19.nextLine();
        data19.sortPenDariNilai19(t == 1);
        data19.tampilPenilaian19();
    }

    static void menuSearch19() {
        System.out.print("Masukkan Nama yang dicari : ");
        String target = input19.nextLine();
        int idx = data19.binarySearchMhs19(target);
        if (idx >= 0)
            System.out.println("Data ditemukan di index " + idx);
        else
            System.out.println("Data tidak ada di database");
    }
}
