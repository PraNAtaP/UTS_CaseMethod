//Pranata
public class Penilaian {
    Mahasiswa mahasiswa19;
    MataKuliah mataKuliah19;
    double nilaiTugas19;
    double nilaiUTS19;
    double nilaiUAS19;

    Penilaian(Mahasiswa mahasiswa19, MataKuliah mataKuliah19, double nilaiTugas19, double nilaiUTS19, double nilaiUAS19) {
        this.mahasiswa19 = mahasiswa19;
        this.mataKuliah19 = mataKuliah19;
        this.nilaiTugas19 = nilaiTugas19;
        this.nilaiUTS19 = nilaiUTS19;
        this.nilaiUAS19 = nilaiUAS19;
    }

    double hitungNilaiAkhir() {
        return (nilaiTugas19 * 0.3) + (nilaiUTS19 * 0.3) + (nilaiUAS19 * 0.4);
    }

    void tampilPenilaian() {
        System.out.printf("%s | %s | Akhir: %.2f\n", mahasiswa19.nama19, mataKuliah19.namaMK19, hitungNilaiAkhir());
    }
}