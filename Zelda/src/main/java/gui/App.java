package gui;

import board.Board;
import board.Vector2d;
import characters.PlayerCharacter;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import objects.IBoardObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class App extends Application {
    private final int height = 12;
    private final int width = 17;
    private GridPane gridPane = new GridPane();
    @Override
    public void start(Stage primaryStage) throws Exception {
        PlayerCharacter player = new PlayerCharacter();
        Board board = new Board(player);
        createBoard(board,gridPane);
        Scene scene = new Scene(gridPane,1000, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public VBox createBoxObject(IBoardObject object,int x, int y){
        VBox box = new VBox();
        Image image = null;
        try {
            image = new Image(new FileInputStream(object.getPictureFilePath()));
        } catch (FileNotFoundException e) {
            System.out.println("File doesnt exists");
        }
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(x-1);
        imageView.setFitHeight(y-1);
        box.getChildren().add(imageView);
        box.setAlignment(Pos.CENTER);
        return box;
    }

    public void createBoard(Board board, GridPane gridPane) {
        gridPane.setGridLinesVisible(false);
        gridPane.getColumnConstraints().clear();
        gridPane.getRowConstraints().clear();
        gridPane.getChildren().clear();
        gridPane.setGridLinesVisible(true);

        for (int i = 0; i < width; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints(1000 / width);
            columnConstraints.setPercentWidth(100.0 / width);
            gridPane.getColumnConstraints().add(columnConstraints);
        }

        for (int i = 0; i < height; i++) {
            RowConstraints rowConstraints = new RowConstraints(700 / height);
            rowConstraints.setPercentHeight(100.0 / height);
            gridPane.getRowConstraints().add(rowConstraints);
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j <height; j++) {
                //System.out.println(i+","+j);
                if (board.boardContainsKey(new Vector2d(i,j))) {
                    //System.out.println(i+","+j);
                    IBoardObject object = board.ObjectAt(new Vector2d(i,j));
                    VBox box = createBoxObject(object, 1000 / width, 700 / height);
                    GridPane.setConstraints(box, i, j);
                    GridPane.setHalignment(box, HPos.CENTER);
                    gridPane.add(box,i,j);
                }
            }
        }
    }
}

