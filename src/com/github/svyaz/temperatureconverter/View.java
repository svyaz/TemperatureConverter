package com.github.svyaz.temperatureconverter;

import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame;

    public View() {
        SwingUtilities.invokeLater(() -> {
            // Create frame
            int frameWidth = 400;
            int frameHeight = 160;
            frame = new JFrame("Temperature Converter");
            frame.setSize(frameWidth, frameHeight);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setLocation(screenSize.width / 2 - frameWidth / 2,
                    screenSize.height / 2 - frameHeight / 2);
            frame.setVisible(true);

            // Create elements
            JLabel enterTempLabel = new JLabel("Enter temperature:");
            JLabel convertedLabel = new JLabel("Converted:");
            JLabel resultLabel0 = new JLabel("Result0:");
            JLabel resultLabel1 = new JLabel("Result1:");
            JLabel valueLabel0 = new JLabel("0.0");
            JLabel valueLabel1 = new JLabel("0.0");
            JTextField tempField = new JTextField("0.0");
            JComboBox<String> gradeComboBox = new JComboBox<>();
            JButton convertButton = new JButton("Convert");

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
                                            .addComponent(resultLabel0)
                                            .addComponent(valueLabel0)
                                    )
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(resultLabel1)
                                            .addComponent(valueLabel1)
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
                                    .addComponent(resultLabel0)
                                    .addComponent(valueLabel0)
                            )
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(resultLabel1)
                                    .addComponent(valueLabel1)
                            )
            );
        });
    }
}
