import models.Collaborator;
import models.MobileEquip;
import models.Reservation;
import java.time.LocalDate;
import java.util.Calendar;

public class App {

    public static void main(String[] args) {
        Collaborator c = new Collaborator("12345", "Bruno Guerra", "gguerrabruno@outlook.com");
        MobileEquip me = new MobileEquip("1", "iPhone", 150, "Phone");
        Reservation r = new Reservation(c, me, LocalDate.of(2020, Calendar.FEBRUARY, 21), LocalDate.of(2020, Calendar.FEBRUARY, 23));
        System.out.println(me.toString());
        System.out.println(c.toString());
        System.out.println(r.toString());
    }

}
