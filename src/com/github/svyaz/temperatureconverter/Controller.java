package com.github.svyaz.temperatureconverter;

public class Controller {
    private Temperature temp;
    private View view;

    public Controller(View view, Temperature temp) {
        this.view = view;
        this.temp = temp;
    }
}
