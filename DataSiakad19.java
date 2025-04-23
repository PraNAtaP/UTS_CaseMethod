import java.util.*;

//Pranata
public class DataSiakad19 {
    List<Mahasiswa19> dataMhs19 = new ArrayList<>();
    List<MataKuliah19> dataMk19 = new ArrayList<>();
    List<Penilaian19> dataPenilaian19 = new ArrayList<>();

    void tambahMHS19(Mahasiswa19 m) {
        dataMhs19.add(m);
    }

    void tambahMK19(MataKuliah19 m) {
        dataMk19.add(m);
    }

    void tambahPenilaian19(Penilaian19 p) {
        dataPenilaian19.add(p);
    }

    void tampilMhs19() {
        System.out.println("\n=== Daftar Mahasiswa (Unik) ===");
        Set<String> seen = new HashSet<>();
        for (Mahasiswa19 m : dataMhs19) {
            if (!seen.contains(m.nama19.toLowerCase())) {
                m.tampilMahasiswa19();
                seen.add(m.nama19.toLowerCase());
            }
        }
    }

    void tampilMk19() {
        System.out.println("\n=== Daftar Mata Kuliah ===");
        for (MataKuliah19 mk : dataMk19)
            mk.tampilMatakuliah19();
    }

    void tampilPenilaian19() {
        System.out.println("\n=== Data Penilaian ===");
        for (Penilaian19 p : dataPenilaian19)
            p.tampilPenilaian19();
    }

    MataKuliah19 cariMatkuldariKode19(String kode) {
        for (MataKuliah19 mk : dataMk19) {
            if (mk.kodeMK19.equalsIgnoreCase(kode))
                return mk;
        }
        return null;
    }

    void sortMhsdariNama19(boolean asc) {
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

    void sortPenDariNilai19(boolean asc) {
        for (int i = 1; i < dataPenilaian19.size(); i++) {
            Penilaian19 key = dataPenilaian19.get(i);
            double valKey = key.hitungNilaiAkhir19();
            int j = i - 1;
            while (j >= 0 && (asc ? dataPenilaian19.get(j).hitungNilaiAkhir19() > valKey
                    : dataPenilaian19.get(j).hitungNilaiAkhir19() < valKey)) {
                dataPenilaian19.set(j + 1, dataPenilaian19.get(j));
                j--;
            }
            dataPenilaian19.set(j + 1, key);
        }
    }

    int binarySearchMhs19(String target) {
        sortMhsdariNama19(true);
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