import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ListOfStatusLobbies extends Application {
    private static LobbyObject lobbyObject = new LobbyObject();
    private static GridPane gridPane;

    @Override
    public void start(final Stage primaryStage) throws IOException {

        primaryStage.setTitle("Список");

        primaryStage.setScene(new Scene(gridPane, 400, 400));
        primaryStage.show();


    }

    //public static void isCreateLobby() {
//        lobbyObject.addLobby(new Lobby("45678", 3));
//    }


    public static void main(String[] args) {
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_CENTER);
        HBox hBox = new HBox();
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.TOP_CENTER);
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(40);
        gridPane.getColumnConstraints().add(columnConstraints);

        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            Scanner sc = new Scanner(System.in);
            int i = 0;

            @Override
            public void run() {
                if (sc.nextLine() != null) {
                    Platform.runLater(() -> {
                        if (i == 0) lobbyObject.addLobby(new Lobby("45678", 3, 4, i));
                        else lobbyObject.addLobby(new Lobby("0000", 1, 2, i));
                        Label label1 = new Label();
                        label1.setId("label1");
                        label1.setText(lobbyObject.getLobby(i).getName());
                        gridPane.add(label1, 0, i);
                        Label label = new Label();
                        label.setId("label2");
                        label.setText(lobbyObject.getLobby(i).getCurrentCount() + "/" + lobbyObject.getLobby(i).getMax());
                        label.setOnMouseClicked(event -> (new LobbyView(lobbyObject.getLobby(label1.getText()))).start(new Stage()));
                        gridPane.add(label, 1, i);
                        gridPane.requestLayout();
                        i++;
                    });
                }
            }
        }, TimeUnit.SECONDS.toMillis(1), TimeUnit.SECONDS.toMillis(1));
        launch(args);
    }

}


//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.geometry.Pos;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class ListOfStatusLobbies extends Application {
//    @Override
//    public void start(Stage primaryStage) throws IOException {
////        String fxmlFile = "listOfStatusLobbies.fxml";
////        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
////        Parent root = fxmlLoader.load();
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("111");
//        arrayList.add("222");
//        arrayList.add("333");
//
//        VBox vBox = new VBox();
//        vBox.setAlignment(Pos.TOP_CENTER);
//        //Button btn = new Button();
//        for (int i = 0; i < arrayList.size(); i++) {
//            vBox.getChildren().add(new Label(arrayList.get(i)));
//        }
////        Scene s = new Scene(root, 300, 275);
//////        s.getStylesheets().add(getClass().getResource("C:\\Users\\user\\IdeaProjects\\TanksInTheMaze\\ServerTanks\\src\\main\\java\\ru\\itis\\application\\list.css").toExternalForm());
////        primaryStage.setTitle("Список");
////        primaryStage.setScene(s);
////        primaryStage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
