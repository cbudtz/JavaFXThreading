package fxThreads;

import fxThreads.control.GuiController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;

public class FXThreads extends Application {
    private final FXMLLoader loader = new FXMLLoader();
    private Stage stage;
    GuiController guiController;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage=stage;
        Scene scene = loadScene("/gui.fxml");
        guiController = loader.getController();
        stage.setScene(scene);
        stage.show();

        new Thread(()-> {
            for (int i =3;;i++){
                try {
                    Thread.sleep(10);
                    guiController.addData(i,i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        ).start();
    }

    private Scene loadScene(String fxml) throws IOException {
        loader.setLocation(getClass().getResource(fxml));
        return loader.load();
    }
}
