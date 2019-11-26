package cz.app.restauracka.demo.core;

import cz.app.restauracka.demo.logika.TestovaciEntity;
import cz.app.restauracka.demo.logika.obj.MenuJidla;
import cz.app.restauracka.demo.logika.obj.Objednavky;
import cz.app.restauracka.demo.logika.obj.Stoly;
import cz.app.restauracka.demo.logika.ovladac.OvladacZam;
import cz.app.restauracka.demo.logika.zam.Zamestnanci;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static cz.app.restauracka.demo.logika.Pozice.Kuchar;

@SpringBootApplication(scanBasePackages = {"cz.app.restauracka"})
public class MainCore {
    //TODO dává smysl vytvářet nondefault constr pod Springem?
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MainCore.class, args);

        Zamestnanci zamestnanci = context.getBean(Zamestnanci.class);
        TestovaciEntity testovaciEntity = context.getBean(TestovaciEntity.class);
        Stoly stoly = context.getBean(Stoly.class);
        MenuJidla menuJidla = context.getBean(MenuJidla.class);
        Objednavky objednavky = context.getBean(Objednavky.class);
        OvladacZam ovladacZam = context.getBean(OvladacZam.class);


        testovaciEntity.vlozZamestnance();

        System.out.println(zamestnanci.getZamestnanciSet());
        System.out.println(zamestnanci.getZamestnanecPodleJmena("Karel").getJmeno());
        System.out.println(zamestnanci.getJmenaZamestnancu());
        System.out.println("--" + zamestnanci.getZamestnanecPodleID(1).getPozice().equals(Kuchar));

        testovaciEntity.vlozJidloDoMenu();
        testovaciEntity.vlozStulDoStolu();
        testovaciEntity.vytvorObjednavku();


        stoly.getStulPodleID(1).setObjednavka(objednavky.getObjednavkaPodleID(1));


        System.out.println(stoly.getStulPodleID(1).getObjednavka().getObsahObjednavky());
        System.out.println(menuJidla.getMenuSet());
        System.out.println(menuJidla.getNazvyJidel());




    }


}
