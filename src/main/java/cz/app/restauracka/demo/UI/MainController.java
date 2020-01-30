package cz.app.restauracka.demo.UI;

import cz.app.restauracka.demo.Funkce.ActualTime;
import cz.app.restauracka.demo.logika.Data.NactiDataObjednavek;
import cz.app.restauracka.demo.logika.Data.UlozDataObjednavek;
import cz.app.restauracka.demo.logika.obj.*;
import cz.app.restauracka.demo.logika.ovladac.OvladacData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("main-scene-new.fxml")
public class MainController {
    final ActualTime actualTime = new ActualTime();
    @Autowired
    LoginController loginController;
    @Autowired
    RegistraceController registraceController;
    @Autowired
    PridejJidloController pridejJidloController;
    @Autowired
    Stoly stoly;
    @Autowired
    FxWeaver fxWeaver;
    @Autowired
    MenuJidla menuJidla;
    @Autowired
    OvladacData ovladacData;
    @Autowired
    Objednavky objednavky;
    @Autowired
    ZobrazovacObjednavekManager zobrazovacObjednavekManager;
    @Autowired
    NactiDataObjednavek nactiDataObjednavek;
    @Autowired
    UlozDataObjednavek ulozDataObjednavek;
    @FXML
    private TableView objednaneJidla = new TableView<>();
    @FXML
    private TableColumn<ObjednaneJidlo, String> nazevVybranehoJidla = new TableColumn<>();
    @FXML
    private TableColumn<ObjednaneJidlo, String> mnozstviVybranehoJidla = new TableColumn<>();
    @FXML
    private TableColumn<ObjednaneJidlo, Integer> jednotlivaCenaVybranehoJidla = new TableColumn<>();
    @FXML
    private TableColumn<ObjednaneJidlo, Integer> celkovaCenaVybranehoJidla = new TableColumn<>();

    @FXML
    private TableView vyberPolozek = new TableView<>();
    @FXML
    private TableColumn<Jidlo, String> vyberNazev = new TableColumn<>();
    @FXML
    private TableColumn<Jidlo, Integer> vyberCena = new TableColumn<>();
    @FXML
    private TableColumn<Jidlo, Integer> vyberID = new TableColumn<>();


    @FXML
    private Button buttonLogout;
    @FXML
    private Text jmenoZamMain;
    @FXML
    private Text cisloStolu;
    @FXML
    private Text cislo;
    @FXML
    private Text mezisoucetText;
    @FXML
    private Text danText;
    @FXML
    private Text celkemCenaText;
    private int zvolenyStul = 0;

    private void nactiMenu() {
        vyberNazev.setCellValueFactory(new PropertyValueFactory<>("popis"));
        vyberCena.setCellValueFactory(new PropertyValueFactory<>("cena"));
        vyberID.setCellValueFactory(new PropertyValueFactory<>("id"));

        ObservableList<Jidlo> observableList = FXCollections.observableArrayList(
                menuJidla.getMenuSet()
        );
        vyberPolozek.setItems(observableList);
    }

    public void objednej(ActionEvent actionEvent) {
    }

    public void zaplat(ActionEvent actionEvent) {
    }

    public void pridejMenu(ActionEvent actionEvent) {
        startVytvorJidlo();
    }

    public void pridejUzivatele(ActionEvent actionEvent) {
        startRegistrace();
    }

    public void uzaverka(ActionEvent actionEvent) {

    }

    public void logOut(ActionEvent actionEvent) {
        startMain();
        ovladacData.ulozData();
    }

    public int getZvolenyStul() {
        return zvolenyStul;
    }

    private void setUpStolu() {
        nactiMenu();
        nastavCislaStolu();
        objednavky.vlozObjednavkyDoZobrazovace(zvolenyStul);
        nactiObjednavkyStolu();
        zobrazovacObjednavekManager.vymazSetZobrazovanychJidel();
        zobrazCeny();
        //nactiDataObjednavek.loadData();


    }

    public void akceStul1(ActionEvent actionEvent) {
        //objednanePolozky.setItems(listSetter(stoly.getStulPodleID(1).getObjednavka().getNazeJidlaACenu()));
        zvolenyStul = 1;
        setUpStolu();
    }

    public void akceStul2(ActionEvent actionEvent) {
        //objednanePolozky.setItems(listSetter(stoly.getStulPodleID(2).getObjednavka().getNazeJidlaACenu()));
        zvolenyStul = 2;
        setUpStolu();
    }

    public void akceStul3(ActionEvent actionEvent) {
        //  objednanePolozky.setItems(listSetter(stoly.getStulPodleID(3).getObjednavka().getNazeJidlaACenu()));
        zvolenyStul = 3;
        setUpStolu();
    }

