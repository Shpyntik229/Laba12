import java.util.HashSet;
import java.util.Iterator;
import java.util.Arrays;

public class Tasks {
    public static void main(String[] args) {
        Actor willSmith = new Actor("Will Smith", new HashSet<String>(Arrays.asList("Bad Boys", "Men in Black",
                "Six Degrees of Separation",
                "Showtime", "Jersey Girl")));
        Actor tommy = new Actor("Tommy Lee Jones", new HashSet<String>(Arrays.asList("Love Story", "Men in Black",
                "Man of the House",
                "The Family")));
        Actor me = new Actor("Alex Horduz", new HashSet<String>());
        Film jerseyGirl = new Film("Jersey Girl", new HashSet<String>(Arrays.asList("Ben Affleck", "Liv Tyler",
                "Raquel Castro", "Jennifer Lopez",
                "George Carlin", "Stephen Root",
                "Mike Starr", "Jason Biggs",
                "Will Smith", "Jason Lee",
                "Matt Damon", "S. Epatha Merkerson",
                "Paulie Litt", "Harley Quinn Smith",
                "Matthew Maher")));
        Film sleuth = new Film("Sleuth", new HashSet<String>(Arrays.asList("Laurence Olivier", "Michael Caine",
                "Alec Cawthorne", "John Matthews",
                "Eve Channing", "Teddy Martin")));
        Films_DB.addActor(willSmith);
        Films_DB.addActor(tommy);
        Films_DB.addActor(me);
        Films_DB.addFilm(jerseyGirl);
        Films_DB.addFilm(sleuth);
        System.out.println(Task1());
        System.out.println(Task2(willSmith).toString());
        try {
            System.out.println(Task3());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static boolean Task1() {
        HashSet<Actor> actors = Films_DB.getActors();
        for (Iterator<Actor> it = actors.iterator(); it.hasNext(); ) {
            if (it.next().getFilms().isEmpty())
                return true;
        }
        return false;
    }

    private static HashSet<String> Task2(Actor actor) {
        if (actor == null)
            throw new NullPointerException("NULL passed as a parameter");
        HashSet<String> actorsToReturn = new HashSet<String>();
        HashSet<Film> allFilms = Films_DB.getFilms();
        HashSet<String> actorsFilms = actor.getFilms();
        for (Iterator it1 = allFilms.iterator(); it1.hasNext(); ) {    //searching in films
            Film film = (Film)it1.next();
            if (actorsFilms.contains(film.getName())) {
                for (Iterator it2 = film.getActors().iterator(); it2.hasNext();) {
                    String anotherActor = (String) it2.next();
                    if (!actorsToReturn.contains(anotherActor) && anotherActor != actor.getName())
                        actorsToReturn.add(anotherActor);
                }
            }
        }

        HashSet<Actor> allActors = Films_DB.getActors();
        for (Iterator it1 = allActors.iterator(); it1.hasNext(); ) {    //searching in actors
            Actor anotherActor = (Actor)it1.next();
            for (Iterator it2 = anotherActor.getFilms().iterator(); it2.hasNext(); ) {
                String film = (String)it2.next();
                if (anotherActor.getName() != actor.getName() && actor.getFilms().contains(film)
                        && !actorsToReturn.contains(anotherActor.getName()))
                    actorsToReturn.add(anotherActor.getName());
            }
        }
        return actorsToReturn;
    }

    private static String Task3() throws Exception {
        HashSet<Film> allFilms = Films_DB.getFilms();
        if (allFilms.size() == 0)
            throw new Exception("There is no films in the database");
        String theBiggestFilm = "";
        int maxActors = -1;
        for (Film film : allFilms) {
            if (film.getActors().size() > maxActors) {
                maxActors = film.getActors().size();
                theBiggestFilm = film.getName();
            }
        }
        return theBiggestFilm;
    }
}