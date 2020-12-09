package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TableView<String> table;
    @FXML private TableColumn<String, String> idLobby;

    private ObservableList<String> dataList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataList.add("aaa");
        dataList.add("bbb");
        idLobby.setCellValueFactory(new PropertyValueFactory<>("idLobby"));
        table.setItems(dataList);
        //backMenu.setStyle("-fx-background-image: sample/MenuBackgound");
//        connectButton.setOnMouseEntered(event -> connectButton.setStyle("-fx-background-color: #ff565d"));
//        connectButton.setOnMouseExited(event -> connectButton.setStyle("-fx-background-color: black"));
    }

}
