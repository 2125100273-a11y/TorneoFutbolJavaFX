module com.mycompany.torneofutbol {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.torneofutbol to javafx.fxml;
    opens com.mycompany.torneofutbol.controladores to javafx.fxml;
    opens com.mycompany.torneofutbol.modelos to javafx.base;

    exports com.mycompany.torneofutbol;
}
