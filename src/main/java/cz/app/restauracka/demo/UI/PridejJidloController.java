package cz.app.restauracka.demo.UI;


import cz.app.restauracka.demo.logika.Data.UlozDataMenu;
import cz.app.restauracka.demo.logika.obj.Jidlo;
import cz.app.restauracka.demo.logika.obj.MenuJidla;
import cz.app.restauracka.demo.logika.ovladac.OvladacObj;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("pridej-jidlo-window.fxml")
public class PridejJidloController implements Initializable {
    @Autowired
    FxWeaver fxWeaver;
    @Autowired
    MainController mainController;
    @Autowired
    OvladacObj ovladacObj;
    @Autowired
    VarovaniController varovaniController;
    @Autowired
    UlozDataMenu ulozDataMenu;
    @Autowired
    MenuJidla menuJidla;


    @FXML
    private TextField vytvorJidloNazev, vytvorJidloPopis, vytvorJidloCena;
    @FXML
    private Button buttonVytvor;
    @FXML
    private TableView tabulkaJidla = new TableView<>();

    @FXML
    private TableColumn<Jidlo, String> vytvorJidloTabulkaNazev = new TableColumn();
    @FXML
    private TableColumn<Jidlo, Integer> vytvorJidloTabulkaCena = new TableColumn();
    @FXML
    private TableColumn<Jidlo, Integer> vytvorJidloTabulkaID = new TableColumn();


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
        vytvorJidloCena.setText("");
        vytvorJidloNazev.setText("");
        vytvorJidloPopis.setText("");
    }


    @FXML
    private void handleButtonVytvor(ActionEvent actionEvent) {
        if (1 == 1) { //TODO dodělat ověření!!!!
            String nazev = vytvorJidloNazev.getText();
            String popis = vytvorJidloPopis.getText();
            int cena = Integer.parseInt(vytvorJidloCena.getText());
            int idJidla = ovladacObj.idGenerator();

            ovladacObj.vytvorNoveJidlo(idJidla, nazev, popis, cena);
            ulozDataMenu.saveData();
            zobrazJidla();
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

    private void zobrazJidla() {
        vytvorJidloTabulkaNazev.setCellValueFactory(new PropertyValueFactory<>("popis"));
        vytvorJidloTabulkaCena.setCellValueFactory(new PropertyValueFactory<>("cena"));
        vytvorJidloTabulkaID.setCellValueFactory(new PropertyValueFactory<>("id"));

        ObservableList<Jidlo> observableList = FXCollections.observableArrayList(
                menuJidla.getMenuSet()
        );
        tabulkaJidla.setItems(observableList);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        zobrazJidla();
    }
}
