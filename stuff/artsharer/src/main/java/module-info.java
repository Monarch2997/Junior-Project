module com.monarch {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.monarch to javafx.fxml;
    exports com.monarch;
}
