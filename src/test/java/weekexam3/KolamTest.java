package weekexam3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class KolamTest {

	public Kolam kolam;

	@DisplayName("Keliling Kolam-Test Hitung Keliling")
	@ParameterizedTest
	@CsvFileSource(resources = "dataKelilingKolam.csv", delimiter = ',', numLinesToSkip = 1)
	void testKelilingKolam(int no, double panjang, double lebar, int tinggi, int hasil) throws IllegalArgumentException {
		kolam = new Kolam(panjang, lebar, tinggi);
		int expected = kolam.kelilingKolam();
		assertEquals(expected, hasil);
		
	}
	
	@DisplayName("Keliling Kolam-Test Error")
	@ParameterizedTest
	@CsvSource({"string"})
	void testKelilingKolamBukanAngka(String str) {
		assertThrows(IllegalArgumentException.class, ()->{
			kolam = new Kolam(123, 0, Integer.parseInt(str));
			kolam.kelilingKolam();
		});
	}

	@DisplayName("Keliling Kolam-Test Angka Negatif")
	@ParameterizedTest
	@CsvFileSource(resources = "dataKelilingKolam.csv", delimiter = ',', numLinesToSkip = 1)
	void testKelilingKolamAngkaNegatif (int no, double panjang, double lebar, int tinggi, int hasil) throws IllegalArgumentException {
		panjang*= -1;
		lebar*= -1;
		tinggi*= -1;
		kolam = new Kolam(panjang, lebar, tinggi);
		int expected = kolam.kelilingKolam();
		assertEquals(expected, hasil);
	}
	
	@DisplayName("Keliling Kolam-Test Tidak Masuk Angka")
	@Test
	void testKelilingKolamTidakMasukAngka () throws IllegalArgumentException {
		kolam = new Kolam();
		int expected = kolam.kelilingKolam();
		assertEquals(expected, 0);
	}
	
	//#############################################################################
	
	@DisplayName("Volume Air Kolam-Test Hitung Volume Air")
	@ParameterizedTest
	@CsvFileSource(resources = "dataVolumeAirKolam.csv", delimiter = ',', numLinesToSkip = 1)
	void testVolumeAirKolam(int no, double panjang, double lebar, int tinggi, int hasil) {
		kolam = new Kolam(panjang, lebar, tinggi);
		int expected = kolam.volumeAirKolam();
		assertEquals(expected, hasil);
	}
	
	@DisplayName("Volume Air Kolam-Test Error")
	@ParameterizedTest
	@CsvSource({"string"})
	void testVolumeAirKolamBukanAngka(String str) {
		assertThrows(IllegalArgumentException.class, ()->{
			kolam = new Kolam(123, 0, Integer.parseInt(str));
			kolam.volumeAirKolam();
		});
	}

	@DisplayName("Volume Air Kolam-Test Angka Negatif")
	@ParameterizedTest
	@CsvFileSource(resources = "dataVolumeAirKolam.csv", delimiter = ',', numLinesToSkip = 1)
	void testVolumeAirKolamAngkaNegatif (int no, double panjang, double lebar, int tinggi, int hasil) throws IllegalArgumentException {
		panjang*= -1;
		lebar*= -1;
		tinggi*= -1;
		kolam = new Kolam(panjang, lebar, tinggi);
		int expected = kolam.volumeAirKolam();
		assertEquals(expected, hasil);
	}
	
	@DisplayName("Volume Air Kolam-Test Tidak Masuk Angka")
	@Test
	void testVolumeAirKolamTidakMasukAngka () throws IllegalArgumentException {
		kolam = new Kolam();
		int expected = kolam.volumeAirKolam();
		assertEquals(expected, 0);
	}

}
