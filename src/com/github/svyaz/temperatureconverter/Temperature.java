package com.github.svyaz.temperatureconverter;

import com.github.svyaz.temperatureconverter.data.TemperatureScale;

public class Temperature {
    /**
     * Base temperature value (Celsius)
     */
    private double temperature;

    void setTemperature(double temperature, TemperatureScale scale) {
        this.temperature = scale.convertToBaseTemp(temperature);
    }

    private double getTemperature(TemperatureScale scale) {
        return scale.convertFromBaseTemp(temperature);
    }

    String getTemperatureString(TemperatureScale scale) {
        return String.format("%.2f", getTemperature(scale));
    }
}
