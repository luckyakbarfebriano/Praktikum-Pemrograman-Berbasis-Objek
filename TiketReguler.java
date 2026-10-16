package ppbo.uts;
public class TiketReguler extends Tiket {
    private boolean weekend;

    public TiketReguler(String kode, String judulFilm, int hargaDasar, boolean weekend) {
        super(kode, judulFilm, hargaDasar);
        this.weekend = weekend;
    }

    @Override
    public int hitungHarga() {
        if (weekend) {
            return hargaDasar + 10000;
        }
        return hargaDasar;
    }

    @Override
    public String getJenis() {
        return "Reguler";
    }
}

