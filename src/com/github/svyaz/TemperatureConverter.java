package com.github.svyaz;

import com.github.svyaz.temperatureconverter.*;
import com.github.svyaz.temperatureconverter.data.*;

public class TemperatureConverter {
    public static void main(String[] args) {
        Controller controller = new Controller(new Temperature());
        new View(controller, new TemperatureScale[]{
                new CelsiusScale(),
                new FahrenheitScale(),
                new KelvinScale(),
        });
    }
}
