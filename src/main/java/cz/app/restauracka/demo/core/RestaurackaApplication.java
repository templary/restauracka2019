package cz.app.restauracka.demo.core;

import cz.app.restauracka.demo.logika.zam.Zamestnanec;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {"cz.app.restauracka"})
public class RestaurackaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RestaurackaApplication.class, args);

        Zamestnanec zamestnanec = context.getBean(Zamestnanec.class);
        

        //TestovaciEntity testovaciEntity = context.getBean(TestovaciEntity.class);

        //Manager manager = context.getBean(Manager.class);

        //System.out.println(manager.getJmeno());
    }


}
