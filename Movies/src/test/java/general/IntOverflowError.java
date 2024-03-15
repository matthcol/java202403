package general;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntOverflowError {

    @Test
    void demoIntOverflowModulo(){
        int max = Integer.MAX_VALUE;
        System.out.println(max);
        max += 1;
        System.out.println(max);
        System.out.println(Long.MAX_VALUE + 1);
    }

    @Test
    void demoIntOverflowException(){
        int max = Integer.MAX_VALUE;
//        System.out.println(max);
        Assertions.assertThrows(ArithmeticException.class, () -> Math.addExact(max, 1));
    }
}
