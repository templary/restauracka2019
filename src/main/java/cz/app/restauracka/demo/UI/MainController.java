package cz.app.restauracka.demo.UI;

import cz.app.restauracka.demo.logika.obj.Jidlo;
import cz.app.restauracka.demo.logika.obj.MenuJidla;
import cz.app.restauracka.demo.logika.obj.Stoly;
import cz.app.restauracka.demo.logika.ovladac.OvladacData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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

import java.util.HashSet;
import java.util.Set;

@Component
@FxmlView("main-scene-new.fxml")
public class MainController {
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

    @FXML
    private ListView<String> objednanePolozky = new ListView<>();
    @FXML
    private TableView vyberPolozek = new TableView<>();
    @FXML
    private TableColumn<Jidlo, String> vyberNazev = new TableColumn();
    @FXML
    private TableColumn<Jidlo, Integer> vyberCena = new TableColumn();
    @FXML
    private TableColumn<Jidlo, Integer> vyberID = new TableColumn();
    @FXML
    private Button buttonLogout;
    @FXML
    private Text jmenoZamMain;
    @FXML
    private Text cisloStolu;
    @FXML
    private Text cislo;


    private Jidlo vybraneJidlo;
    Set<Jidlo> objednavkovySet = new HashSet<>();


    private ObservableList<String> listSetter(Set<String> stringSet) {
        return FXCollections.observableArrayList(stringSet);
    }

    private void nactiMenu() {
        vyberNazev.setCellValueFactory(new PropertyValueFactory<>("popis")); //TODO proč funguje popis a ne název??
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
        // registraceController.setup();
    }

    public void uzaverka(ActionEvent actionEvent) {
        //TODO test
        ovladacData.nactiData();
        System.out.println(stoly.getStulPodleID(1).getObjednavka());

    }

    private int zvolenyStul = 0;

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
//        objednanePolozky.setItems(listSetter(stoly.getStulPodleID(9).getObjednavka().getNazeJidlaACenu()));
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

    private void pridejJidloStolu() {
        //TODO  Objednavka objednavka = new Objednavka() jak?????
    }

    @FXML
    public void vyberPolozekOnClicked(MouseEvent event) {
        if (event.getClickCount() == 2) {
            //System.out.println(vyberPolozek.getSelectionModel().getSelectedItem());
            vybraneJidlo = (Jidlo) vyberPolozek.getSelectionModel().getSelectedItem();
            //System.out.println(vybraneJidlo.getPopis());
        }
    }


    private void startVytvorJidlo() {
        Stage stage = (Stage) buttonLogout.getScene().getWindow();

        Scene scene = new Scene(this.fxWeaver.loadView(PridejJidloController.class));
        stage.setScene(scene);
        stage.setTitle("Pridaní jídla");
        stage.show();
    }

}
