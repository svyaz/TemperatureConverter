package com.github.svyaz.temperatureconverter.data;

public class KelvinScale implements TemperatureScale {
    private static final String MSG_EXC_ILLEGAL_VALUE = "Temperature in Kelvins should be greater than 0";
    private static final String SCALE_NAME = "Kelvins";

    @Override
    public double convertToBaseTemp(double temp) {
        if (temp < 0) {
            throw new IllegalArgumentException(MSG_EXC_ILLEGAL_VALUE);
        }
        return temp - 273.15;
    }

    @Override
    public double convertFromBaseTemp(double temp) {
        return temp + 273.15;
    }

    @Override
    public String toString() {
        return SCALE_NAME;
    }
}
