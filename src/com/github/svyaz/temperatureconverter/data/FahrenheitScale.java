package com.github.svyaz.temperatureconverter.data;

public class FahrenheitScale implements TemperatureScale {
    private static final String MSG_EXC_ILLEGAL_VALUE = "Temperature in Fahrenheit degrees should be greater than -459.67";
    private static final String SCALE_NAME = "Fahrenheit degrees";

    @Override
    public double convertToAbsTemp(double temp) {
        if (temp < -459.67) {
            throw new IllegalArgumentException(MSG_EXC_ILLEGAL_VALUE);
        }
        return (temp + 459.67) * 5.0 / 9.0;
    }

    @Override
    public double convertFromAbsTemp(double temp) {
        return (temp - 273.15) * 1.8 + 32;
    }

    @Override
    public String toString() {
        return SCALE_NAME;
    }
}
