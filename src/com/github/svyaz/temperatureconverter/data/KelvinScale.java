package com.github.svyaz.temperatureconverter.data;

public class KelvinScale implements TemperatureScale {
    private static final String MSG_EXC_ILLEGAL_VALUE = "Temperature in Kelvins should be greater than 0";
    private static final String SCALE_NAME = "Kelvins";

    @Override
    public double convertToAbsTemp(double temp) {
        if (temp < 0) {
            throw new IllegalArgumentException(MSG_EXC_ILLEGAL_VALUE);
        }
        return temp;
    }

    @Override
    public double convertFromAbsTemp(double temp) {
        return temp;
    }

    @Override
    public String toString() {
        return SCALE_NAME;
    }
}
