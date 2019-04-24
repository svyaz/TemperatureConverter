package com.github.svyaz.temperatureconverter;

import com.github.svyaz.temperatureconverter.data.TemperatureScale;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Controller {
    private static final String MSG_EXC_NOT_A_NUMBER = "Entered text is not a number.";
    private Temperature temp;
    private View view;
    private TemperatureScale[] scales;

    public Controller(View view, Temperature temp, TemperatureScale[] scales) {
        this.view = view;
        this.temp = temp;
        this.scales = scales;

        for (TemperatureScale scale : scales) {
            view.getScaleComboBox().addItem(scale);
        }

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
            TemperatureScale tempScale = view.getSelectedTempScale();
            temp.setTemperature(tempValue, tempScale);

            StringBuilder outText = new StringBuilder();
            for (TemperatureScale scale : scales) {
                if (scale == tempScale) {
                    continue;
                }
                outText.append(scale.toString())
                        .append(": ")
                        .append(temp.getTemperatureString(scale))
                        .append(System.lineSeparator());
            }
            view.getResultTextArea().setText(outText.toString());
        } catch (NumberFormatException exception) {
            view.showErrorMessage(MSG_EXC_NOT_A_NUMBER);
        } catch (IllegalArgumentException exception) {
            view.showErrorMessage(exception.getMessage());
        }
    }
}
