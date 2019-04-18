package com.github.svyaz.temperatureconverter;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame = new JFrame();
    private JLabel enterTempLabel = new JLabel("Enter temperature:");
    private JLabel convertedLabel = new JLabel("Converted:");
    private JLabel[] resultLabels = {new JLabel("Result0:"), new JLabel("Result1:")};
    private JLabel[] valueLabels = {new JLabel("0.0"), new JLabel("1.0")};
    private JTextField tempField = new JTextField("0.0");
    private JComboBox<TemperatureType> gradeComboBox = new JComboBox<>(TemperatureType.values());
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
                                            .addComponent(gradeComboBox)
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
                                    .addComponent(gradeComboBox)
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

    public TemperatureType getSelectedTempType() {
        return (TemperatureType) gradeComboBox.getSelectedItem();
    }

    public String getTempValue() {
        return tempField.getText();
    }

    public JButton getConvertButton() {
        return convertButton;
    }

    public void showErrorMessage(String text) {
        JOptionPane.showMessageDialog(frame, text, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public JLabel[] getResultLabels() {
        return resultLabels;
    }

    public JLabel[] getValueLabels() {
        return valueLabels;
    }
}
