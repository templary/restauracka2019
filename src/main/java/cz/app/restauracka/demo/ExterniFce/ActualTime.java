package cz.app.restauracka.demo.ExterniFce;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ActualTime {

    public String getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        //System.out.println(sdf.format(cal.getTime()));
        return sdf.format(cal.getTime());
    }

    public String getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //System.out.println(sdf.format(cal.getTime()));
        return sdf.format(cal.getTime());
    }
}
