package cz.app.restauracka.demo.core;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GUI {


    void startMain() {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/scene.fxml"));
            root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Pokemon Game");
            stage.setScene(new Scene(root, 850, 900));
            stage.show();
            stage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
