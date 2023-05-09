package A;

import java.util.Date;

public class BankaHesap {
    private long iban;
    Date hesapAcilisTarih;
    double toplamBakiye;
    int hesapBilgisi; //1 ve 2 ile temsil edilecek demişsiniz String istemişsiniz ben int'e çevirdim
    double islemMiktar;
    String hesapTuru; // vadeli, vadesiz veya yatırım hesabı

    public static final int MAAS_HESABI = 1;
    public static final int NORMAL_HESAP = 2;
    
    //constructor
    public BankaHesap(long iban, Date hesapAcilisTarih, double toplamBakiye, int hesapBilgisi, double islemMiktar, String hesapTuru) {
    	this.iban = iban;
    	this.hesapAcilisTarih = hesapAcilisTarih;
    	this.toplamBakiye = toplamBakiye;
    	this.hesapBilgisi = hesapBilgisi;
    	this.islemMiktar = islemMiktar;
    	this.hesapTuru = hesapTuru;
    }

    
	  //////////////////////////
	 // Get ve Set Metodlari //
	//////////////////////////
    
	public long getIban() {
		return iban;
	}

	public void setIban(long iban) {
		this.iban = iban;
	}
	
	public Date getHesapAcilisTarih() {
	    return hesapAcilisTarih;
	}

	public void setHesapAcilisTarih(Date hesapAcilisTarih) {
	    this.hesapAcilisTarih = hesapAcilisTarih;
	}

	public double getToplamBakiye() {
	    return toplamBakiye;
	}

	public void setToplamBakiye(double toplamBakiye) {
	    this.toplamBakiye = toplamBakiye;
	}

	public int getHesapBilgisi() {
	    return hesapBilgisi;
	}

	public void setHesapBilgisi(int hesapBilgisi) {
		if (hesapBilgisi == MAAS_HESABI || hesapBilgisi == NORMAL_HESAP) {
            this.hesapBilgisi = hesapBilgisi;
        } else {
            throw new IllegalArgumentException("Geçersiz hesap bilgisi: " + hesapBilgisi);
        }
	}

	public double getIslemMiktar() {
	    return islemMiktar;
	}

	public void setIslemMiktar(double islemMiktar) {
	    this.islemMiktar = islemMiktar;
	}

	public String getHesapTuru() {
	    return hesapTuru;
	}

	public void setHesapTuru(String hesapTuru) {
	    this.hesapTuru = hesapTuru;
	}
      /////////////////////
     // ToString Metodu //
    /////////////////////
	@Override
	public String toString()
    {
        return "IBAN: " + iban + "\nHesap Açılış Tarihi: " + hesapAcilisTarih + "\nToplam Bakiye: " + toplamBakiye + "\nHesap Bilgisi: " + hesapBilgisi +"\nİşlem Miktar: " + islemMiktar ;
    }//super.toString() parent'in toString metodunu cagirir.
}
