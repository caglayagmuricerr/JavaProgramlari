package A;

import java.util.Date;
import java.util.ArrayList;

public class Musteri extends Kisi{
    private int musteriNumarasi;
    
    ArrayList<BankaHesap> hesaplar;
    ArrayList<KrediKarti> krediKartlari;

    //constructor
    public Musteri(long tcKimlikNo, String ad, String soyad, String email, long telefonNumarasi, int musteriNumarasi, int musteriID) {
        super(tcKimlikNo, ad, soyad, email, telefonNumarasi);
        this.musteriNumarasi = musteriNumarasi;
        hesaplar = new ArrayList<BankaHesap>();
        krediKartlari = new ArrayList<KrediKarti>();
    }
    
	  /////////////////////////
	 // Hesap Ekleme Metodu //
	/////////////////////////
    public void hesapEkle(long tcKimlikNo, int musteriNumarasi, String ad, String soyad, String hesapTuru, int hesapBilgisi) {//hesapBilgisi parametresini ekledim
        BankaHesap yeniHesap;
        //Bütün hesaplara 100000 bakiye verdim. Random koyunca sürekli Yetersiz Bakiye exception atıyordu.
        switch (hesapTuru) {
            case "Vadeli":
            	//long iban, Date hesapAcilisTarih, double toplamBakiye, int hesapBilgisi, double islemMiktar, String hesapTuru,int vadeliBakiye, float faizOrani
                yeniHesap = new VadeliHesap(main.generateRandomNumber(100,1000), new Date(), 10000.0, hesapBilgisi, main.generateRandomDouble(), hesapTuru ,0, 0.0f);
                break;
            case "Vadesiz":
            	//long iban, Date hesapAcilisTarih, double toplamBakiye, int hesapBilgisi, double islemMiktar, String hesapTuru, double vadesizBakiye
                yeniHesap = new VadesizHesap(main.generateRandomNumber(100,1000), new Date(), 10000.0, hesapBilgisi, main.generateRandomDouble(), hesapTuru , 0.0);
                break; 
            case "Yatirim":
            	//long iban, Date hesapAcilisTarih, double toplamBakiye, int hesapBilgisi, double islemMiktar, String hesapTuru, int yatirimBakiye, String yatirimTuru, float kur
                yeniHesap = new YatirimHesap(main.generateRandomNumber(100,1000), new Date(), 10000.0, hesapBilgisi, main.generateRandomDouble(), hesapTuru ,0, "yatirimTuru", 0.0f);
                break;
            default:
                yeniHesap = null;
                break;
        }
        if (yeniHesap != null) {
            hesaplar.add(yeniHesap);
        }
    }
    
	  ////////////////////////
	 // Hesap Silme Metodu //
	////////////////////////
    public void hesapSil(long tcKimlikNo, int musteriNumarasi, String ad, String soyad) {
        for (BankaHesap hesap : hesaplar) {
            if (getTcKimlikNo() == tcKimlikNo &&
                getMusteriNumarasi() == musteriNumarasi &&
                getAd().equals(ad) &&
                getSoyad().equals(soyad)) {
                if (hesap.getToplamBakiye() > 0) {
                    System.out.println("Lütfen öncelikle bakiyenizi başka bir hesaba aktarınız.");
                    return;
                } else {
                    hesaplar.remove(hesap);
                    System.out.println("Hesap başarıyla silindi.");
                    return;
                }
            }
        }
        System.out.println("Hesap bulunamadı.");
    }
    
	  //////////////////////////
	 // Get ve Set Metodlari //
	//////////////////////////
    public int getMusteriNumarasi() {
        return musteriNumarasi;
    }

    public void setMusteriNumarasi(int musteriNumarasi) {
        this.musteriNumarasi = musteriNumarasi;
    }

    public ArrayList<BankaHesap> getHesaplar() {
        return hesaplar;
    }

    public void setHesaplar(ArrayList<BankaHesap> hesaplar) {
        this.hesaplar = hesaplar;
    }

    public ArrayList<KrediKarti> getKrediKartlari() {
        return krediKartlari;
    }

    public void setKrediKartlari(ArrayList<KrediKarti> krediKartlari) {
        this.krediKartlari = krediKartlari;
    }
    
	  ///////////////////////////
	 // Array Yazdirma Metodu // toString icinde kullanmak amacli ekledim
	///////////////////////////
 
    public static <T> String printArrayList(ArrayList<T> list) {
        StringBuilder sb = new StringBuilder();
        T hesap;
        for (int i = 0; i < list.size(); i++) {
        	hesap = list.get(i);
        	sb.append(i + 1 + ". Nesne \n").append(hesap.toString()).append(",\n");
        }
        return sb.toString();
    }
   
	  /////////////////////
	 // ToString Metodu //
	/////////////////////
    @Override
    public String toString()
    {
        return super.toString() + "\nMüşteri Numarası: " + musteriNumarasi + "\n\n------\n\n" + "Hesaplar: \n" + printArrayList(hesaplar) + "\n------\n\n" + "Kredi Kartları: \n" + printArrayList(krediKartlari);
    }
}
