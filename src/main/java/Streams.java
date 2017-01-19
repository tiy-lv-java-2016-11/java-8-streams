import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by jeff on 1/17/17.
 */
public class Streams {

    /**
     * Takes a list of numbers and returns only the even numbers
     * @param nums
     * @return List<Integer>
     */
    public List<Integer> evensOnly(List<Integer> nums){
        return nums.stream().filter(n -> n%2 == 0).collect(Collectors.toList());
    }

    /**
     * Takes a list of strings and returns a count of items
     * @param data
     * @return
     */
    public Long counts(List<String> data){
        return data.stream().count();
    }

    /**
     * Takes a list of numbers and returns the count of even numbers
     * @param nums
     * @return
     */
    public Long countEvens(List<Integer> nums){
        return nums.stream().filter(n -> n%2 == 0).count();
    }

    /**
     * Takes a list of numbers and returns a list with all duplicates removed
     * @param data
     * @return
     */
    public List<String> distinctOnly(List<String> data){
        return data.stream().distinct().collect(Collectors.toList());
    }

    /**
     * Takes a list of strings and returns the first 3 distinct strings
     * @param data
     * @return
     */
    public List<String> distinctOnlyFirst3(List<String> data){
        return data.stream().distinct().limit(3).collect(Collectors.toList());
    }

    /**
     * Takes a list of integers and uses .reduce to return the maximum value
     * @param data
     * @return
     */
    public Integer distinctMax(List<Integer> data){
        return data.stream().reduce(0, Integer::max);
    }

    /**
     * Sort the incoming string data
     * @param data
     * @return
     */
    public List<String> sortedStrings(List<String> data){
        return data.stream().sorted().collect(Collectors.toList());
    }

    /**
     * Take the list of strings and sort it in reverse order
     * @param data
     * @return
     */
    public List<String> reverseSortedStrings(List<String> data){
        return data.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    /**
     * Filters movies for ones that are more than 120 minutes
     * @param movies
     * @return
     */
    public List<Movie> getLongMovies(List<Movie> movies){
        return movies.stream().filter(movie -> movie.getRunTime()>120).collect(Collectors.toList());
    }

    /**
     * Filters movies for ones that are G or PG
     * @param movies
     * @return
     */
    public List<Movie> getKidMovies(List<Movie> movies){
        return movies.stream().filter(movie -> movie.getRating()=="PG"||movie.getRating()=="G").collect(Collectors.toList());
    }

    /**
     * Returns a list of movies that are distinct
     * @param movies
     * @return
     */
    public List<Movie> getDistinctMovies(List<Movie> movies){
        return movies.stream().distinct().collect(Collectors.toList());
    }

    /**
     * Returns the first 2 movies with a title less than or equal to 10 characters
     * @param movies
     * @return
     */
    public List<Movie> getFirst2MoviesShortTitle(List<Movie> movies){
        return movies.stream().filter(movie -> movie.getTitle().length()<10).limit(2).collect(Collectors.toList());
    }

    /**
     * Return the same list of movies sorted by title
     * @param movies
     * @return
     */
    public List<Movie> sortMoviesByTitle(List<Movie> movies){
        return movies.stream().sorted(Comparator.comparing(movie -> movie.getTitle())).collect(Collectors.toList());
    }

    /**
     * Returns the same list of movies sorted in reverse order
     * @param movies
     * @return
     */
    public List<Movie> reverseSortedByTitle(List<Movie> movies){
        return movies.stream().sorted(Comparator.comparing(Movie::getTitle).reversed()).collect(Collectors.toList());
    }

    /**
     * Returns true if the movie list only contains G rated movies
     * @param movies
     * @return
     */
    public boolean kidFriendlyList(List<Movie> movies){
        return movies.stream().allMatch(movie -> movie.getRating()=="G");
    }

    /**
     * Returns the first movie with an R rating in the list
     * @param movies
     * @return
     */
    public Movie adultNightOut(List<Movie> movies){
        return movies.stream().filter(movie -> movie.getRating().equals("R")).findFirst().get();
    }

    /**
     * Return a list of strings representing movie titles
     * @param movies
     * @return
     */
    public List<String> movieTitles(List<Movie> movies){
        return movies.stream().map(movie -> movie.getTitle()).collect(Collectors.toList());
    }

    /**
     * Gets the count of all moves from the given year
     * @param movies
     * @param year
     * @return
     */
    public long movieCountForYear(List<Movie> movies, int year){
        return movies.stream().filter(movie -> movie.getYear()==year).count();
    }

    /**
     * Converts the movie list to a map of title, movie object
     * @param movies
     * @return
     */
    public Map<String, Movie> convertToMap(List<Movie> movies){
        return movies.stream().collect(Collectors.toMap(m -> m.getTitle(), m -> m));
    }
}
