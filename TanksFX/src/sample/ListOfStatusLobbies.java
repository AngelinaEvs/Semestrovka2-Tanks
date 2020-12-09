package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ListOfStatusLobbies extends Application {
    private LobbyObject lobbyObject = new LobbyObject();
    private boolean isFirst = true;

    @Override
    public void start(Stage primaryStage) throws IOException {
//        String fxmlFile = "listOfStatusLobbies.fxml";
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
//        Parent root = fxmlLoader.load();
        lobbyObject.addLobby(new Lobby("ZXCVB", 1));
        lobbyObject.addLobby(new Lobby("QWERT", 3));
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_CENTER);
        HBox hBox = new HBox();
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.TOP_CENTER);
        //Button btn = new Button();
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(40);
        gridPane.getColumnConstraints().add(columnConstraints);
        for (int i = 0; i < lobbyObject.size(); i++) {
            System.out.println(lobbyObject.size());
            Label label1 = new Label();
            label1.setId("label1");

            label1.setText(lobbyObject.getLobby(i).getName());
            gridPane.add(label1, 0, i);

            Label label = new Label();
            label.setId("label2");
            label.setText(lobbyObject.getLobby(i).getCurrentCount() + "/4");
            gridPane.add(label, 1, i);
        }

        Scene s = new Scene(gridPane, 300, 275);
        s.getStylesheets().add(getClass().getResource("list.css").toExternalForm());
        primaryStage.setTitle("Список");
        if (isFirst) {
            primaryStage.setScene(s);
            primaryStage.show();
        }
        isFirst = false;

        new Timer().scheduleAtFixedRate(new TimerTask() {
            public void run() {
                // Here comes your void to refresh the whole application.
                lobbyObject.addLobby(new Lobby("45678", 3));
                try {
                    start(primaryStage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 500, 500);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
