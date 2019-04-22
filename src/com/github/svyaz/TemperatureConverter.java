package com.github.svyaz;

import com.github.svyaz.temperatureconverter.*;
import com.github.svyaz.temperatureconverter.data.*;

public class TemperatureConverter {
    public static void main(String[] args) {
        // Create controller with view and model
        new Controller(new View(),
                new Temperature(),
                new TemperatureScale[]{
                        new KelvinScale(),
                        new CelsiusScale(),
                        new FahrenheitScale()
                });
    }
}
