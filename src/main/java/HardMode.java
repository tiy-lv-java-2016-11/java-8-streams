import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by jeff on 1/17/17.
 */
public class HardMode {

    /**
     * Read in numbers.txt and count the numbers
     * @return
     */
    public long countFile() throws IOException {
        return 0;
    }

    /**
     * Read in numbers.txt and average the numbers
     * @return
     */
    public double averageFile() throws IOException {
        return 0;
    }

    public Map<Integer, List<Movie>> groupByYear(List<Movie> movies){
        return movies.stream().collect(Collectors.groupingBy(m -> m.getYear()));
    }
}
