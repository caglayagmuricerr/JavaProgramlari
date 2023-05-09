package A;

public class Kisi {
    private long tcKimlikNo; // 11 haneli sayi için long kullandım
    private String ad;
    private String soyad;
    private String email;
    private long telefonNumarasi; // telefon numarasi int'e sigmiyor bu yuzden long aldim.

	  /////////////////
	 // Constructor //
	/////////////////
    public Kisi(long tcKimlikNo, String ad, String soyad, String email, long telefonNumarasi) {
    	this.tcKimlikNo = tcKimlikNo;
    	this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.telefonNumarasi = telefonNumarasi;
    }
    
	  //////////////////////////
	 // Get ve Set Metodlari //
	//////////////////////////
    public long getTcKimlikNo() {
        return tcKimlikNo;
    }

    public void setTcKimlikNo(int tcKimlikNo) {
        this.tcKimlikNo = tcKimlikNo;
    }
    
    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefon() {
        return telefonNumarasi;
    }

    public void setTelefon(long telefonNumarasi) {
        this.telefonNumarasi = telefonNumarasi;
    }
    
      /////////////////////
     // ToString Metodu //
    /////////////////////
    @Override
    public String toString() //  Konsola Yazdirmak Icin
    {
        return "Tc Kimlik No: " + tcKimlikNo + "\nAd: " + ad + "\nSoyAd: " + soyad + "\nEmail: " + email +"\nTelefon Numarası: " + telefonNumarasi;
    }
}
