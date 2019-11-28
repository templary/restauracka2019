package cz.app.restauracka.demo.UI;

import cz.app.restauracka.demo.logika.Pozice;
import cz.app.restauracka.demo.logika.ovladac.OvladacZam;
import cz.app.restauracka.demo.logika.zam.Zamestnanci;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("add.fxml")
public class NovyUzivatelController {
    @Autowired
    FxWeaver fxWeaver;
    @Autowired
    MainController mainController;
    @Autowired
    OvladacZam ovladacZam;
    @Autowired
    Zamestnanci zamestnanci;
    @FXML
    private TextField registraceJmeno, registracePrijmeni, registraceNick, registraceTelefon, registraceMail, registraceHeslo;

    @FXML
    private Button buttonVytvor;

    @FXML
    private void handleButtonVytvor(ActionEvent actionEvent) {
        String jmeno = registraceJmeno.getText();
        String prijmeni = registracePrijmeni.getText();
        String nick = registraceNick.getText();
        int telefon = Integer.parseInt(registraceTelefon.getText());
        String mail = registraceMail.getText();
        String heslo = registraceHeslo.getText();


        //TODO pridat volbu pozice, automatizovat ID

        ovladacZam.vytvorNovehoUzivatele(jmeno, prijmeni, nick, 111, Pozice.Kuchar, telefon, mail, heslo);

        System.out.println(zamestnanci.getZamestnanecPodleID(111).getJmeno());
        //startMain();
    }

    @FXML
    private void handleButtonZrusit(ActionEvent actionEvent) {
        startMain();
    }

    private void startMain() {
        Stage stage = (Stage) buttonVytvor.getScene().getWindow();

        Scene scene = new Scene(this.fxWeaver.loadView(MainController.class));
        stage.setScene(scene);
        stage.setTitle("Register Form");
        stage.show();
    }


}
