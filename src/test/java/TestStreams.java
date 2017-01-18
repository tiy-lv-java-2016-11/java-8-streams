import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by jeff on 1/17/17.
 */
public class TestStreams {

    Streams s = new Streams();
    Movie mowana = new Movie("Mowana", 2016, "G", 150);
    Movie deadpool = new Movie("Deadpool", 2016, "R", 90);
    Movie terminator = new Movie("Terminator", 2016, "PG-13", 150);
    Movie transformers = new Movie("Transformers: Animated Movie", 2016, "PG", 100);
    Movie walle = new Movie("Wall-E", 2015, "G", 20);

    @Test
    public void testGetLongMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("FooLong1", 2016, "G", 150));
        movies.add(new Movie("FooShort2", 2016, "G", 90));
        movies.add(new Movie("FooLong2", 2016, "G", 150));
        movies.add(new Movie("FooShort3", 2016, "G", 100));
        movies.add(new Movie("FooShort4", 2016, "G", 20));

        List<Movie> longMovies = s.getLongMovies(movies);
        assertEquals(2, longMovies.size());
        assertEquals(longMovies.get(0).getTitle(), "FooLong1");
        assertEquals(longMovies.get(1).getTitle(), "FooLong2");
    }

    @Test
    public void testGetKidMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(mowana);
        movies.add(deadpool);
        movies.add(terminator);
        movies.add(transformers);
        movies.add(walle);

        List<Movie> kidMovies = s.getKidMovies(movies);
        assertEquals(3, kidMovies.size());
        assertTrue(kidMovies.contains(walle));
        assertTrue(kidMovies.contains(transformers));
        assertTrue(kidMovies.contains(mowana));
    }

    @Test
    public void testGetDistinctMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(walle);
        movies.add(terminator);
        movies.add(walle);

        List<Movie> dMovies = s.getDistinctMovies(movies);
        assertEquals(2, dMovies.size());
        assertTrue(dMovies.contains(walle));
        assertTrue(dMovies.contains(terminator));
    }

    @Test
    public void testGetFirst2MoviesShortTitle(){
        List<Movie> movies = new ArrayList<>();
        movies.add(mowana);
        movies.add(deadpool);
        movies.add(terminator);
        movies.add(transformers);
        movies.add(walle);

        List<Movie> shortMovies = s.getFirst2MoviesShortTitle(movies);
        assertEquals(2, shortMovies.size());
        assertTrue(shortMovies.contains(mowana));
        assertTrue(shortMovies.contains(deadpool));
    }

    @Test
    public void testSortMoviesByTitle(){
        List<Movie> movies = new ArrayList<>();
        movies.add(mowana);
        movies.add(deadpool);
        movies.add(terminator);
        movies.add(transformers);
        movies.add(walle);

        List<Movie> sorted = s.sortMoviesByTitle(movies);
        assertEquals(5, sorted.size());
        assertEquals(deadpool, sorted.get(0));
        assertEquals(walle, sorted.get(4));
    }

    @Test
    public void testReverseSortedByTitle(){
        List<Movie> movies = new ArrayList<>();
        movies.add(mowana);
        movies.add(deadpool);
        movies.add(terminator);
        movies.add(transformers);
        movies.add(walle);

        List<Movie> sorted = s.reverseSortedByTitle(movies);
        assertEquals(5, sorted.size());
        assertEquals(deadpool, sorted.get(4));
        assertEquals(walle, sorted.get(0));
    }

    @Test
    public void testKidFriendlyList(){
        List<Movie> movies = new ArrayList<>();
        movies.add(mowana);
        movies.add(walle);

        assertTrue(s.kidFriendlyList(movies));

        movies.add(deadpool);
        assertFalse(s.kidFriendlyList(movies));
    }

    @Test
    public void testAdultNightOut(){
        List<Movie> movies = new ArrayList<>();
        movies.add(mowana);
        movies.add(deadpool);
        movies.add(terminator);
        movies.add(transformers);
        movies.add(walle);

        Movie m = s.adultNightOut(movies);
        assertEquals(deadpool, m);
    }

    @Test
    public void testMovieTitles(){
        List<Movie> movies = new ArrayList<>();
        movies.add(mowana);
        movies.add(deadpool);
        movies.add(terminator);
        movies.add(transformers);
        movies.add(walle);

        List<String> titles = s.movieTitles(movies);
        assertEquals(5, titles.size());
        assertTrue(titles.contains(mowana.getTitle()));
        assertTrue(titles.contains(deadpool.getTitle()));
        assertTrue(titles.contains(terminator.getTitle()));
        assertTrue(titles.contains(transformers.getTitle()));
        assertTrue(titles.contains(walle.getTitle()));
    }

    @Test
    public void testMovieCountForYear(){
        List<Movie> movies = new ArrayList<>();
        movies.add(mowana);
        movies.add(deadpool);
        movies.add(terminator);
        movies.add(transformers);
        movies.add(walle);

        long count = s.movieCountForYear(movies, 2016);
        assertEquals(4L, count);
    }

    @Test
    public void testConvertToMap(){
        List<Movie> movies = new ArrayList<>();
        movies.add(mowana);
        movies.add(deadpool);
        movies.add(terminator);
        movies.add(transformers);
        movies.add(walle);

        Map<String, Movie> movieMap = s.convertToMap(movies);
        assertEquals(mowana, movieMap.get(mowana.getTitle()));
        assertEquals(terminator, movieMap.get(terminator.getTitle()));
        assertEquals(walle, movieMap.get(walle.getTitle()));
        assertEquals(deadpool, movieMap.get(deadpool.getTitle()));
        assertEquals(transformers, movieMap.get(transformers.getTitle()));
    }

}
