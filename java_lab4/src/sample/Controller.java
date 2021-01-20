package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML TextField fieldBeg;
    @FXML TextField fieldEnd;
    @FXML TextField fieldStep;
    @FXML TextArea fieldTab;

    @FXML Label labelInfo;

    public void calculate() {
        try {
            Function function = new Function(
                    Double.parseDouble(fieldBeg.getText()), Double.parseDouble(fieldEnd.getText()), Double.parseDouble(fieldStep.getText()));
            fieldTab.setText(function.getArrays());
            int min = function.indexMin();
            int max = function.indexMax();
            double sum = function.sumArray();
            double average = function.meanArray();
            labelInfo.setText(String.format("Информация о табуляции:\n" +
                    "Количество табуляций: %d\n" +
                    "Максимум: x = %.7f, y = %.7f\n" +
                    "Минимум: x = %.7f, y = %.7f\n" +
                    "Сумма: %.7f\n" +
                    "Среднее: %.7f\n", function.getStepsCount(), function.getX(max), function.getY(max), function.getX(min), function.getY(min), function.sumArray(), function.meanArray()));
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Некорректные данные");
            alert.setContentText("Проверьте правильность введенных данных");
            alert.showAndWait();
        }
    }

}
