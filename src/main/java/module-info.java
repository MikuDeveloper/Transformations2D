module ttn.developer.transformations2d {
    requires javafx.controls;
    requires javafx.fxml;


    opens ttn.developer.transformations2d to javafx.fxml;
    exports ttn.developer.transformations2d;
}