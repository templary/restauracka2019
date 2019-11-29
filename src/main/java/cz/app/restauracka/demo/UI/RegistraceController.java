package cz.app.restauracka.demo.UI;

import cz.app.restauracka.demo.logika.Pozice;
import cz.app.restauracka.demo.logika.ovladac.OvladacZam;
import cz.app.restauracka.demo.logika.zam.Zamestnanci;
import cz.app.restauracka.demo.logika.zam.Zamestnanec;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
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


    @FXML
    private TextField registraceJmeno, registracePrijmeni, registraceNick, registraceTelefon, registraceMail, registraceHeslo;
    @FXML
    private Button buttonVytvor;
    @FXML
    private ComboBox<Pozice> registracePozice = new ComboBox<>();
    @FXML
    private TableView<Zamestnanec> tabulkaUzivatelu;

    @FXML
    private TableColumn<Zamestnanec, String> registraceTabulkaJmeno = new TableColumn();
    @FXML
    private TableColumn<Zamestnanec, String> registraceTabulkaPrijmeni = new TableColumn();
    @FXML
    private TableColumn<Zamestnanec, Pozice> registraceTabulkaPozice = new TableColumn();
    @FXML
    private TableColumn<Zamestnanec, Integer> registraceTabulkaID = new TableColumn();


    public void setup() {

    }

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

    private Boolean overeniVstupu() {
        return registraceJmeno.getText() != null && registracePrijmeni.getText() != null && registraceNick.getText() != null && registraceTelefon.getText() != null && registraceMail.getText() != null && registraceHeslo.getText() != null && registracePozice.getValue() != null;
    }

    @FXML
    private void handleButtonVytvor(ActionEvent actionEvent) {
        if (!overeniVstupu()) {
            String jmeno = registraceJmeno.getText();
            String prijmeni = registracePrijmeni.getText();
            String nick = registraceNick.getText();
            String telefon = registraceTelefon.getText();
            String mail = registraceMail.getText();
            String heslo = registraceHeslo.getText();
            Pozice pozice = registracePozice.getValue();
            int idZam = ovladacZam.idGenerator();

            ovladacZam.vytvorNovehoUzivatele(jmeno, prijmeni, nick, idZam, pozice, telefon, mail, heslo);
        } else {
            startVarovani();
            varovaniController.setVarovaniText("Chybně zadané parametry zaměstnance");

        }
        //startMain();
    }

    @FXML
    private void handleButtonSmazat(ActionEvent actionEvent) {
        smazZadaneTexty();
    }

    @FXML
    private void handleButtonZpet(ActionEvent actionEvent) {
        startMain();
    }

    private ObservableList<String> listSetter(Set<String> stringSet) {
        return FXCollections.observableArrayList(stringSet);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registracePozice.getItems().setAll(Pozice.values());

        //TODO zprovoznit zobrazování uživatelů.
        registraceTabulkaJmeno.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getJmeno()));

//        for (Zamestnanec zamestnanec : zamestnanci.getZamestnanciSet()) {
//            registraceTabulkaJmeno.setCellValueFactory(listSetter(zamestnanci.getSetJmenaZamestnancu()));
//        }
    }
}
