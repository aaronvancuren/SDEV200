module com.example.m05programmingassignment3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m05programmingassignment3 to javafx.fxml;
    exports com.example.m05programmingassignment3;
}