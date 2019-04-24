package com.github.svyaz.temperatureconverter.data;

public class CelsiusScale implements TemperatureScale {
    private static final String MSG_EXC_ILLEGAL_VALUE = "Temperature in Celsius degrees should be greater than -273.15";
    private static final String SCALE_NAME = "Celsius degrees";

    @Override
    public double convertToBaseTemp(double temp) {
        if (temp < -273.15) {
            throw new IllegalArgumentException(MSG_EXC_ILLEGAL_VALUE);
        }
        if (temp > MAX_TEMPERATURE) {
            throw new IllegalArgumentException(MSG_EXC_MAX_TEMPERATURE_EXCEEDED);
        }
        return temp;
    }

    @Override
    public double convertFromBaseTemp(double temp) {
        return temp;
    }

    @Override
    public String toString() {
        return SCALE_NAME;
    }
}
