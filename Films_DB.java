import java.util.HashMap;
import java.util.HashSet;

public class Films_DB {
    private static HashSet<Film> films = new HashSet<Film>();
    private static HashSet<Actor> actors = new HashSet<Actor>();
    private static HashMap<String, HashSet<String>> filmActors = new HashMap<String, HashSet<String>>();
    private static HashMap<String, HashSet<String>> actorFilms = new HashMap<String, HashSet<String>>();

    private Films_DB() {
    }

    public static void addFilm(Film film) {
        films.add(film);
        filmActors.put(film.getName(), film.getActors());
    }

    public static boolean removeFilm(Film film) {
        filmActors.remove(film.getName());
        return films.remove(film);
    }

    public static void addActor(Actor actor) {
        actors.add(actor);
        actorFilms.put(actor.getName(), actor.getFilms());
    }

    public static boolean removeActor(Actor actor) {
        actorFilms.remove(actor.getName());
        return actors.remove(actor);
    }

    public static HashSet<String> getActorsByFilm(String name)
    {
        return filmActors.get(name);
    }

    public static HashSet<String> getFilmsByActors(String name)
    {
        return actorFilms.get(name);
    }

    public static HashSet<Film> getFilms() {
        return (HashSet<Film>) films.clone();
    }

    public static HashSet<Actor> getActors() {
        return (HashSet<Actor>) actors.clone();
    }
} 