package cz.app.restauracka.demo.UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.applet.Main;

@Component
@FxmlView("varovani-window.fxml")
public class VarovaniController {
    @Autowired
    FxWeaver fxWeaver;
    @Autowired
    MainController mainController;

    @FXML
    private Text varovaniText;
    @FXML
    private Button buttonVarovaniOK;

    public void handleButtonOK(ActionEvent actionEvent) {
        startRegistrace();
    }

    private void startRegistrace() {
        Stage stage = (Stage) buttonVarovaniOK.getScene().getWindow();

        Scene scene = new Scene(this.fxWeaver.loadView(MainController.class));
        stage.setScene(scene);
        stage.setTitle("Register Form");
        stage.show();
    }

    public void setVarovaniText(String text) {
        varovaniText.setText(text);
    }

}
