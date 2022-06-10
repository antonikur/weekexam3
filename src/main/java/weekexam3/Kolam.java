package weekexam3;

public class Kolam {
	private int tinggi;
	private double panjang, lebar;

	public Kolam(double panjang, double lebar, int tinggi) throws IllegalArgumentException{
		if(tinggi < 0) {
			tinggi = tinggi * -1;
		}
		if(lebar < 0) {
			lebar = lebar * -1;
		}
		if(panjang < 0) {
			panjang = panjang * -1;
		}
		
		
		this.lebar = lebar;
		this.tinggi = tinggi;
		this.panjang = panjang;
	}
	
	public Kolam() {
		lebar = 0;
		tinggi = 0;
		panjang = 0;
	}
	
	public int kelilingKolam() throws IllegalArgumentException {
		int keliling = (int) (4 * (lebar+tinggi+panjang));
		return keliling;
	}
	
	public int volumeAirKolam() throws IllegalArgumentException {
		int volume = (int) (lebar*tinggi*panjang);
		return volume;
	}
}
