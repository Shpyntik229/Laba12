import java.util.HashSet;

public class Film {
    private final String name;
    private final HashSet<String> actors;

    public Film(String name, HashSet<String> actors) {
        this.name = name;
        this.actors = actors;
    }

    public String getName() {
        return this.name;
    }

    public HashSet<String> getActors() {
        return (HashSet<String>) this.actors.clone();
    }

    public int hashCode()
    {
        return name.hashCode();
    }
}