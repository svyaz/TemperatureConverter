package com.github.svyaz.temperatureconverter;

public class Temperature {
    private static final String EXC_MSG_ILLEGAL_KELVIN_VALUE = "Temperature in Kelvins should be greater than 0";

    /**
     * Absolute temperature value (in Kelvins)
     */
    private double baseTemp;

    public Temperature() {
        this.baseTemp = 273.15;
    }

    public void setBaseTemp(double baseTemp) {
        if (baseTemp < 0) {
            throw new IllegalArgumentException(EXC_MSG_ILLEGAL_KELVIN_VALUE);
        }
        this.baseTemp = baseTemp;
    }

    public double getBaseTemp() {
        return baseTemp;
    }
}
