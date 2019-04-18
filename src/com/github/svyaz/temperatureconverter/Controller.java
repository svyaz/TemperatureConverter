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
        updateView();
    }

    private void registerButtonObserver() {
        view.getConvertButton().addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateView();
            }
        });
    }

    private void updateView() {
        try {
            double tempValue = Double.parseDouble(view.getTempValue());
            TemperatureType tempType = view.getSelectedTempType();
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
        } catch (NumberFormatException exception) {
            view.showErrorMessage("Entered text is not a number.");
        } catch (IllegalArgumentException exception) {
            view.showErrorMessage(exception.getMessage());
        }
    }
}