    public void akceStul4(ActionEvent actionEvent) {
//        objednanePolozky.setItems(listSetter(stoly.getStulPodleID(4).getObjednavka().getNazeJidlaACenu()));
        zvolenyStul = 4;
        setUpStolu();
    }

    public void akceStul5(ActionEvent actionEvent) {
//        objednanePolozky.setItems(listSetter(stoly.getStulPodleID(5).getObjednavka().getNazeJidlaACenu()));
        zvolenyStul = 5;
        setUpStolu();
    }

    public void akceStul6(ActionEvent actionEvent) {
//        objednanePolozky.setItems(listSetter(stoly.getStulPodleID(6).getObjednavka().getNazeJidlaACenu()));
        zvolenyStul = 6;
        setUpStolu();
    }

    public void akceStul7(ActionEvent actionEvent) {
        //       objednanePolozky.setItems(listSetter(stoly.getStulPodleID(7).getObjednavka().getNazeJidlaACenu()));
        zvolenyStul = 7;
        setUpStolu();
    }

    public void akceStul8(ActionEvent actionEvent) {
//        objednanePolozky.setItems(listSetter(stoly.getStulPodleID(8).getObjednavka().getNazeJidlaACenu()));
        zvolenyStul = 8;
        setUpStolu();
    }

    public void akceStul9(ActionEvent actionEvent) {
        zvolenyStul = 9;
        setUpStolu();
    }

    private void startMain() {
        Stage stage = (Stage) buttonLogout.getScene().getWindow();

        Scene scene = new Scene(this.fxWeaver.loadView(LoginController.class));
        stage.setScene(scene);
        stage.setTitle("Register Form");
        stage.show();
    }

    private void nastavCislaStolu() {
        cisloStolu.setText("Stůl: " + zvolenyStul);
        cislo.setText("# " + zvolenyStul);
    }

    private void startRegistrace() {
        Stage stage = (Stage) buttonLogout.getScene().getWindow();

        Scene scene = new Scene(this.fxWeaver.loadView(RegistraceController.class));
        stage.setScene(scene);
        stage.setTitle("Register Form");
        stage.show();
    }

    private void nastavJmenoZam() {
        String celeJmeno = loginController.getLoggedZam().getJmeno() + " " + loginController.getLoggedZam().getPrijmeni();
        jmenoZamMain.setText(celeJmeno);
    }

    void setUp() {
        nastavJmenoZam();
    }


    @FXML
    public void vyberPolozekOnClicked(MouseEvent event) {
        if (event.getClickCount() == 2) {
            Jidlo vybraneJidlo = (Jidlo) vyberPolozek.getSelectionModel().getSelectedItem();
            ObjednaneJidlo objednaneJidlo = new ObjednaneJidlo(vybraneJidlo, zvolenyStul, actualTime.getCurrentDate(), actualTime.getCurrentTime(), vybraneJidlo.getId());
            objednavky.vlozObjednaneJidlo(objednaneJidlo);
            objednavky.vlozObjednavkyDoZobrazovace(zvolenyStul);
            ulozDataObjednavek.saveData();
            nactiObjednavkyStolu();
            zobrazovacObjednavekManager.vymazSetZobrazovanychJidel();
            zobrazCeny();
        }
    }

    private void nactiObjednavkyStolu() {
        nazevVybranehoJidla.setCellValueFactory(new PropertyValueFactory<>("nazevJidla"));
        jednotlivaCenaVybranehoJidla.setCellValueFactory(new PropertyValueFactory<>("cenaZaJednotku"));
        mnozstviVybranehoJidla.setCellValueFactory(new PropertyValueFactory<>("mnozstviJidla"));
        celkovaCenaVybranehoJidla.setCellValueFactory(new PropertyValueFactory<>("celkovaCena"));

        ObservableList<ZobrazovacObjednavek> observableList = FXCollections.observableArrayList(
                zobrazovacObjednavekManager.getSetZobrazovanychJidel()
        );
        objednaneJidla.setItems(observableList);
    }


    private void startVytvorJidlo() {
        Stage stage = (Stage) buttonLogout.getScene().getWindow();

        Scene scene = new Scene(this.fxWeaver.loadView(PridejJidloController.class));
        stage.setScene(scene);
        stage.setTitle("Pridaní jídla");
        stage.show();
    }

    private void zobrazCeny() {

        mezisoucetText.setText(Integer.toString(objednavky.getCenaObjednavky(zvolenyStul)));
        double dan = 1.2;
        double dane = objednavky.getCenaObjednavky(zvolenyStul) * dan - (objednavky.getCenaObjednavky(zvolenyStul));
        danText.setText(String.valueOf(Math.round(dane)));
        celkemCenaText.setText(String.valueOf(objednavky.getCenaObjednavky(zvolenyStul) + dane));
    }

}
