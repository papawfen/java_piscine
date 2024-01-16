module edu.school21.app.tanks {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens edu.school21.app.tanks to javafx.fxml;
    exports edu.school21.app.tanks;
}