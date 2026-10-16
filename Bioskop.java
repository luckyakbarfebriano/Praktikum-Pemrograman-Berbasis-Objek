package ppbo.uts;

public class Bioskop {
    private String nama;
    private Studio[] daftarStudio;
    private Manajer manajer;

    public Bioskop(String nama, int jumlahStudio, int kapasitasStudio) {
        this.nama = nama;
        this.daftarStudio = new Studio[jumlahStudio];
        for (int i = 0; i < jumlahStudio; i++) {
            daftarStudio[i] = new Studio(i + 1, kapasitasStudio); // Composition: Studio dibuat di dalam Bioskop
        }
    }

    public void setManajer(Manajer manajer) {
        this.manajer = manajer;
    }

    // Overloading 1: tanpa nomor studio, masuk ke studio pertama yang masih punya kursi
    public void jualTiket(Tiket t) {
        if (t == null) {
            System.out.println("Tiket tidak valid.");
            return;
        }
        for (int i = 0; i < daftarStudio.length; i++) {
            if (daftarStudio[i].jual(t)) {
                return;
            }
        }
        System.out.println("Semua studio penuh.");
    }

    // Overloading 2: dengan nomor studio tertentu
    public void jualTiket(Tiket t, int nomorStudio) {
        if (t == null) {
            System.out.println("Tiket tidak valid.");
            return;
        }
        Studio s = getStudio(nomorStudio);
        if (s == null) {
            System.out.println("Studio " + nomorStudio + " tidak tersedia.");
            return;
        }
        if (!s.jual(t)) {
            System.out.println("Studio " + nomorStudio + " penuh.");
        }
    }

    public Studio getStudio(int nomor) {
        if (nomor < 1 || nomor > daftarStudio.length) { // guard clause batas array
            return null;
        }
        return daftarStudio[nomor - 1];
    }

    public void tampilInfo() {
        System.out.println("Bioskop       : " + nama);
        if (manajer != null) {
            System.out.println("Manajer       : " + manajer.getNama());
        } else {
            System.out.println("Manajer       : belum ditetapkan");
        }
        System.out.println("Jumlah studio : " + daftarStudio.length);
    }
}
