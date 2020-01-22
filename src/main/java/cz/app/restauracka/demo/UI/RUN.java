package cz.app.restauracka.demo.UI;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cz.app.restauracka"})
public class RUN {

    public static void main(String[] args) {
        Application.launch(GUI.class, args);
    }
}
