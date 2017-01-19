import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
        List<Integer> even = nums.stream().filter(n -> n%2==0).collect(Collectors.toList());
        return even;
    }

    /**
     * Takes a list of strings and returns a count of items
     * @param data
     * @return
     */
    public Long counts(List<String> data){
        Long count = data.stream().count();
        return count;
    }

    /**
     * Takes a list of numbers and returns the count of even numbers
     * @param nums
     * @return
     */
    public Long countEvens(List<Integer> nums){
        Long evenCount = nums.stream().filter(n -> n%2==0).count();
        return evenCount;
    }

    /**
     * Takes a list of numbers and returns a list with all duplicates removed
     * @param data
     * @return
     */
    public List<String> distinctOnly(List<String> data){
        List<String> distinct = data.stream().distinct().collect(Collectors.toList());
        return distinct;
    }

    /**
     * Takes a list of strings and returns the first 5 distinct strings
     * @param data
     * @return
     */
    public List<String> distinctOnlyFirst3(List<String> data){
        List<String> firstThree = data.stream().limit(3).collect(Collectors.toList());
        return firstThree;
    }

    /**
     * Takes a list of integers and uses .reduce to return the maximum value
     * @param data
     * @return
     */
    public Integer distinctMax(List<Integer> data){
        Integer max = data.stream().reduce(0, Integer::max);
        return max;
    }

    /**
     * Sort the incoming string data
     * @param data
     * @return
     */
    public List<String> sortedStrings(List<String> data){
        List<String> sort = data.stream().sequential().sorted().collect(Collectors.toList());
        return sort;
    }

    /**
     * Take the list of strings and sort it in reverse order
     * @param data
     * @return
     */
    public List<String> reverseSortedStrings(List<String> data){
        List<String> reverse = data.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return reverse;
    }

    /**
     * Filters movies for ones that are more than 120 minutes
     * @param movies
     * @return
     */
    public List<Movie> getLongMovies(List<Movie> movies){
        List<Movie> longMovies = movies.stream().filter(m -> m.getRunTime() >= 120).collect(Collectors.toList());
        return longMovies;
    }

    /**
     * Filters movies for ones that are G or PG
     * @param movies
     * @return
     */
    public List<Movie> getKidMovies(List<Movie> movies){
        List<Movie> kids = movies.stream().filter(m -> m.getRating().endsWith("G")).collect(Collectors.toList());
        return kids;
    }

    /**
     * Returns a list of movies that are distinct
     * @param movies
     * @return
     */
    public List<Movie> getDistinctMovies(List<Movie> movies){
        List<Movie> specificMovie = movies.stream().distinct().collect(Collectors.toList());
        return specificMovie;
    }

    /**
     * Returns the first 2 movies with a title less than 10 characters
     * @param movies
     * @return
     */
    public List<Movie> getFirst2MoviesShortTitle(List<Movie> movies){
        List<Movie> firstTwo = movies.stream().limit(2).collect(Collectors.toList());
        return firstTwo;
    }

    /**
     * Return the same list of movies sorted by title
     * @param movies
     * @return
     */
    public List<Movie> sortMoviesByTitle(List<Movie> movies){
        List<Movie> byTitle = movies.stream().sorted(Comparator.comparing(Movie::getTitle)).collect(Collectors.toList());
        return byTitle;
    }

    /**
     * Returns the same list of movies sorted in reverse order
     * @param movies
     * @return
     */
    public List<Movie> reverseSortedByTitle(List<Movie> movies){
        List<Movie> reversedTitle = movies.stream().sorted(Comparator.comparing(Movie::getTitle).reversed()).collect(Collectors.toList());
        return reversedTitle;
    }

    /**
     * Returns true if the movie list only contains G rated movies
     * @param movies
     * @return
     */
    public boolean kidFriendlyList(List<Movie> movies){
        boolean gRated = movies.stream().allMatch(m -> m.getRating().endsWith("G"));
        return gRated;
    }

    /**
     * Returns the first movie with an R rating in the list
     * @param movies
     * @return
     */
    public Movie adultNightOut(List<Movie> movies){
        Optional<Movie> nc17 = movies.stream().filter(m -> m.getRating().endsWith("R")).findFirst();
        return nc17.get();
    }

    /**
     * Return a list of strings representing movie titles
     * @param movies
     * @return
     */
    public List<String> movieTitles(List<Movie> movies){
        List<String> movieStrings = movies.stream().map(m -> m.getTitle()).collect(Collectors.toList());
        return movieStrings;
    }

    /**
     * Gets the count of all movies from the given year
     * @param movies
     * @param year
     * @return
     */
    public long movieCountForYear(List<Movie> movies, int year){
        Long movieCount = movies.stream().filter(m -> m.getYear() == year).count();
        return movieCount;
    }

    /**
     * Converts the movie list to a map of title, movie object
     * @param movies
     * @return
     */
    public Map<String, Movie> convertToMap(List<Movie> movies){
        Map <String, Movie> map = movies.stream().collect(Collectors.toMap(m -> m.getTitle(), m ->m));
        return map;
    }
}
