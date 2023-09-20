module com.example.m05programmingassignment1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.m05programmingassignment1 to javafx.fxml;
    exports com.example.m05programmingassignment1;
}