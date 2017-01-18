/**
 * Created by jeff on 1/17/17.
 */
public class Movie {
    private String title;
    private int year;
    private String rating;
    private int runTime;

    public Movie(String title, int year, String rating, int runTime) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.runTime = runTime;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (year != movie.year) return false;
        if (runTime != movie.runTime) return false;
        if (!title.equals(movie.title)) return false;
        return rating.equals(movie.rating);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + year;
        result = 31 * result + rating.hashCode();
        result = 31 * result + runTime;
        return result;
    }
}
