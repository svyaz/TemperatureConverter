package com.github.svyaz.temperatureconverter;

public class Temperature {
    private static final String EXC_MSG_ILLEGAL_KELVIN_VALUE = "Temperature in Kelvins should be greater than 0";
    private static final String EXC_MSG_ILLEGAL_CELSIUS_VALUE = "Temperature in Celsius degrees should be greater than -273.15";
    private static final String EXC_MSG_ILLEGAL_FAHRENHEIT_VALUE = "Temperature in Fahrenheit degrees should be greater than -459.67";

    /**
     * Absolute temperature value (Kelvins in fact)
     */
    private double temperature;

    public Temperature() {
        this.temperature = 273.15 + 36.6;
    }

    public double getTemperatureInKelvins() {
        return temperature;
    }

    public double getTemperatureInCelsius() {
        return temperature - 273.15;
    }

    public double getTemperatureInFahrenheit() {
        return 1.8 * (temperature - 273.15) + 32;
    }

    public void setTemperatureInKelvins(double kelvinsTemp) {
        if (kelvinsTemp < 0) {
            throw new IllegalArgumentException(EXC_MSG_ILLEGAL_KELVIN_VALUE);
        }
        this.temperature = kelvinsTemp;
    }

    public void setTemperatureInCelsius(double celsiusTemp) {
        if (celsiusTemp < -273.15) {
            throw new IllegalArgumentException(EXC_MSG_ILLEGAL_CELSIUS_VALUE);
        }
        this.temperature = celsiusTemp + 273.15;
    }

    public void setTemperatureInFahrenheit(double fahrenheitTemp) {
        if (fahrenheitTemp < -459.67) {
            throw new IllegalArgumentException(EXC_MSG_ILLEGAL_FAHRENHEIT_VALUE);
        }
        this.temperature = fahrenheitTemp + 273.15;
    }
}
