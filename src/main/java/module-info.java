module main.m06programmingassignment1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.mariadb.jdbc;


    opens main.m06programmingassignment1 to javafx.fxml;
    exports main.m06programmingassignment1;
}