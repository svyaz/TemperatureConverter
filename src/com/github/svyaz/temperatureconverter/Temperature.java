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

    double getTemperature() {
        return temperature;
    }
}
