import java.util.HashSet;

public class Actor {
    private final String name;
    private HashSet<String> films;

    public Actor(String name, HashSet<String> films) {
        this.name = name;
        this.films = films;
    }

    public String getName() {
        return this.name;
    }

    public HashSet<String> getFilms() {
        return (HashSet<String>) this.films.clone();
    }

    public void addFilm(String film) {
        this.films.add(film);
    }

    public int hashCode()
    {
        return name.hashCode();
    }

}