package com.github.svyaz.temperatureconverter;

import com.github.svyaz.temperatureconverter.data.TemperatureScale;

public class Temperature {
    /**
     * Absolute temperature value (Kelvins in fact)
     */
    private double temperature;

    void setTemperature(double temperature, TemperatureScale scale) {
        this.temperature = scale.convertToAbsTemp(temperature);
    }

    private double getTemperature(TemperatureScale scale) {
        return scale.convertFromAbsTemp(temperature);
    }

    String getTemperatureString(TemperatureScale scale) {
        return String.format("%.2f", getTemperature(scale));
    }
}
