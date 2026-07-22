interface StreamingService {
    void streamMovie(String movieName);

    default void showSubscriptionDetails() {
        System.out.println("Streaming subscription includes movies and web series");
    }
}

interface GamingService {
    void playGame(String gameName);

    default void showSubscriptionDetails() {
        System.out.println("Gaming subscription includes online multiplayer games");
    }
}

class SmartTV implements StreamingService, GamingService {
    public void streamMovie(String movieName) {
        System.out.println("Streaming movie: " + movieName);
    }

    public void playGame(String gameName) {
        System.out.println("Playing game: " + gameName);
    }

    public void showSubscriptionDetails() {
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }
}

public class SmartTVDemo {
    public static void main(String[] args) {
        String[] movies = {"Inception", "Interstellar", "The Dark Knight"};
        String[] games = {"FIFA", "Minecraft", "Asphalt"};
        SmartTV tv = new SmartTV();

        tv.showSubscriptionDetails();

        for (String movie : movies) {
            tv.streamMovie(movie);
        }

        for (String game : games) {
            tv.playGame(game);
        }
    }
}
