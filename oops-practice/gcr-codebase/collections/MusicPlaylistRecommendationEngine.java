import java.util.LinkedList;

public class MusicPlaylistRecommendationEngine {
    private final LinkedList<String> recentlyPlayedSongs = new LinkedList<>();

    public void addSong(String song) {
        recentlyPlayedSongs.remove(song);
        recentlyPlayedSongs.addFirst(song);

        if (recentlyPlayedSongs.size() > 10) {
            recentlyPlayedSongs.removeLast();
        }
    }

    public boolean searchSong(String song) {
        return recentlyPlayedSongs.contains(song);
    }

    public void displayPlaylist() {
        System.out.println("Recently Played Songs:");
        for (String song : recentlyPlayedSongs) {
            System.out.println("- " + song);
        }
    }

    public static void main(String[] args) {
        MusicPlaylistRecommendationEngine engine = new MusicPlaylistRecommendationEngine();
        engine.addSong("Shape of You");
        engine.addSong("Blinding Lights");
        engine.addSong("Levitating");
        engine.addSong("Sunflower");
        engine.addSong("Stay");
        engine.addSong("Uptown Funk");
        engine.addSong("Rolling in the Deep");
        engine.addSong("Perfect");
        engine.addSong("Bad Guy");
        engine.addSong("Dance Monkey");
        engine.addSong("As It Was");

        System.out.println("Search 'Perfect': " + engine.searchSong("Perfect"));
        System.out.println("Search 'Bohemian Rhapsody': " + engine.searchSong("Bohemian Rhapsody"));
        engine.displayPlaylist();
    }
}
