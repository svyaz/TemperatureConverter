package com.github.svyaz.temperatureconverter;

import com.github.svyaz.temperatureconverter.data.Temperature;
import com.github.svyaz.temperatureconverter.data.TemperatureScale;

public class Controller {
    private static final String MSG_EXC_NOT_A_NUMBER = "Entered text is not a number.";
    private Temperature temp;

    public Controller(Temperature temp) {
        this.temp = temp;
    }

    void updateView(TemperatureView view) {
        try {
            double tempValue = view.getTempValue();
            TemperatureScale tempScale = view.getTempScale();
            temp.setTemperature(tempValue, tempScale);
            view.setResult(temp.getTemperature(), tempScale);
        } catch (NumberFormatException exception) {
            view.showErrorMessage(MSG_EXC_NOT_A_NUMBER);
        } catch (IllegalArgumentException exception) {
            view.showErrorMessage(exception.getMessage());
        }
    }
}
