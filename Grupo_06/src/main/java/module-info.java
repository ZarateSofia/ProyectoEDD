module com.mycompany.grupo_06 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.grupo_06 to javafx.fxml;
    exports com.mycompany.grupo_06;
}
