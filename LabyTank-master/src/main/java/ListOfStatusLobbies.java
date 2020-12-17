package fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ListOfStatusLobbies extends Application {
    private static LobbyObject lobbyObject = new LobbyObject();
    private static AnchorPane gridPane;
    private static VBox vBox = new VBox(5);

    @Override
    public void start(final Stage primaryStage) throws IOException {
        primaryStage.setTitle("Список");
        ScrollPane scrollPane = new ScrollPane(vBox);
        scrollPane.setFitToWidth(true);
        primaryStage.setScene(new Scene(scrollPane, 400, 400));
        primaryStage.show();


    }

    //public static void isCreateLobby() {
//        lobbyObject.addLobby(new fx.Lobby("45678", 3));
//    }


    public static void main(String[] args) {

        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {

            Scanner sc = new Scanner(System.in);
            int i = 0;

            @Override
            public void run() {
                if (sc.nextLine() != null) {
                    Platform.runLater(() -> {
                        Random rng = new Random();
                        String style = String.format("-fx-background: rgb(%d, %d, %d);"+
                                "-fx-background-color: -fx-background;",
                                rng.nextInt(256),
                                rng.nextInt(256),
                                rng.nextInt(256));
                        gridPane = new AnchorPane();
                        gridPane.setStyle(style);
                        if (i == 0) lobbyObject.addLobby(new Lobby("45678", 3, 4, i));
                        else lobbyObject.addLobby(new Lobby("0000", 1, 2, i));
                        Label label1 = new Label();
                        label1.setId("label1");
                        label1.setText(lobbyObject.getLobby(i).getName());
                        AnchorPane.setLeftAnchor(label1, 5.0);
                        AnchorPane.setTopAnchor(label1, 5.0);
                        Label label = new Label();
                        label.setId("label2");
                        label.setText(lobbyObject.getLobby(i).getCurrentCount() + "/" + lobbyObject.getLobby(i).getMax());
                        label.setOnMouseClicked(event -> (new LobbyView(lobbyObject.getLobby(label1.getText()))).start(new Stage()));
                        gridPane.requestLayout();
                        AnchorPane.setRightAnchor(label, 5.0);
                        AnchorPane.setTopAnchor(label, 5.0);
                        AnchorPane.setBottomAnchor(label, 5.0);
                        gridPane.getChildren().addAll(label1, label);
                        vBox.getChildren().add(gridPane);
                        i++;
                    });
                }
            }
        }, TimeUnit.SECONDS.toMillis(1), TimeUnit.SECONDS.toMillis(1));
        launch(args);
    }

}
