module JavaFXThreading {
    requires javafx.controls;
    requires javafx.fxml;

    opens fxThreads to javafx.fxml;
    exports fxThreads;
    exports fxThreads.control;
    opens fxThreads.control to javafx.fxml;

}