package cz.app.restauracka.demo.core;

import cz.app.restauracka.demo.logika.zam.TestovaciEntity;
import cz.app.restauracka.demo.logika.zam.Zamestnanci;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {"cz.app.restauracka"})
public class MainCore {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MainCore.class, args);

        Zamestnanci zamestnanci = context.getBean(Zamestnanci.class);
        //Zamestnanec zamestnanec = context.getBean(Zamestnanec.class);
        TestovaciEntity testovaciEntity = context.getBean(TestovaciEntity.class);

        testovaciEntity.vlozZamestnance();

        System.out.println(zamestnanci.getZamestnanciSet());
        System.out.println(zamestnanci.getZamestnanecPokudExistuje("Karel"));



    }


}
