package com.github.svyaz.temperatureconverter.data;

public interface TemperatureScale {
    /**
     * Theoretically, the maximum possible temperature. Planck temperature.
     */
    double MAX_TEMPERATURE = 1.416808e32;

    /**
     *
     */
    String MSG_EXC_MAX_TEMPERATURE_EXCEEDED = "Maximum possible temperature 1.416808e32 exceeded.\nMay be you need more specific program\nthan just this simple converter?";

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
