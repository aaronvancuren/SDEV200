module com.example.m05programmingassignment2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m05programmingassignment2 to javafx.fxml;
    exports com.example.m05programmingassignment2;
}