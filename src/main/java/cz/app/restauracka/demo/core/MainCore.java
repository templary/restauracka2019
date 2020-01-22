package cz.app.restauracka.demo.core;

import cz.app.restauracka.demo.logika.Data.NactiDataZamestnancu;
import cz.app.restauracka.demo.logika.obj.MenuJidla;
import cz.app.restauracka.demo.logika.obj.Stoly;
import cz.app.restauracka.demo.logika.ovladac.OvladacData;
import cz.app.restauracka.demo.logika.zam.Zamestnanci;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static cz.app.restauracka.demo.logika.Pozice.Kuchar;

@SpringBootApplication(scanBasePackages = {"cz.app.restauracka"})
public class MainCore {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MainCore.class, args);

        Zamestnanci zamestnanci = context.getBean(Zamestnanci.class);
        //TestovaciEntity testovaciEntity = context.getBean(TestovaciEntity.class);
        Stoly stoly = context.getBean(Stoly.class);
        MenuJidla menuJidla = context.getBean(MenuJidla.class);
        OvladacData ovladacData = context.getBean(OvladacData.class);
        NactiDataZamestnancu nactiDataZamestnancu = context.getBean(NactiDataZamestnancu.class);


//        testovaciEntity.vlozZamestnance();
//        testovaciEntity.vlozJidloDoMenu();
//        testovaciEntity.vlozStulDoStolu();
//        testovaciEntity.vytvorObjednavku();




        System.out.println(zamestnanci.getZamestnanciSet());
        System.out.println(zamestnanci.getZamestnanecPodleJmena("Karel").getJmeno());
        System.out.println(zamestnanci.getSetJmenaZamestnancu());
        System.out.println("--" + zamestnanci.getZamestnanecPodleID(1).getPozice().equals(Kuchar));


        //stoly.getStulPodleID(1).setObjednavka(objednavky.getObjednavkaPodleID(1));


        //System.out.println(stoly.getStulPodleID(1).getObjednavka().getObsahObjednavky());
        System.out.println(menuJidla.getMenuSet());
        System.out.println(menuJidla.getNazvyJidel());
        //System.out.println(nactiDataZamestnancu.loadData());



        //gui.startMain();







    }
}
