package cz.app.restauracka.demo.core;

import cz.app.restauracka.demo.UI.GUI;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cz.app.restauracka"})
public class RUN_CORE {

    public static void main(String[] args) {
        Application.launch(GUI.class, args);
    }
}
