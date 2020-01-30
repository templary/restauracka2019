package cz.app.restauracka.demo.UI;

import cz.app.restauracka.demo.core.GUI_START;
import cz.app.restauracka.demo.logika.ovladac.OvladacHash;
import cz.app.restauracka.demo.logika.zam.Zamestnanci;
import cz.app.restauracka.demo.logika.zam.Zamestnanec;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("login-window.fxml")
public class LoginController implements Initializable {

    @Autowired
    Zamestnanci zamestnanci;
    @Autowired
    GUI_START guiRUN;
    @Autowired
    FxWeaver fxWeaver;
    @Autowired
    OvladacHash ovladacHash;
    @Autowired
    MainController mainController;

    private Zamestnanec loggedZam;

    @FXML
    private TextField loginJmeno, loginHeslo;
    @FXML
    private Button loginButton;
    @FXML
    private Text loginInfoText;

    public LoginController() {
        System.out.println("generuju");
    }

    public void handleButtonLogin(ActionEvent actionEvent) {
        loggedZam = zamestnanci.getZamestnanecPodleUzJmeno(loginJmeno.getText());

        if (loggedZam != null) {
            if (loggedZam.getHeslo().equals(ovladacHash.sha512hash(loginHeslo.getText()))) {
                loginInfoText.setText("Prihlasen!");
                //System.out.println(loggedZam.getJmeno());
                startMain();
            } else {
                loginInfoText.setText("Chybné jméno nebo heslo");
            }
        } else {
            loginInfoText.setText("Chybné jméno nebo heslo");
        }

    }

    private void startMain() {
        Stage stage = (Stage) loginButton.getScene().getWindow();

        Scene scene = new Scene(this.fxWeaver.loadView(MainController.class));
        stage.setScene(scene);
        stage.setTitle("Register Form");
        stage.show();
        mainController.setUp();
    }

    Zamestnanec getLoggedZam() {
        return loggedZam;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}