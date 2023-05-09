package A;

import java.util.Date;

public class VadesizHesap extends BankaHesap{
	String hesapTuru = "Vadesiz";
	double vadesizBakiye;
	
	public VadesizHesap(long iban, Date hesapAcilisTarih, double toplamBakiye, int hesapBilgisi, double islemMiktar, String hesapTuru, double vadesizBakiye) {
		super(iban, hesapAcilisTarih, toplamBakiye, hesapBilgisi, islemMiktar, hesapTuru);
		System.out.println("Vadesiz Hesap Oluşturuldu");
	}
	
	public double paraTransfer(String hesapTuru, int hesapBilgisi, long iban, double vadesizBakiye, double islemMiktar) { //hesapBilgisi parametresini ekledim
	    double kesinti = 0.0;
	    double faizOrani = 0.0;
	    iban = super.getIban();
	    
	    if (hesapTuru.equalsIgnoreCase("Vadeli")) {
	        if (hesapBilgisi == 1) { // Maas hesabi
	            faizOrani = 0.2;
	            kesinti = 0.0;
	        } else if (hesapBilgisi == 2) { // Normal hesap
	            faizOrani = 0.1;
	            kesinti = 8.0;
	        }
	    } else if (hesapTuru.equalsIgnoreCase("Vadesiz")) {
	        if (hesapBilgisi == 1) { // Maas hesabi
	            faizOrani = 0.0;
	            kesinti = 0.0;
	        } else if (hesapBilgisi == 2) { // Normal hesap
	            faizOrani = 0.0;
	            kesinti = 8.0;
	        }
	    } else if (hesapTuru.equalsIgnoreCase("Yatirim")) {
	        faizOrani = 0.0;
	        kesinti = 0.0;
	    }
	    
	    double hesapBakiye = vadesizBakiye - kesinti;
	    double faizMiktari = hesapBakiye * faizOrani;
	    double transferMiktari = islemMiktar - faizMiktari;
	    
	    return transferMiktari;
	}
	
	public void krediKartiBorcOdeme(double odemeMiktari, KrediKarti krediKarti) {//vadesizBakiye parametresi vermişsiniz. odemeMiktari olarak değiştirdim.
	    // Hesabın bakiyesinden ödeme miktarı kadar düşürme
	    double yeniBakiye = vadesizBakiye - odemeMiktari;
	    setVadesizBakiye(yeniBakiye);

	    // Kredi kartının güncel borcunu ödeme miktarı kadar azaltma
	    double guncelBorc = krediKarti.getGuncelBorc();
	    double yeniBorc = guncelBorc - odemeMiktari;
	    krediKarti.setGuncelBorc(yeniBorc);
	}
	
	public double krediOdeme(int krediID, Krediler krediMiktari, Krediler taksitMiktari) {
	    // Hesabın bakiyesinden ödeme miktarı kadar düşürme
	    double odemeMiktari = taksitMiktari.getTaksitMiktar();
	    double yeniBakiye = getVadesizBakiye() - odemeMiktari;
	    setVadesizBakiye(yeniBakiye);

	    // Kredinin güncel borcunu ödeme miktarı kadar azaltma
	    double krediBorc = krediMiktari.getKrediMiktari();
	    double yeniBorc = krediBorc - odemeMiktari;
	    krediMiktari.setKrediMiktari(yeniBorc);

	    // Ödenen miktarı döndürme
	    return odemeMiktari;
	}
	
	//////////Get ve set
	public double getVadesizBakiye() {
	    return vadesizBakiye;
	}

	public void setVadesizBakiye(double vadesizBakiye) {
	    this.vadesizBakiye = vadesizBakiye;
	}
	
	
      /////////////////////
     // ToString Metodu //
    /////////////////////
	public String toString()
    {
        return super.toString() + "\nHesap Türü: " + hesapTuru + "\nVadesiz Bakiye: " + vadesizBakiye;
    }//super.toString() parent'in toString metodunu cagirir.
}
