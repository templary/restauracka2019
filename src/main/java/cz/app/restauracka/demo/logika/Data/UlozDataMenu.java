package cz.app.restauracka.demo.logika.Data;

import com.google.gson.Gson;
import cz.app.restauracka.demo.logika.obj.MenuJidla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class UlozDataMenu {
    private static final String SAVE_FILE_NAME = "src/main/resources/LocalData/menu.json";
    @Autowired
    MenuJidla menuJidla;
    private final Gson gson = new Gson();


    public void saveData() {
        String json = gson.toJson(menuJidla.getMenuSet());
        try {
            Files.write(Paths.get(SAVE_FILE_NAME), json.getBytes());
        } catch (IOException e) {
            System.out.println("Error while saving data: " + e.getMessage());
        }
    }
}