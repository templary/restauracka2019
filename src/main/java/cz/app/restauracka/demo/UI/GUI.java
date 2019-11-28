package cz.app.restauracka.demo.UI;

import cz.app.restauracka.demo.logika.Data.UlozDataObjednavek;
import cz.app.restauracka.demo.logika.obj.MenuJidla;
import cz.app.restauracka.demo.logika.obj.Objednavky;
import cz.app.restauracka.demo.logika.obj.Stoly;
import cz.app.restauracka.demo.logika.ovladac.OvladacData;
import cz.app.restauracka.demo.logika.ovladac.OvladacZam;
import cz.app.restauracka.demo.logika.zam.Zamestnanci;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GUI extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        this.applicationContext = new SpringApplicationBuilder()
                .sources(RUN.class)
                .run(args);

        Zamestnanci zamestnanci = applicationContext.getBean(Zamestnanci.class);
        //TestovaciEntity testovaciEntity = applicationContext.getBean(TestovaciEntity.class);
        Stoly stoly = applicationContext.getBean(Stoly.class);
        MenuJidla menuJidla = applicationContext.getBean(MenuJidla.class);
        Objednavky objednavky = applicationContext.getBean(Objednavky.class);
        OvladacZam ovladacZam = applicationContext.getBean(OvladacZam.class);
        UlozDataObjednavek ulozDataObjednavek = applicationContext.getBean(UlozDataObjednavek.class);
        OvladacData ovladacData = applicationContext.getBean(OvladacData.class);
        ovladacData.nactiData();

        //testovaciEntity.vlozZamestnance();
        //testovaciEntity.vlozJidloDoMenu();
        //testovaciEntity.vlozStulDoStolu();
        //testovaciEntity.vytvorObjednavku();

    }

    @Override
    public void start(Stage stage) {

        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(LoginController.class);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        this.applicationContext.close();
        Platform.exit();
    }

}
