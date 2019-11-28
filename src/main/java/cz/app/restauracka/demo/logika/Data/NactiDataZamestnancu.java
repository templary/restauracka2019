package cz.app.restauracka.demo.logika.Data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cz.app.restauracka.demo.logika.zam.Zamestnanci;
import cz.app.restauracka.demo.logika.zam.Zamestnanec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

@Component
public class NactiDataZamestnancu {
    private static final String SAVE_FILE_NAME = "src/main/resources/LocalData/zamestnanci.json";
    @Autowired
    Zamestnanci zamestnanci;

    private Gson gson = new Gson();

    public void loadData() {

        try {
            List<String> lines = Files.readAllLines(Paths.get(SAVE_FILE_NAME));
            String jsonRaw = String.join("\n", lines);
            Type listOfPersonsType = new TypeToken<Set<Zamestnanec>>() {
            }.getType();
            //zamestnanci = gson.fromJson(jsonRaw, listOfPersonsType);

            zamestnanci.setZamestnanciSet(gson.fromJson(jsonRaw, listOfPersonsType));

        } catch (IOException e) {
            System.out.println("Error while saving data: " + e.getMessage());
        }
    }

}
