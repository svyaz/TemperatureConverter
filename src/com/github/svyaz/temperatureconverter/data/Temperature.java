package com.github.svyaz.temperatureconverter.data;

import com.github.svyaz.temperatureconverter.data.TemperatureScale;

public class Temperature {
    /**
     * Base temperature value (Celsius)
     */
    private double temperature;

    public void setTemperature(double temperature, TemperatureScale scale) {
        this.temperature = scale.convertToBaseTemp(temperature);
    }

    public double getTemperature() {
        return temperature;
    }
}
