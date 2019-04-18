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

    public void setTemperature(double temperature, TemperatureType type) {
        switch (type) {
            case KELVIN:
                if (temperature < 0) {
                    throw new IllegalArgumentException(EXC_MSG_ILLEGAL_KELVIN_VALUE);
                }
                this.temperature = temperature;
                break;

            case CELSIUS:
                if (temperature < -273.15) {
                    throw new IllegalArgumentException(EXC_MSG_ILLEGAL_CELSIUS_VALUE);
                }
                this.temperature = temperature + 273.15;
                break;

            case FAHRENHEIT:
                if (temperature < -459.67) {
                    throw new IllegalArgumentException(EXC_MSG_ILLEGAL_FAHRENHEIT_VALUE);
                }
                this.temperature = (temperature + 459.67) * 5.0 / 9.0;
                break;
        }
    }

    private double getTemperature(TemperatureType type) {
        switch (type) {
            case KELVIN:
                return temperature;
            case CELSIUS:
                return temperature - 273.15;
            case FAHRENHEIT:
                return (temperature - 273.15) * 1.8 + 32;
            default:
                return 0.0;
        }
    }

    public String getTemperatureString(TemperatureType type) {
        return String.format("%.2f", getTemperature(type));
    }

    /*public double getTemperatureInKelvins() {
        return temperature;
    }

    public double getTemperatureInCelsius() {
        return temperature - 273.15;
    }

    public double getTemperatureInFahrenheit() {
        return 1.8 * (temperature - 273.15) + 32;
    }

    */
}
