package cinema.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CsvAdapterTest {

    @Test
    void testFromLine_durationNotEmpty(){
        String line = "5257,Excuse Me,1915,50,\"Henry Mallory, U.S.A., receives orders to join his regiment which is to embark for the Philippines. The Overland Limited is the only train that will enable him to reach the coast in time to escape a court-martial. Having a little time to spare he persuades Marjorie to elope with him and reserves two berths. They rea...";
        var movie = CsvAdapter.movieFromLine(line);
        assertEquals("Excuse Me", movie.getTitle());
        assertEquals(1915, movie.getYear());
        assertNotNull(movie.getDuration());
        assertEquals(50, movie.getDuration());
    }

    @Test
    void testFromLine_durationEmpty(){
        String line = "5257,Excuse Me,1915,,\"Henry Mallory, U.S.A., receives orders to join his regiment which is to embark for the Philippines. The Overland Limited is the only train that will enable him to reach the coast in time to escape a court-martial. Having a little time to spare he persuades Marjorie to elope with him and reserves two berths. They rea...";
        var movie = CsvAdapter.movieFromLine(line);
        assertEquals("Excuse Me", movie.getTitle());
        assertEquals(1915, movie.getYear());
        assertNull(movie.getDuration());
    }

}