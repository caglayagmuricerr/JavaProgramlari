package A;

import java.util.Date;

public class YatirimHesap extends BankaHesap {

	String hesapTuru = "Yatirim";
	int yatirimBakiye;
	String yatirimTuru;
	float kur;
	
	public YatirimHesap(long iban, Date hesapAcilisTarih, double toplamBakiye, int hesapBilgisi, double islemMiktar, String hesapTuru, int yatirimBakiye, String yatirimTuru, float kur) {
		super(iban, hesapAcilisTarih, toplamBakiye, hesapBilgisi, islemMiktar, hesapTuru);
		System.out.println("Yatırım Hesap Oluşturuldu");
	}
	
    public double paraEkle(int yatirimBakiye, String yatirimTuru, float kur, int yatirilanMiktar) { //yatirilanMiktar ekledim
        double eklenecekMiktar = yatirilanMiktar * kur;
        this.yatirimBakiye += eklenecekMiktar;
        this.yatirimTuru = yatirimTuru;
        System.out.println("Hesaba " + eklenecekMiktar + " birim " + yatirimTuru + " eklendi. Son Bakiye : " + yatirimBakiye);
        return this.yatirimBakiye;
    }

    public double paraBoz(int yatirimBakiye, String yatirimTuru, float kur) {
        double cekilecekMiktar = yatirimBakiye * kur;
        if (cekilecekMiktar <= this.yatirimBakiye) {
            this.yatirimBakiye -= cekilecekMiktar;
            System.out.println("Hesaptan " + cekilecekMiktar + " birim " + yatirimTuru + " çekildi.");
        } else {
            System.out.println("Hesapta yeterli " + yatirimTuru + " bulunmamaktadır.");
        }
        return this.yatirimBakiye;
    }
    
    //GET VE SET
    
	public int getYatirimBakiye() {
	    return yatirimBakiye;
	}

	public void setYatirimBakiye(int yatirimBakiye) {
	    this.yatirimBakiye = yatirimBakiye;
	}
	
	public String getYatirimTuru() {
	    return yatirimTuru;
	}

	public void setYatirimTuru(String yatirimTuru) {
	    this.yatirimTuru = yatirimTuru;
	}
	
	public float getKur() {
	    return kur;
	}

	public void setKur(float kur) {
	    this.kur = kur;
	}
    
      /////////////////////
     // ToString Metodu //
    /////////////////////
	public String toString()
    {
        return super.toString() + "\nHesap Türü: " + hesapTuru + "\nYatirim Bakiye: " + yatirimBakiye + "\nYatırım Türü: " + yatirimTuru + "\nKur: " + kur;
    }//super.toString() parent'in toString metodunu cagirir.
}
