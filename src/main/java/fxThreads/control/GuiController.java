package fxThreads.control;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class GuiController implements Initializable {
    public LineChart<Number, Number> lineChart;
    public XYChart.Series<Number,Number> graph = new XYChart.Series<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lineChart.getData().add(graph);
        graph.getData().add(new XYChart.Data<>(1,1));
        graph.getData().add(new XYChart.Data<>(2,2));
    }

    public void addData(int i, int i1) {
        //Nedenstående er en kort udgave med en lambdafunktion:
       // Platform.runLater(() -> graph.getData().add(new XYChart.Data<>(i, i1)));
        //Plaform.runLater garanterer at opdateringen sker på FX-tråden og blokerer for tegning -> Undgår race-conditions
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                graph.getData().add(new XYChart.Data<>(i, i1));
            }
        });

    }
}
