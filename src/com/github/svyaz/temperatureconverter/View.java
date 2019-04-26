package com.github.svyaz.temperatureconverter;

import com.github.svyaz.temperatureconverter.data.TemperatureScale;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;

public class View {
    private JFrame frame = new JFrame();
    private JLabel enterTempLabel = new JLabel("Enter temperature:");
    private JLabel convertedLabel = new JLabel("Converted:");
    private JTextArea resultTextArea = new JTextArea();
    private JTextField tempField = new JTextField(null, "0.0", 1);
    private JComboBox<TemperatureScale> scaleComboBox = new JComboBox<>();
    private JButton convertButton = new JButton("Convert");
    private JButton copyButton = new JButton("Copy");

    public View() {
        SwingUtilities.invokeLater(() -> {
            // Set system look and feel
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignore) {
            }

            // Set frame
            int frameWidth = 440;
            int frameHeight = 210;
            frame.setSize(frameWidth, frameHeight);
            frame.setTitle("Temperature Converter");
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation(screenSize.width / 2 - frameWidth / 2,
                    screenSize.height / 2 - frameHeight / 2);
            frame.setVisible(true);

            // Set elements
            resultTextArea.setEditable(false);

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
                                    .addComponent(resultTextArea)
                                    .addComponent(copyButton)
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
                            .addComponent(resultTextArea)
                            .addComponent(copyButton)
            );
        });
        registerCopyButtonObserver();
    }

    private void registerCopyButtonObserver() {
        copyButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copyToClipboard();
            }
        });
    }

    void setScales(TemperatureScale[] scales) {
        for (TemperatureScale scale : scales) {
            scaleComboBox.addItem(scale);
        }
    }

    void setResult(double temperature, TemperatureScale scale, TemperatureScale[] scales) {
        StringBuilder outText = new StringBuilder();
        for (TemperatureScale tempScale : scales) {
            if (scale == tempScale) {
                continue;
            }
            outText.append(tempScale.toString())
                    .append(": ")
                    .append(String.format("%.2f%n", tempScale.convertFromBaseTemp(temperature)));
        }
        resultTextArea.setText(outText.toString());
    }

    TemperatureScale getSelectedTempScale() {
        return (TemperatureScale) scaleComboBox.getSelectedItem();
    }

    private void copyToClipboard() {
        StringSelection stringSelection = new StringSelection(resultTextArea.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    double getTempValue() {
        return Double.parseDouble(tempField.getText());
    }

    JButton getConvertButton() {
        return convertButton;
    }

    void showErrorMessage(String text) {
        JOptionPane.showMessageDialog(frame, text, "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
