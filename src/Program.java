import com.alibaba.fastjson.JSON;
import entity.Fruit;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.Scanner;

public class Program extends Application {
    private static final String[] SONGS = new String[] {
        "https://www.mfiles.co.uk/mp3-downloads/Mozart-minuet-k2.mp3",
        "https://www.mfiles.co.uk/mp3-downloads/sonata-in-c.mp3"
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
            if (currentSong >= SONGS.length) currentSong = 0;
            player.stop();
            initMediaPlayer(currentSong);
            player.play();
        }
    };

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        Button btnPlay = new Button("Play");
        btnPlay.setTranslateX(10);
        btnPlay.setTranslateY(10);
        btnPlay.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                player.play();
            }
        });
        Button btnPause = new Button("Pause");
        btnPause.setTranslateX(100);
        btnPause.setTranslateY(10);
        btnPause.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                player.pause();
            }
        });
        Button btnSkip = new Button("Skip");
        btnSkip.setTranslateX(10);
        btnSkip.setTranslateY(55);
        btnSkip.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                onEnd.run();
            }
        });

        pane.getChildren().addAll(btnPlay, btnPause, btnSkip);
        primaryStage.setScene(new Scene(pane));
        primaryStage.setWidth(350);
        primaryStage.setHeight(250);
        primaryStage.show();

        initMediaPlayer(0);
    }
}
