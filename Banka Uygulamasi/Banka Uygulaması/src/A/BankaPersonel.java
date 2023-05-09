package A;

import java.util.ArrayList;

public class BankaPersonel extends Kisi{
    private int personelID;
    ArrayList<Musteri> musteriler;

    
    //constructor
    public BankaPersonel(long tcKimlikNo, String ad, String soyad, String email, long telefonNumarasi, int personelID) {
        super(tcKimlikNo, ad, soyad, email, telefonNumarasi);
        this.personelID = personelID;
    }
    
	  //////////////////////////
	 // Get ve Set Metodlari //
	//////////////////////////
    public int getPersonelID() {
        return personelID;
    }

    public void setPersonelID(int personelID) {
        this.personelID = personelID;
    }

	public ArrayList<Musteri> getMusteriler() {
		return musteriler;
	}

	public void setMusteriler(ArrayList<Musteri> musteriler) {
		this.musteriler = musteriler;
	}
      /////////////////////
     // ToString Metodu //
    /////////////////////
}
