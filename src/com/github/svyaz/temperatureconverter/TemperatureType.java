package com.github.svyaz.temperatureconverter;

public enum TemperatureType {
    KELVIN("Kelvins"),
    CELSIUS("Celsius degrees"),
    FAHRENHEIT("Fahrenheit degrees");

    private final String text;

    TemperatureType(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
