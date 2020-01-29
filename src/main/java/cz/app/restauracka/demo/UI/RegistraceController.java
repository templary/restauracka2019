package cz.app.restauracka.demo.UI;

import cz.app.restauracka.demo.Funkce.IDChecker;
import cz.app.restauracka.demo.Funkce.Numeric;
import cz.app.restauracka.demo.logika.Data.UlozDataZamestnancu;
import cz.app.restauracka.demo.logika.Pozice;
import cz.app.restauracka.demo.logika.ovladac.OvladacHash;
import cz.app.restauracka.demo.logika.ovladac.OvladacZam;
import cz.app.restauracka.demo.logika.zam.Zamestnanci;
import cz.app.restauracka.demo.logika.zam.Zamestnanec;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

@Component
@FxmlView("registrace-window.fxml")
public class RegistraceController implements Initializable {
    @Autowired
    FxWeaver fxWeaver;
    @Autowired
    MainController mainController;
    @Autowired
    OvladacZam ovladacZam;
    @Autowired
    Zamestnanci zamestnanci;
    @Autowired
    VarovaniController varovaniController;
    @Autowired
    UlozDataZamestnancu ulozDataZamestnancu;
    @Autowired
    OvladacHash ovladacHash;
    @Autowired
    IDChecker idChecker;
    @Autowired
    Numeric numeric;


    @FXML
    private TextField registraceJmeno, registracePrijmeni, registraceNick, registraceTelefon, registraceMail, registraceHeslo;
    @FXML
    private Button buttonVytvor;
    @FXML
    private ComboBox<Pozice> registracePozice = new ComboBox<>();
    @FXML
    private TableView tabulkaUzivatelu = new TableView<>();

    @FXML
    private TableColumn<Zamestnanec, String> registraceTabulkaJmeno = new TableColumn();
    @FXML
    private TableColumn<Zamestnanec, String> registraceTabulkaPrijmeni = new TableColumn();
    @FXML
    private TableColumn<Zamestnanec, Pozice> registraceTabulkaPozice = new TableColumn();
    @FXML
    private TableColumn<Zamestnanec, Integer> registraceTabulkaID = new TableColumn();


    private void startMain() {
        Stage stage = (Stage) buttonVytvor.getScene().getWindow();

        Scene scene = new Scene(this.fxWeaver.loadView(MainController.class));
        stage.setScene(scene);
        stage.setTitle("Register Form");
        stage.show();
    }

    private void startVarovani() {
        Stage stage = (Stage) buttonVytvor.getScene().getWindow();

        Scene scene = new Scene(this.fxWeaver.loadView(VarovaniController.class));
        stage.setScene(scene);
        stage.setTitle("Varovani");
        stage.show();
    }

    private void smazZadaneTexty() {
        registraceHeslo.setText("");
        registraceJmeno.setText("");
        registraceMail.setText("");
        registraceNick.setText("");
        registracePrijmeni.setText("");
        registraceTelefon.setText("");
    }


    @FXML
    private void handleButtonVytvor(ActionEvent actionEvent) {
        String jmeno = registraceJmeno.getText();
        String prijmeni = registracePrijmeni.getText();
        String nick = registraceNick.getText();
        String telefon = registraceTelefon.getText();
        String mail = registraceMail.getText();
        String heslo = registraceHeslo.getText();
        String shaHeslo = ovladacHash.sha512hash(heslo);
        Pozice pozice = registracePozice.getValue();
        //TODO pokud uživatel udělá chybu, vrátit ho na stejnou obrazovku a vyplnit mu vše co vyplnil špatně.

        if (!jmeno.isEmpty() && !prijmeni.isEmpty() && !nick.isEmpty() && !telefon.isEmpty() && !mail.isEmpty() && !heslo.isEmpty() && ovladacZam.checkUniqueNick(nick) && numeric.jeCislo(telefon) ){ //TODO dodělat overeni vybrani pozice.

            idChecker.setId();
            int idZam = idChecker.getProperIDZamestnanec();

            ovladacZam.vytvorNovehoUzivatele(jmeno, prijmeni, nick, idZam, pozice, telefon, mail, shaHeslo);
            ulozDataZamestnancu.saveData();
            zobrazZamestnance();
        } else {
            startVarovani();
            varovaniController.setVarovaniText("Chybně zadané parametry zaměstnance");

        }
    }

    @FXML
    private void handleButtonSmazat(ActionEvent actionEvent) {
        smazZadaneTexty();
    }

    @FXML
    private void handleButtonZpet(ActionEvent actionEvent) {
        startMain();
    }


    private void zobrazZamestnance() {
        registraceTabulkaJmeno.setCellValueFactory(new PropertyValueFactory<>("Jmeno"));
        registraceTabulkaPrijmeni.setCellValueFactory(new PropertyValueFactory<>("Prijmeni"));
        registraceTabulkaPozice.setCellValueFactory(new PropertyValueFactory<>("Pozice"));
        registraceTabulkaID.setCellValueFactory(new PropertyValueFactory<>("id"));

        ObservableList<Zamestnanec> observableList = FXCollections.observableArrayList(
                zamestnanci.getZamestnanciSet()
        );
        tabulkaUzivatelu.setItems(observableList);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        zobrazZamestnance();
        registracePozice.getItems().setAll(Pozice.values());

    }

}
