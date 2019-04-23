package com.github.svyaz.temperatureconverter.data;

public interface TemperatureScale {
    /**
     * Converts to base temperature (Celsius).
     *
     * @param temp specifies temperature.
     * @return base temperature.
     */
    double convertToBaseTemp(double temp);

    /**
     * Converts specified value from base temperature to this scale.
     *
     * @param temp specifies base temperature.
     * @return converted value from base temperature.
     */
    double convertFromBaseTemp(double temp);
}
