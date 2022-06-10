package weekexam3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class TestFahrenheit {

	public Fahrenheit fahrenheit;

	@DisplayName("Fahrenheit ke Celcius-Test Hasil ke Celcius")
	@ParameterizedTest
	@CsvFileSource(resources = "dataFahrenheitKeCelcius.csv", delimiter = ',', numLinesToSkip = 1)
	void testFahrenheitToCelcius(int no, double frhet, double clcis) {
		fahrenheit = new Fahrenheit(frhet);
		double expected = (double) fahrenheit.fahrenheitToCelcius();
		assertEquals(expected, clcis);
	}
	
	@DisplayName("Fahrenheit ke Celcius-Test Error")
	@ParameterizedTest
	@CsvSource({"string"})
	void testFahrenheitToCelciusBukanAngka(String str) {
		assertThrows(IllegalArgumentException.class, ()->{
			fahrenheit = new Fahrenheit(Double.parseDouble(str));
			fahrenheit.fahrenheitToCelcius();
		});
	}

	@DisplayName("Fahrenheit ke Celcius-Test Angka Negatif")
	@ParameterizedTest
	@CsvFileSource(resources = "dataFahrenheitKeCelcius.csv", delimiter = ',', numLinesToSkip = 1)
	void testFahrenheitToCelciusAngkaNegatif (int no, double frhet, double clcis) throws IllegalArgumentException {
		frhet *= -1;
		fahrenheit = new Fahrenheit(frhet);
		double expected = fahrenheit.fahrenheitToCelciusAbsolutePositive();
		
		if(clcis < 0) {
			clcis *= -1;
		}
		
		assertEquals(expected, clcis);
	}
	
	@DisplayName("Fahrenheit ke Celcius-Test Tidak Masuk Angka")
	@Test
	void testFahrenheitToCelciusTidakMasukAngka () throws IllegalArgumentException {
		fahrenheit = new Fahrenheit();
		double expected = fahrenheit.fahrenheitToCelcius();
		assertEquals(expected, 0);
	}

}
