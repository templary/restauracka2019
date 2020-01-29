package cz.app.restauracka.demo.logika.Data;

import com.google.gson.Gson;
import cz.app.restauracka.demo.logika.obj.Stoly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class UlozDataStolu {
    private static final String SAVE_FILE_NAME = "src/main/resources/LocalData/stoly.json";
    @Autowired
    Stoly stoly;
    private final Gson gson = new Gson();


    public void saveData() {
        String json = gson.toJson(stoly.getSetStolu());
        try {
            Files.write(Paths.get(SAVE_FILE_NAME), json.getBytes());
        } catch (IOException e) {
            System.out.println("Error while saving data: " + e.getMessage());
        }
    }
}