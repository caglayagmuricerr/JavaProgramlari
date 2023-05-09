package A;

import java.util.Date;

public class VadeliHesap extends BankaHesap {

	String hesapTuru = "Vadeli";
	int vadeliBakiye;
	float faizOrani;
	public VadeliHesap(long iban, Date hesapAcilisTarih, double toplamBakiye, int hesapBilgisi, double islemMiktar, String hesapTuru,int vadeliBakiye, float faizOrani) {
		super(iban, hesapAcilisTarih, toplamBakiye, hesapBilgisi, islemMiktar, hesapTuru);
		System.out.println("Vadeli Hesap Oluşturuldu");
	}
	
	// Get ve Set
	public int getVadeliBakiye() {
	    return vadeliBakiye;
	}

	public void setVadesizBakiye(int vadeliBakiye) {
	    this.vadeliBakiye = vadeliBakiye;
	}
	
	public float getFaizOrani() {
	    return faizOrani;
	}

	public void setFaizOrani(float faizOrani) {
	    this.faizOrani = faizOrani;
	}
	
	
      /////////////////////
     // ToString Metodu //
    /////////////////////
	@Override
    public String toString()
    {
        return super.toString() + "\nHesap Türü: " + hesapTuru + "\nVadeli Bakiye: " + vadeliBakiye + "\nFaiz Oranı: " + faizOrani;
    }//super.toString() parent'in toString metodunu cagirir.
}
