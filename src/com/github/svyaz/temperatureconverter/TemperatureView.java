package com.github.svyaz.temperatureconverter;

import com.github.svyaz.temperatureconverter.data.TemperatureScale;

public interface TemperatureView {
    // Получение значения конвертируемой температуры
    double getTempValue();

    // Получение выбранной шкалы для конвертируемого значения
    TemperatureScale getTempScale();

    // Вывод результатов
    void setResult(double temperature, TemperatureScale scale);

    // Вывод сообщения об ошибке
    void showErrorMessage(String string);
}
