package A;

public class KrediKarti {
	private int kartNumarasi;
	double limit;
	double guncelBorc;
		
	public KrediKarti(int kartNumarasi, double limit, double guncelBorc) {
		this.kartNumarasi = kartNumarasi;
		this.limit = limit;
		this.guncelBorc = guncelBorc;
	}

	public void KrediKartiEkle(int kartNumarasi, double limit, Musteri musteri, int musteriNumarasi) { //musteri nesnesi almayı ve int musteriNumarasi ben ekledim
		KrediKarti yeniKrediKarti = new KrediKarti(kartNumarasi, limit, 0.0); //borc baslangicta 0.0;
        
    	if (musteri.getMusteriNumarasi() == musteriNumarasi && yeniKrediKarti != null) {
    		musteri.krediKartlari.add(yeniKrediKarti);            
    	}
	}
	
	//Kart silme metodu//
	public void KrediKartiSil(int kartNumarasi, double limit, double guncelBorc, Musteri musteri) { //musteri nesnesi almayı ekledim
        if (guncelBorc == 0.0) {
            musteri.getKrediKartlari().removeIf(krediKarti -> krediKarti.getKartNumarasi() == kartNumarasi);
            System.out.println("Kart başarıyla silindi.");
        } else {
            System.out.println("Lütfen öncelikle borç ödemesi yapınız.");
        }
	}
	
	//Kullanılabilir limit metodu//
    public double kullanilabilirLimit(int kartNumarasi, double guncelBorc, Musteri musteri) {
    	KrediKarti temp = null;
        // Kart numarasına göre ilgili kredi kartının limitine erişim sağlanabilir
    	for(int i = 0 ; i < musteri.getKrediKartlari().size() ; i++) {
    		if (musteri.getKrediKartlari().get(i).getKartNumarasi() == kartNumarasi) {
        		temp = musteri.getKrediKartlari().get(i);
    		}
    	}
        // temp'in hala boş olup olmadığını kontrol et (eşleşen kartNumarasi bulunamadı)
        if (temp == null) {
            // Eşleşen kartNumarasi'nin bulunmadığı durumu ele alın, örneğin bir istisna atın veya varsayılan bir değer döndürün
        	throw new IllegalArgumentException("No matching kartNumarasi found."); // Throw an exception
        }
        
        return temp.limit - guncelBorc;
    }

    public static void kampanya(KrediKarti kart) {
        if (kart.limit < 5000) {
            System.out.println("Kredi teklifi: Kart borcunuz " + kart.guncelBorc + " TL. Daha yüksek limitli bir kredi kartı için kampanyalara göz atın!");
        } else if (kart.limit > 10000) {
            System.out.println("Kredi teklifi: " + kart.limit + " TL üzerindeki limitle özel bir kredi teklifi sizin için mevcut!");
        } else {
            System.out.println("Kredi teklifi: Mevcut limitiniz " + kart.limit + " TL. Size uygun kampanyaları değerlendirin.");
        }
    }

	  //////////////////////////////
	 //Getter ve Setter Metodları//
	//////////////////////////////
	public int getKartNumarasi() {
		return kartNumarasi;
	}

	public void setKartNumarasi(int kartNumarasi) {
		this.kartNumarasi = kartNumarasi;
	}
	
	public double getLimit() {
		return limit;
	}
	
	public void setLimit(double limit) {
		this.limit = limit;
	}
	
	public double getGuncelBorc() {
		return guncelBorc;
	}
	
	public void setGuncelBorc(double guncelBorc) {
		this.guncelBorc = guncelBorc;
	}
      /////////////////////
     // ToString Metodu //
    /////////////////////
	@Override
    public String toString()
    {
        return "Kart Numarası: " + kartNumarasi + "\nLimit: " + limit + "\nGuncel Borc: " + guncelBorc;
    }
}
