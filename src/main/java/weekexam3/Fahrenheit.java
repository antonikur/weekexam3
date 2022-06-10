package weekexam3;

import java.util.Locale;

public class Fahrenheit {
	private double fahrenheit;
	
	public Fahrenheit(double fahrenheit) throws IllegalArgumentException{
		if(fahrenheit < 0) {
			fahrenheit *= -1;
		}
		
		this.fahrenheit = fahrenheit;
	}
	
	public Fahrenheit() {
		fahrenheit = 0;
	}
	
	public double fahrenheitToCelcius() throws IllegalArgumentException{
		
		//if fahrenheit is 0
		if(fahrenheit == 0) {
			return 0;
		}
		
		//if F is not 0
		double celcius = (fahrenheit - 32) *5/9;
		String format = "";
		if(celcius - Math.floor(celcius) > 0) {
			if(celcius < 0) {//negatif 9 digit decimal
				format = String.format(Locale.US, "%.9f",celcius);
				celcius = Double.parseDouble(format);
			} else {//positif 8 digit decimal
				format = String.format(Locale.US, "%.8f",celcius);
				celcius = Double.parseDouble(format);
			}
			
		}
		return celcius;
	}
	
	public double fahrenheitToCelciusAbsolutePositive() throws IllegalArgumentException{
		double celcius = fahrenheitToCelcius();
		if(celcius < 0) {
			celcius *= -1;
		}
		return celcius;
	}
	
}
