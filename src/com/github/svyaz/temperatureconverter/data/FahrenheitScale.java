package com.github.svyaz.temperatureconverter.data;

public class FahrenheitScale implements TemperatureScale {
    private static final String MSG_EXC_ILLEGAL_VALUE = "Temperature in Fahrenheit degrees should be greater than -459.67";
    private static final String SCALE_NAME = "Fahrenheit degrees";

    @Override
    public double convertToBaseTemp(double temp) {
        if (temp < -459.67) {
            throw new IllegalArgumentException(MSG_EXC_ILLEGAL_VALUE);
        }
        return (temp - 32.0) * 5.0 / 9.0;
    }

    @Override
    public double convertFromBaseTemp(double temp) {
        return temp * 9.0 / 5.0 + 32;
    }

    @Override
    public String toString() {
        return SCALE_NAME;
    }
}
