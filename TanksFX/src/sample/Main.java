package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        String fxmlFile = "listOfStatusLobbies.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = fxmlLoader.load();
        //primaryStage.setTitle("Hello World");
        //Button button = new Button("Connect");
//        button.setOnMouseEntered(event -> button.setStyle("-fx-background-color: green"));
//        button.setOnMouseExited(event -> button.setStyle("-fx-background-color: green"));
        Scene scene = new Scene(root, 300, 275);
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tanks");
        //primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }

//    @Override
//    public void start(Stage primaryStage) {
//
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("111");
//        arrayList.add("222");
//        arrayList.add("333");
//
//
//        VBox vBox = new VBox();
//        vBox.setAlignment(Pos.TOP_CENTER);
//        //Button btn = new Button();
//        for (int i = 0; i < arrayList.size(); i++) {
//            vBox.getChildren().add(new Label(arrayList.get(i)));
//        }
////        btn.setText("Нажми меня и будет счастье.");
////        btn.setOnAction(new EventHandler<ActionEvent>() {
////            @Override
////            public void handle(ActionEvent event) {
////                vBox.getChildren().add(new Label("Новая кнопка!!"));
////            }
////        });
////
////        vBox.getChildren().add(btn);
//        Scene scene = new Scene(vBox, 300, 250);
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(args);
//    }
}
