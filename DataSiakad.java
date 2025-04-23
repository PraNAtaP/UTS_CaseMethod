import java.util.*;

//Pranata
public class DataSiakad {
    List<Mahasiswa> dataMhs19 = new ArrayList<>();
    List<MataKuliah> dataMk19 = new ArrayList<>();
    List<Penilaian> dataPenilaian19 = new ArrayList<>();

    void tambah(Mahasiswa m) {
        dataMhs19.add(m);
    }

    void tambah(MataKuliah m) {
        dataMk19.add(m);
    }

    void tambah(Penilaian p) {
        dataPenilaian19.add(p);
    }

    void tampilMhs() {
        System.out.println("\n=== Daftar Mahasiswa ===");
        for (Mahasiswa m : dataMhs19)
            m.tampilMahasiswa();
    }

    void tampilMk() {
        System.out.println("\n=== Daftar Mata Kuliah ===");
        for (MataKuliah mk : dataMk19)
            mk.tampilMatakuliah();
    }

    void tampilPenilaian() {
        System.out.println("\n=== Data Penilaian ===");
        for (Penilaian p : dataPenilaian19)
            p.tampilPenilaian();
    }

    MataKuliah cariMatkulByKode(String kode) {
        for (MataKuliah mk : dataMk19) {
            if (mk.kodeMK19.equalsIgnoreCase(kode))
                return mk;
        }
        return null;
    }

    void sortMhsByName(boolean asc) {
        int n = dataMhs19.size();
        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (asc ? dataMhs19.get(j).nama19.compareToIgnoreCase(dataMhs19.get(idx).nama19) < 0
                        : dataMhs19.get(j).nama19.compareToIgnoreCase(dataMhs19.get(idx).nama19) > 0) {
                    idx = j;
                }
            }
            Collections.swap(dataMhs19, i, idx);
        }
    }

    void sortPenByNilai(boolean asc) {
        for (int i = 1; i < dataPenilaian19.size(); i++) {
            Penilaian key = dataPenilaian19.get(i);
            double valKey = key.hitungNilaiAkhir();
            int j = i - 1;
            while (j >= 0 && (asc ? dataPenilaian19.get(j).hitungNilaiAkhir() > valKey
                    : dataPenilaian19.get(j).hitungNilaiAkhir() < valKey)) {
                dataPenilaian19.set(j + 1, dataPenilaian19.get(j));
                j--;
            }
            dataPenilaian19.set(j + 1, key);
        }
    }

    int binarySearchMhs(String target) {
        sortMhsByName(true);
        int lo = 0, hi = dataMhs19.size() - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cmp = dataMhs19.get(mid).nama19.compareToIgnoreCase(target);
            if (cmp == 0)
                return mid;
            if (cmp < 0)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }
}