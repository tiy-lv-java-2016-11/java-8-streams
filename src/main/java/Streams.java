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
        List<Integer> evenNumb = nums.stream().filter(n -> n%2 == 0).collect(Collectors.toList());
        return evenNumb;
    }

    /**
     * Takes a list of strings and returns a count of items
     * @param data
     * @return
     */
    public Integer counts(List<String> data){
        Integer count = Math.toIntExact(data.stream().count());

        return count;
    }

    /**
     * Takes a list of numbers and returns the count of even numbers
     * @param nums
     * @return
     */
    public Integer countEvens(List<Integer> nums){
        List<Integer> evenNumbers = nums.stream().filter(n -> n%2 == 0).collect(Collectors.toList());
        Integer count = Math.toIntExact(evenNumbers.stream().count());
        return count;
    }

    /**
     * Takes a list of numbers and returns a list with all duplicates removed
     * @param data
     * @return
     */
    public List<String> distinctOnly(List<String> data){
        List<String> distinctStrings = data.stream().distinct().collect(Collectors.toList());
        return distinctStrings;
    }

    /**
     * Takes a list of strings and returns the first 3 distinct strings
     * @param data
     * @return
     */
    public List<String> distinctOnlyFirst3(List<String> data){
        List<String> distinctStrings = data.stream().distinct().limit(3).collect(Collectors.toList());

        return distinctStrings;
    }

    /**
     * Takes a list of integers and  return the maximum value
     * @param data
     * @return
     */
    public Integer distinctMax(List<Integer> data){
        Integer maxNum = data.stream().reduce(Integer::max).get();
        return maxNum;
    }

    /**
     * Sort the incoming string data
     * @param data
     * @return
     */
    public List<String> sortedStrings(List<String> data){
        List<String> ordered = data.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        return ordered;
    }

    /**
     * Take the list of strings and sort it in reverse order
     * @param data
     * @return
     */
    public List<String> reverseSortedStrings(List<String> data){
        List<String> ordered = data.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return ordered;
    }

    /**
     * Filters movies for ones that are more than 120 minutes
     * @param movies
     * @return
     */
    public List<Movie> getLongMovies(List<Movie> movies){
        List<Movie> longMovies = movies.stream().filter(m -> m.getRunTime() > 120).collect(Collectors.toList());
        return longMovies;
    }

    /**
     * Filters movies for ones that are G or PG
     * @param movies
     * @return
     */
    public List<Movie> getKidMovies(List<Movie> movies){
        List<Movie> kidMovies = movies.stream().filter(m -> m.getRating().equals("G") || m.getRating()
                .equals("PG")).collect(Collectors.toList());
        return kidMovies;
    }

    /**
     * Returns a list of movies that are distinct
     * @param movies
     * @return
     */
    public List<Movie> getDistinctMovies(List<Movie> movies){
        List<Movie> distinctMovies = movies.stream().distinct().collect(Collectors.toList());
        return distinctMovies;
    }

    /**
     * Returns the first 2 movies with a title less than 10 characters
     * @param movies
     * @return
     */
    public List<Movie> getFirst2MoviesShortTitle(List<Movie> movies){
        List<Movie> firstTwo = movies.stream().filter(m -> m.getTitle().length() < 10).limit(2)
                .collect(Collectors.toList());
        return firstTwo;
    }

    /**
     * Return the same list of movies sorted by title
     * @param movies
     * @return
     */
    public List<Movie> sortMoviesByTitle(List<Movie> movies){
        List<Movie> sortedMovies = movies.stream().sorted(Comparator.comparing(Movie::getTitle)).collect(Collectors.toList());

        return sortedMovies;
    }

    /**
     * Returns the same list of movies sorted in reverse order
     * @param movies
     * @return
     */
    public List<Movie> reverseSortedByTitle(List<Movie> movies){
        List<Movie> sortedMovies = movies.stream().sorted(Comparator.comparing(Movie::getTitle).reversed()).collect(Collectors.toList());
        return sortedMovies;
    }

    /**
     * Returns true if the movie list only contains G rated movies
     * @param movies
     * @return
     */
    public boolean kidFriendlyList(List<Movie> movies){
        Boolean kidFriendly = movies.stream().allMatch(m -> m.getRating().equals("G"));
        return kidFriendly;
    }

    /**
     * Returns the first movie with an R rating in the list
     * @param movies
     * @return
     */
    public Movie adultNightOut(List<Movie> movies){
        Movie adultSwim = movies.stream().filter(m -> m.getRating().equals("R")).findFirst().get();
        return adultSwim;
    }

    /**
     * Return a list of strings representing movie titles
     * @param movies
     * @return
     */
    public List<String> movieTitles(List<Movie> movies){
        List<String> titles =  movies.stream().map(m -> m.getTitle()).collect(Collectors.toList());
        return titles;
    }

    /**
     * Gets the count of all moves from the given year
     * @param movies
     * @param year
     * @return
     */
    public long movieCountForYear(List<Movie> movies, int year){
        long yearCount = movies.stream().filter(m -> m.getYear() == year).count();
        return yearCount;
    }

    /**
     * Converts the movie list to a map of title, movie object
     * @param movies
     * @return
     */
    public Map<String, Movie> convertToMap(List<Movie> movies){
        Map<String, Movie> movieMap = movies.stream().collect(Collectors.toMap(m -> m.getTitle(), m -> m));
        return movieMap;
    }
}
