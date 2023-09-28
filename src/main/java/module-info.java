module com.example.m06programmingassignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.mariadb.jdbc;
    requires java.desktop;
    requires java.logging;


    opens com.example.m06programmingassignment2 to javafx.fxml;
    exports com.example.m06programmingassignment2;
    exports database;
    opens database to javafx.fxml;
}