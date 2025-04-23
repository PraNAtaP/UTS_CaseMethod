//Pranata
public class MataKuliah19 {
    String kodeMK19;
    String namaMK19;
    int sks19;

    MataKuliah19(String kodeMK19, String namaMK19, int sks19) {
        this.kodeMK19 = kodeMK19;
        this.namaMK19 = namaMK19;
        this.sks19 = sks19;
    }

    void tampilMatakuliah19() {
        System.out.println("Kode MK : " + kodeMK19 + " | Nama : " + namaMK19 + " | SKS : " + sks19);
    }
}