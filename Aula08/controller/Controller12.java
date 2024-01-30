package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller12 implements Initializable{

    @FXML
    private TreeView<String> treeview;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        TreeItem<String> root = new TreeItem<>("Files", new ImageView(new Image("/assets/pasta.png")));

        TreeItem<String> branchItem1 = new TreeItem<>("Pictures");
        TreeItem<String> branchItem2 = new TreeItem<>("Video");
        TreeItem<String> branchItem3 = new TreeItem<>("Music");

        TreeItem<String> leafItem1_1 = new TreeItem<>(".png");
        TreeItem<String> leafItem2_1 = new TreeItem<>(".jpeg");
        TreeItem<String> leafItem1_2 = new TreeItem<>(".mp4");
        TreeItem<String> leafItem2_2 = new TreeItem<>(".wav");
        TreeItem<String> leafItem1_3 = new TreeItem<>(".mp3");
        TreeItem<String> leafItem2_3 = new TreeItem<>(".flac");

        root.getChildren().addAll(branchItem1,branchItem2,branchItem3);

        branchItem1.getChildren().addAll(leafItem1_1,leafItem2_1);
        branchItem2.getChildren().addAll(leafItem1_2,leafItem2_2);
        branchItem3.getChildren().addAll(leafItem1_3,leafItem2_3);

        //treeview.setShowRoot(false);
        treeview.setRoot(root);

    }

    public void select() {

        TreeItem<String> item = treeview.getSelectionModel().getSelectedItem();

        if (item != null) {
            System.out.println(item.getValue());
        }

    }


}
