package cz.app.restauracka.demo.UI;

import cz.app.restauracka.demo.core.RUN_CORE;
import cz.app.restauracka.demo.logika.ovladac.OvladacData;
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
                .sources(RUN_CORE.class)
                .run(args);

        OvladacData ovladacData = applicationContext.getBean(OvladacData.class);
        ovladacData.nactiData();
    }

    @Override
    public void start(Stage stage) {

        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(LoginController.class);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    @Override
    public void stop() {
        this.applicationContext.close();
        Platform.exit();
    }

}
