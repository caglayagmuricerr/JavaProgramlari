package A;

import java.util.ArrayList;

public class Krediler {
	private int krediID;
	double krediMiktari;
	double taksitMiktar;
	
	public Krediler(int krediID, double krediMiktari, double taksitMiktar) {
		krediID = this.krediID;
		krediMiktari = this.krediMiktari;
		taksitMiktar = this.taksitMiktar;
	}
	
	public void KrediVer(int krediID, int musteriNumarasi, int krediMiktar, Musteri musteri) {//musteri ekledim ve adını Krediler değil KrediVer yaptım.
		// MusteriNumarasi'na göre müşteriyi bulma
        Musteri temp = musteri;
        
        if (temp != null) {
            // Müşterinin hesaplarını kontrol etme
            ArrayList<BankaHesap> hesaplar = temp.getHesaplar();
            double toplamBakiye = 0.0;
            
            for (BankaHesap hesap : hesaplar) {
                toplamBakiye += hesap.getToplamBakiye();
            }
            
            // Kredi verme işlemi
            double krediLimiti = toplamBakiye * 0.5; // Yıllık kazancın %50'si kadar kredi limiti
            
            if (krediMiktar <= krediLimiti) {
                // Kredi verilebilir
                System.out.println("Kredi onaylandı. Kredi ID: " + krediID);
            } else {
                // Kredi limiti aşıldı
                System.out.println("Kredi limiti aşıldı. Kredi onaylanmadı.");
            }
        } else {
            // Müşteri bulunamadı
            System.out.println("Müşteri bulunamadı. Kredi onaylanmadı.");
        }
	}
	
	//get ve set metodları
	public int getKrediID() {
        return krediID;
    }

    public void setKrediID(int krediID) {
        this.krediID = krediID;
    }
    
	public double getKrediMiktari() {
        return krediMiktari;
    }

    public void setKrediMiktari(double krediMiktari) {
        this.krediMiktari = krediMiktari;
    }
    
	public double getTaksitMiktar() {
        return taksitMiktar;
    }

    public void setTaksitMiktar(double taksitMiktar) {
        this.taksitMiktar = taksitMiktar;
    }

      /////////////////////
     // ToString Metodu //
    /////////////////////
	@Override
	 public String toString()
    {
        return "Kredi ID: " + krediID + "\nKredi Miktarı: " + krediMiktari + "\nTaksit Miktarı: " + taksitMiktar;
    }
}
