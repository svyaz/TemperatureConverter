package com.github.svyaz.temperatureconverter;

import com.github.svyaz.temperatureconverter.data.TemperatureScale;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame = new JFrame();
    private JLabel enterTempLabel = new JLabel("Enter temperature:");
    private JLabel convertedLabel = new JLabel("Converted:");
    private JLabel[] resultLabels = {new JLabel(""), new JLabel("")};
    private JLabel[] valueLabels = {new JLabel(""), new JLabel("")};
    private JTextField tempField = new JTextField(null, "0.0", 1);
    private JComboBox<TemperatureScale> scaleComboBox = new JComboBox<>();
    private JButton convertButton = new JButton("Convert");

    public View() {
        SwingUtilities.invokeLater(() -> {
            // Set frame
            int frameWidth = 400;
            int frameHeight = 160;
            frame.setSize(frameWidth, frameHeight);
            frame.setTitle("Temperature Converter");
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation(screenSize.width / 2 - frameWidth / 2,
                    screenSize.height / 2 - frameHeight / 2);
            frame.setVisible(true);

            // Set layout and add elements to it
            GroupLayout layout = new GroupLayout(frame.getContentPane());
            frame.getContentPane().setLayout(layout);
            layout.setAutoCreateGaps(true);
            layout.setAutoCreateContainerGaps(true);

            layout.setHorizontalGroup(
                    layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(enterTempLabel)
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(tempField)
                                            .addComponent(scaleComboBox)
                                            .addComponent(convertButton)
                                    )
                                    .addComponent(convertedLabel)
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(resultLabels[0])
                                            .addComponent(valueLabels[0])
                                    )
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(resultLabels[1])
                                            .addComponent(valueLabels[1])
                                    )
                            )
            );

            layout.setVerticalGroup(
                    layout.createSequentialGroup()
                            .addComponent(enterTempLabel)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(tempField)
                                    .addComponent(scaleComboBox)
                                    .addComponent(convertButton)
                            )
                            .addComponent(convertedLabel)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(resultLabels[0])
                                    .addComponent(valueLabels[0])
                            )
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(resultLabels[1])
                                    .addComponent(valueLabels[1])
                            )
            );
        });
    }

    TemperatureScale getSelectedTempScale() {
        return (TemperatureScale) scaleComboBox.getSelectedItem();
    }

    String getTempValue() {
        return tempField.getText();
    }

    JButton getConvertButton() {
        return convertButton;
    }

    void showErrorMessage(String text) {
        JOptionPane.showMessageDialog(frame, text, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    JLabel[] getResultLabels() {
        return resultLabels;
    }

    JLabel[] getValueLabels() {
        return valueLabels;
    }

    JComboBox<TemperatureScale> getScaleComboBox() {
        return scaleComboBox;
    }
}
