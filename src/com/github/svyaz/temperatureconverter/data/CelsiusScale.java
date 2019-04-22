package com.github.svyaz.temperatureconverter.data;

public class CelsiusScale implements TemperatureScale {
    private static final String MSG_EXC_ILLEGAL_VALUE = "Temperature in Celsius degrees should be greater than -273.15";
    private static final String SCALE_NAME = "Celsius degrees";

    @Override
    public double convertToAbsTemp(double temp) {
        if (temp < -273.15) {
            throw new IllegalArgumentException(MSG_EXC_ILLEGAL_VALUE);
        }
        return temp + 273.15;
    }

    @Override
    public double convertFromAbsTemp(double temp) {
        return temp - 273.15;
    }

    @Override
    public String toString() {
        return SCALE_NAME;
    }
}
