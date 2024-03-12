package algorithm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AlgoMathTest {

    @Test
    void testPgcd_oneCase() {
        // given
        int a = 15;
        int b = 21;
        // when
        int p = AlgoMath.pgcd(a, b);
        // then
        assertEquals(3, p);
    }

    @ParameterizedTest
    @CsvSource({
            "15,21,3",
            "21,15,3",
            "1,15,1",
            "15,1,1",
            "1,1,1",
            "100,100,100"
    })
    void testPgcd(int a, int b, int expected){
        // when
        int p = AlgoMath.pgcd(a, b);
        // then
        assertEquals(expected, p);
    }

    @Test
    void testFibo() {
    }

    @Test
    void testFiboOpt() {
    }
}