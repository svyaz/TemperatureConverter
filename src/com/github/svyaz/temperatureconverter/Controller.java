package com.github.svyaz.temperatureconverter;

import com.github.svyaz.temperatureconverter.data.Temperature;
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

        view.setScales(scales);
        registerConvertButtonObserver();
        updateView();
    }

    private void registerConvertButtonObserver() {
        view.getConvertButton().addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateView();
            }
        });
    }

    private void updateView() {
        try {
            double tempValue = view.getTempValue();
            TemperatureScale tempScale = view.getSelectedTempScale();
            temp.setTemperature(tempValue, tempScale);
            view.setResult(temp.getTemperature(), tempScale, scales);
        } catch (NumberFormatException exception) {
            view.showErrorMessage(MSG_EXC_NOT_A_NUMBER);
        } catch (IllegalArgumentException exception) {
            view.showErrorMessage(exception.getMessage());
        }
    }
}
