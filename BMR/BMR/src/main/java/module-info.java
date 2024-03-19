module com.example.bmr {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bmr to javafx.fxml;
    exports com.example.bmr;
}