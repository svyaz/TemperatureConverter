package com.github.svyaz;

import com.github.svyaz.temperatureconverter.*;
import com.github.svyaz.temperatureconverter.data.*;

public class TemperatureConverter {
    public static void main(String[] args) {
        // Create controller with view and model
        new Controller(new View(),
                new Temperature(),
                new TemperatureScale[]{
                        new CelsiusScale(),
                        new FahrenheitScale(),
                        new KelvinScale(),
                });
    }
}
//System.out.println(1.416808e32);
//System.out.println(141680800000000000000000000000000d);