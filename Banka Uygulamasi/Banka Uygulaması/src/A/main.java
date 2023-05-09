     ///////////////////////////////////////////////////////////
    //   CAGLA YAGMUR İCER                                   //
   //   OGRENCİ NO: 19360859027                             //
  //   BURSA TEKNİK uNİVERSİTESİ BİLGİSAYAR MuHENDİSLİgİ   //
 //   NESNEYE YÖNELİK PROGRAMLAMA DERSİ ÖDEVİ             //
///////////////////////////////////////////////////////////
package A;

import java.util.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
	
		Musteri musteri1 = new Musteri(tcKimlikNoRandom(), "a", "a", "a@gmail.com", telNoRandom(), 1, generateRandomNumber(100,1000));
		Musteri musteri2 = new Musteri(tcKimlikNoRandom(), "b", "b", "b@gmail.com", telNoRandom(), 2, generateRandomNumber(100,1000));
		
		KrediKarti kartEkleyici = new KrediKarti(generateRandomNumber(100,1000), generateRandomDouble(), generateRandomDouble());
		
		//KrediKartiEkle(int kartNumarasi, double limit, Musteri musteri, int musteriNumarasi)
		kartEkleyici.KrediKartiEkle(generateRandomNumber(100,1000), generateRandomDouble(), musteri1, musteri1.getMusteriNumarasi());
		kartEkleyici.KrediKartiEkle(generateRandomNumber(100,1000), generateRandomDouble(), musteri2, musteri2.getMusteriNumarasi());
		
		KrediKarti kart1 = musteri1.getKrediKartlari().get(0);
		KrediKarti kart2 = musteri2.getKrediKartlari().get(0);
		
		//hesapEkle(int tcKimlikNo, int musteriNumarasi, String ad, String soyad, String hesapTuru, int hesapBilgisi)
		musteri1.hesapEkle(tcKimlikNoRandom(), 1, "a", "a", "Vadesiz", 1); //vadesiz maas hesabı
		musteri2.hesapEkle(tcKimlikNoRandom(), 2, "a", "a", "Vadeli", 2); //vadeli normal hesap
				
		
		////////////////////////////////////////////////////////////////////
		//MusteriNo'su girilen birinin tüm bilgilerini yazdıran kısım
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Musteri Numarası giriniz : ");
		int musteriNo = scanner.nextInt();
		
		if(musteriNo == musteri1.getMusteriNumarasi())System.out.println(musteri1.toString());
		if(musteriNo == musteri2.getMusteriNumarasi())System.out.println(musteri2.toString());
		else System.out.println("Musteri Bulunamadı.");
		
		///////////////////////////////////////////////////////////////////////////////////////////////////
		//KrediKarti limiti 5000 TL altında olanların guncelBorc bilgisini yazdırır. KrediKarti limiti 10000 TL üstündeyse kredi teklifi yapar.
		
		KrediKarti.kampanya(kart1);
		KrediKarti.kampanya(kart2);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////
		
		VadesizHesap hesap1 = (VadesizHesap)musteri1.getHesaplar().get(0); //BankaHesap tipindeki nesneleri CAST ederek Vadeli/Vadesiz'e dönüştürme
		VadeliHesap hesap2 = (VadeliHesap)musteri2.getHesaplar().get(0);

		
		//MUSTERI 1 KULLANILABİLİR LİMİT YAZDIRMA
		for(int i = 0 ; i < musteri1.getKrediKartlari().size() ; i++) {
			//kullanilabilirLimit(int kartNumarasi, double guncelBorc, Musteri musteri)
			System.out.println(kartEkleyici.kullanilabilirLimit(musteri1.getKrediKartlari().get(i).getKartNumarasi(), musteri1.getKrediKartlari().get(i).guncelBorc , musteri1));
		}
		
		//MUSTERI 2 KULLANILABİLİR LİMİT YAZDIRMA
		for(int i = 0 ; i < musteri2.getKrediKartlari().size() ; i++) { //kart numarasını musteri2'den cekmek icin
			//kullanilabilirLimit(int kartNumarasi, double guncelBorc, Musteri musteri)
			System.out.println(kartEkleyici.kullanilabilirLimit(musteri2.getKrediKartlari().get(i).getKartNumarasi(), musteri2.getKrediKartlari().get(i).guncelBorc , musteri2));
		}
		
		//paraTransfer METODU///////////////////////////////////////////////////////////////////////////////////
		//public double paraTransfer(String hesapTuru, long iban, double vadesizBakiye, int islemMiktar)
		hesap1.paraTransfer("Vadeli", 1, musteri1.getHesaplar().get(0).getIban(), hesap1.vadesizBakiye, generateRandomDouble());
	
		///////////////////////////////////////////////
		//Bakiye Yazdırma

		System.out.println("musteri1 : \n");
		System.out.println(toplamBakiyeYazdir(musteri1) + "\n");
		
		System.out.println("musteri2 : \n");
		System.out.println(toplamBakiyeYazdir(musteri2) + "\n");				
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static ArrayList<Double> toplamBakiyeYazdir(Musteri musteri) { //BankaHesap açılış tarihi 1 Ocak’tan sonra açılan tüm hesapların
		//toplamBakiye’lerini ekrana yazdıran kod.
		Date date = new Date(0); // Şu anki tarih ve saat
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    cal.set(Calendar.DAY_OF_YEAR, 1); // Yılın ilk gününü (1 Ocak) ayarla
	    Date ocakBir = cal.getTime(); 
        
		Musteri temp = musteri;
		ArrayList<BankaHesap> hesaplar = temp.getHesaplar();
		ArrayList<Double> bakiyeler = new ArrayList<>(); // bakiyeleri tutan array
		
		for(BankaHesap hesap : hesaplar) {
			if(hesap.hesapAcilisTarih.after(ocakBir)) {
				 bakiyeler.add(hesap.toplamBakiye);
			}
		}
		return bakiyeler;
	}
	
    public static long tcKimlikNoRandom() { //TcKimlikNo 11 haneli olsun istedim ayrı bir metod yazdım.
        Random random = new Random();
        long min = 10000000000L; // Minimum 11 haneli sayı
        long max = 99999999999L; // Maksimum 11 haneli sayı
        
        return min + ((long) (random.nextDouble() * (max - min)));
    }
    
    public static long telNoRandom() { //TelefonNumarasi 10 haneli olsun istedim (başında 0 yok) ayrı bir metod yazdım.
        Random random = new Random();
        long min = 1000000000L; // En küçük 10 haneli sayı
        long max = 9999999999L; // En büyük 10 haneli sayı

        return min + ((long) (random.nextDouble() * (max - min)));
    }

    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    
    public static double generateRandomDouble() { //double'lar için
        Random random = new Random();

        double randomNumber = 100 + random.nextDouble() * 9900; //Random sınıfının nextDouble() metodunu kullanarak 0 ile 1 arasında bir ondalık sayı üretir. 
        													   //Ardından, bu değeri 9900 ile çarparak 0 ile 9900 arasında bir sayı elde eder. Son olarak, 
        									   				  //elde edilen sayıya 100 ekleyerek 100 ile 10000 arasında bir sayıya kaydırır.
        DecimalFormat decimalFormat = new DecimalFormat("#.00");//ondalık sayının nasıl biçimlendirileceğini belirlemek için kullanılır. "#.00" sayının en fazla 2 ondalık basamağa sahip olacağını belirtir.
        String formattedNumber = decimalFormat.format(randomNumber);// randomNumber değerini biçimlendirerek bir String olarak döndürür. Bu işlem, sayıyı istenen ondalık basamak formatına getirir.

        return Double.parseDouble(formattedNumber);//biçimlendirilmiş sayıyı bir double değere dönüştürür ve bu değeri geri döndürür.
    }
}
