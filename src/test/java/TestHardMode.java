import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by jeff on 1/17/17.
 */
public class TestHardMode {
    HardMode hm = new HardMode();
    Movie mowana = new Movie("Mowana", 2017, "G", 150);
    Movie deadpool = new Movie("Deadpool", 2016, "R", 90);
    Movie terminator = new Movie("Terminator", 2016, "PG-13", 150);
    Movie transformers = new Movie("Transformers: Animated Movie", 2016, "PG", 100);
    Movie walle = new Movie("Wall-E", 2015, "G", 20);

    @Test
    public void testCountFile() throws IOException {
        assertEquals(150001, hm.countFile());
    }

    @Test
    public void testAverageFile() throws IOException {
        assertEquals(21.5, hm.averageFile(), 0.1);
    }

    @Test
    public void testGroupByYear(){
        List<Movie> movies = new ArrayList<>();
        movies.add(mowana);
        movies.add(deadpool);
        movies.add(terminator);
        movies.add(transformers);
        movies.add(walle);

        Map<Integer, List<Movie>> years = hm.groupByYear(movies);

        Set<Integer> keys = years.keySet();
        assertEquals(3, keys.size());
        assertTrue(keys.containsAll(Arrays.asList(2015, 2016, 2017)));

        //Test 2015
        assertEquals(1, years.get(2015).size());
        assertTrue(years.get(2015).contains(walle));

        //Test 2016
        assertEquals(3, years.get(2016).size());
        assertTrue(years.get(2016).containsAll(Arrays.asList(deadpool, terminator, transformers)));
    }
}
