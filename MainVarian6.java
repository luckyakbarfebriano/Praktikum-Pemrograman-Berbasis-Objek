package ppbo.uts;

public class MainVarian6 {
    
    public static void main(String[] args) {
        // 1. Bioskop dengan 3 studio kapasitas 50, manajer Pak Hadi
        Bioskop bioskop = new Bioskop("Sinema Malang", 3, 50);
        bioskop.setManajer(new Manajer("Pak Hadi"));

        // 2. Penonton 
        Penonton andi = new Penonton("Andi", "08123456789");
        Penonton sinta = new Penonton("Sinta", "08987654321");

        // 3. Tiket
        TiketReguler reguler = new TiketReguler("T-001", "Laskar Pelangi", 40000, true);
        reguler.setPemilik(andi);
        TiketVIP vip = new TiketVIP("T-002", "Laskar Pelangi", 40000);
        vip.setPemilik(sinta);

        // 4. Penjualan
        bioskop.jualTiket(reguler);
        bioskop.jualTiket(vip, 1);

        // 5. Cetak tiket
        MesinCetak mesin = new MesinCetak("MC-01");
        mesin.cetak(reguler);
        mesin.cetak(vip);
    }
}

