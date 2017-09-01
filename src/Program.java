import com.alibaba.fastjson.JSON;
import entity.Fruit;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.Scanner;

public class Program {
    private static final String[] SONGS = new String[] {
        "https://www.mfiles.co.uk/mp3-downloads/Mozart-minuet-k2.mp3"
    };
    private static int currentSong = 0;

    private static MediaPlayer player;

    private static void initMediaPlayer(int index) {
        Media media = new Media(SONGS[index]);
        player = new MediaPlayer(media);
        player.setOnEndOfMedia(onEnd);
    }

    private static Runnable onEnd = new Runnable() {
        @Override
        public void run() {
            currentSong++;
            if (currentSong > SONGS.length) currentSong = 0;
            initMediaPlayer(currentSong);
            player.play();
        }
    };

    public static void main(String[] args) throws FileNotFoundException {
        initMediaPlayer(0);
        player.play();
    }
}
