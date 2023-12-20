package co.id.test.sales.Utils;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class Utils {
    public int functionNanotimes(){
        LocalTime currentTime = LocalTime.now();

        // Extract the milliseconds part
        return currentTime.getNano() / 1_000_000;
    }
}
