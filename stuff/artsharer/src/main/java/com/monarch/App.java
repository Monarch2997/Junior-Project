package com.monarch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import java.io.IOException;
import javafx.geometry.Point2D;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.control.Button; 


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage primarystage) throws IOException {
        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
        double widthPosition = screenWidth * 0.10;
        double heightPosition = screenHeight * 0.10;
        screenHeight = screenHeight * 0.75;
        screenWidth = screenWidth * 0.75;

        StackPane pane = new StackPane();
        scene = new Scene(pane, screenWidth, screenHeight);
        primarystage.setScene(scene);
        primarystage.show();
        primarystage.setTitle("Skypad Network");

        Button b = new Button("button"); 
        
        Group root = new Group();
        Canvas canvas = new Canvas(screenWidth, screenHeight);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);

        canvas.setOnMousePressed(mouseEvent-> {
            gc.beginPath();
            gc.lineTo(mouseEvent.getSceneX(), mouseEvent.getSceneY());
            gc.stroke();
        });

        canvas.setOnMouseDragged(mouseEvent-> {
            gc.lineTo(mouseEvent.getSceneX(), mouseEvent.getSceneY());
            gc.stroke();
        });

        pane.getChildren().addAll(canvas,b);

        drawShapes(gc);

        primarystage.setX(widthPosition);
        primarystage.setY(heightPosition);
        root.getChildren().add(canvas);
        primarystage.setScene(new Scene(root));
        primarystage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    private void drawShapes(GraphicsContext gc) {

        /*gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                       new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                         new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                          new double[]{210, 210, 240, 240}, 4); */
    }

}