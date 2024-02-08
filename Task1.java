import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get temperature input from the user
        System.out.print("Enter temperature value: ");
        double temperature = scanner.nextDouble();

        // Get the original unit of measurement
        System.out.print("Enter original unit (C for Celsius, F for Fahrenheit, K for Kelvin): ");
        char originalUnit = scanner.next().charAt(0);

        // Perform temperature conversion
        double convertedTemperatureCelsius = 0.0;
        double convertedTemperatureFahrenheit = 0.0;
        double convertedTemperatureKelvin = 0.0;

        switch (originalUnit) {
            case 'C':
            case 'c':
                convertedTemperatureCelsius = temperature;
                convertedTemperatureFahrenheit = celsiusToFahrenheit(temperature);
                convertedTemperatureKelvin = celsiusToKelvin(temperature);
                break;

            case 'F':
            case 'f':
                convertedTemperatureCelsius = fahrenheitToCelsius(temperature);
                convertedTemperatureFahrenheit = temperature;
                convertedTemperatureKelvin = celsiusToKelvin(fahrenheitToCelsius(temperature));
                break;

            case 'K':
            case 'k':
                convertedTemperatureCelsius = kelvinToCelsius(temperature);
                convertedTemperatureFahrenheit = celsiusToFahrenheit(kelvinToCelsius(temperature));
                convertedTemperatureKelvin = temperature;
                break;

            default:
                System.out.println("Invalid unit of measurement. Please enter C, F, or K.");
                return;
        }

        // Display the converted temperatures
        System.out.println("Converted Temperatures:");
        System.out.println("Celsius: " + convertedTemperatureCelsius + " °C");
        System.out.println("Fahrenheit: " + convertedTemperatureFahrenheit + " °F");
        System.out.println("Kelvin: " + convertedTemperatureKelvin + " K");

        scanner.close();
    }

    // Conversion methods
    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    private static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }
}
