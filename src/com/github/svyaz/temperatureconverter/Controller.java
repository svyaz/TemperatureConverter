package com.github.svyaz.temperatureconverter;

import com.github.svyaz.temperatureconverter.data.TemperatureScale;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Controller {
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

            int i = 0;
            for (TemperatureScale scale : scales) {
                if (scale == tempScale) {
                    continue;
                }
                view.getResultLabels()[i].setText(scale.toString());
                view.getValueLabels()[i].setText(temp.getTemperatureString(scale));
                i++;
            }
        } catch (NumberFormatException exception) {
            view.showErrorMessage("Entered text is not a number.");
        } catch (IllegalArgumentException exception) {
            view.showErrorMessage(exception.getMessage());
        }
    }
}
