package ppbo.uts;

public class MesinCetak {
    private String kodeMesin;

    public MesinCetak(String kodeMesin) {
        this.kodeMesin = kodeMesin;
    }

    public void cetak(Tiket t) {
        if (t == null) {
            System.out.println("Tiket tidak valid.");
            return;
        }
        String namaPemilik = "-";
        if (t.getPemilik() != null) {
            namaPemilik = t.getPemilik().getNama();
        }
        System.out.println("[" + t.getJenis() + "] " + t.getKode() + " " + t.getJudulFilm()
                + " | " + namaPemilik + " | Rp" + t.hitungHarga());
    }
}

