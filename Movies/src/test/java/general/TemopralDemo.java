package general;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.Calendar;

public class TemopralDemo {

    @Test
    void demoNow(){
        var dt = ZonedDateTime.now();
        System.out.println(dt);
    }

    @Test
    void demoNowCalendar(){
        var now = Calendar.getInstance();
        System.out.println(now);
    }
}
