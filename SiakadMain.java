import java.util.*;
//Pranata
public class SiakadMain {
    static Scanner input19 = new Scanner(System.in);
    static DataSiakad data19 = new DataSiakad();

    public static void main(String[] args) {
        data19.tambah(new MataKuliah("BD19", "Basis Data", 3));
        data19.tambah(new MataKuliah("ALSD19", "ALSD", 3));
        data19.tambah(new MataKuliah("MATL19", "Matematika", 2));

        int menu;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Input Data Mahasiswa + Penilaian");
            System.out.println("2. Tampilkan Daftar Mahasiswa");
            System.out.println("3. Tampilkan Daftar Mata Kuliah");
            System.out.println("4. Tampilkan Penilaian");
            System.out.println("5. Urutkan Mahasiswa by Nama");
            System.out.println("6. Urutkan Penilaian by Nilai Akhir");
            System.out.println("7. Cari Mahasiswa by Nama");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu: ");
            menu = input19.nextInt();
            input19.nextLine();

            switch (menu) {
                case 1:
                    menuInput();
                    break;
                case 2:
                    data19.tampilMhs();
                    break;
                case 3:
                    data19.tampilMk();
                    break;
                case 4:
                    data19.tampilPenilaian();
                    break;
                case 5:
                    menuSortName();
                    break;
                case 6:
                    menuSortNilai();
                    break;
                case 7:
                    menuSearch();
                    break;
                case 0:
                    System.out.println("Bye bro");
                    break;
                default:
                    System.out.println("Pilihan gak valid");
            }
        } while (menu != 0);
        input19.close();
    }

    static void menuInput() {
        while (true) {
            System.out.print("Masukkan Nama Mahasiswa: "); String nama = input19.nextLine();
            System.out.print("Masukkan NIM: "); String nim = input19.nextLine();
            System.out.print("Masukkan Prodi: "); String prodi = input19.nextLine();
            Mahasiswa m = new Mahasiswa(nama, nim, prodi);
            data19.tambah(m);

            MataKuliah mk;
            while (true) {
                data19.tampilMk();
                System.out.print("Pilih Kode MK (e.g. BD19): ");
                String kode = input19.nextLine();
                mk = data19.cariMatkulByKode(kode);
                if (mk != null) break;
                System.out.println("Kode MK tidak valid. Coba lagi!");
            }

            System.out.print("Nilai Tugas: "); double tugas = input19.nextDouble();
            System.out.print("Nilai UTS: "); double uts = input19.nextDouble();
            System.out.print("Nilai UAS: "); double uas = input19.nextDouble();
            input19.nextLine();
            data19.tambah(new Penilaian(m, mk, tugas, uts, uas));

            String lagi;
            while (true) {
                System.out.print("Tambah data lagi? (Y/N): ");
                lagi = input19.nextLine();
                if (lagi.equalsIgnoreCase("Y")) break;
                if (lagi.equalsIgnoreCase("N")) return;
                System.out.println("Input tidak valid! Masukkan Y atau N.");
            }
        }
    }

    static void menuSortName() {
        System.out.print("1. ASC  2. DESC: ");
        int t = input19.nextInt();
        input19.nextLine();
        data19.sortMhsByName(t == 1);
        data19.tampilMhs();
    }

    static void menuSortNilai() {
        System.out.print("1. ASC  2. DESC: ");
        int t = input19.nextInt();
        input19.nextLine();
        data19.sortPenByNilai(t == 1);
        data19.tampilPenilaian();
    }

    static void menuSearch() {
        System.out.print("Masukkan Nama yang dicari: ");
        String target = input19.nextLine();
        int idx = data19.binarySearchMhs(target);
        if (idx >= 0)
            System.out.println("Data ditemukan di index " + idx);
        else
            System.out.println("Data tidak ada di database");
    }
}
