package com.github.svyaz.temperatureconverter;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Controller {
    private Temperature temp;
    private View view;

    public Controller(View view, Temperature temp) {
        this.view = view;
        this.temp = temp;
        registerButtonObserver();
    }

    private void registerButtonObserver() {
        view.getConvertButton().addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String value = view.getTempValue();
                double tempValue;

                try {
                    tempValue = Double.parseDouble(value);
                } catch (NumberFormatException exception) {
                    view.showErrorMessage("Entered text is not a number.");
                    return;
                }

                TemperatureType tempType = view.getSelectedTempType();
                //TODO: обработать исключение на сеттере
                temp.setTemperature(tempValue, tempType);

                int i = 0;
                for (TemperatureType type : TemperatureType.values()) {
                    if (type == tempType) {
                        continue;
                    }
                    view.getResultLabels()[i].setText(type.toString());
                    view.getValueLabels()[i].setText(temp.getTemperatureString(type));
                    i++;
                }
            }
        });
    }
}
