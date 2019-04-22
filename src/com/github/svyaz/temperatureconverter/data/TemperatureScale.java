package com.github.svyaz.temperatureconverter.data;

public interface TemperatureScale {
    /**
     * Converts to absolute temperature (in Kelvins).
     *
     * @param temp specified temperature.
     * @return absolute temperature.
     */
    double convertToAbsTemp(double temp);

    /**
     * Converts specified value from absolute to this scale temperature.
     *
     * @param temp specified absolute temperature.
     * @return converted value from absolute temperature.
     */
    double convertFromAbsTemp(double temp);
}
