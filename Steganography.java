package com.example.javadigitalsteg;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Steganography extends Application {
    private Model makeModel(){
        return new Model(new TextEncoder(),new ImageDecoder());
    }
    @Override
    public void start(Stage primarystage) throws Exception {

        FlowPane layout=new FlowPane(10,10);
        layout.setAlignment(Pos.CENTER);
        Button b1=new Button("Image 1",new ImageView("E:\\PSG\\sem3\\java\\package\\final\\demo1\\src\\main\\java\\com\\example\\javadigitalsteg\\scene.jpg"));
        Button b2=new Button("Image 2",new ImageView("E:\\PSG\\sem3\\java\\package\\final\\demo1\\src\\main\\java\\com\\example\\javadigitalsteg\\cover.jpg"));
        Button b3=new Button("Image 3",new ImageView("E:\\PSG\\sem3\\java\\package\\final\\demo1\\src\\main\\java\\com\\example\\javadigitalsteg\\railway.jpg"));

        final Image[] image = new Image[1];//new Image("E:\\PSG\\sem3\\java\\package\\final\\demo1\\src\\main\\java\\com\\example\\javadigitalsteg\\cover.jpg");
        final ImageView[] originalView = new ImageView[1];//= new ImageView(image);

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Scene scene = new Scene(new View(new Controller(makeModel()),"E:\\PSG\\sem3\\java\\package\\final\\demo1\\src\\main\\java\\com\\example\\javadigitalsteg\\scene.jpg"));
                primarystage.setScene(scene);
            }
        });
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Scene scene = new Scene(new View(new Controller(makeModel()),"E:\\PSG\\sem3\\java\\package\\final\\demo1\\src\\main\\java\\com\\example\\javadigitalsteg\\cover.jpg"));
                primarystage.setScene(scene);
            }
        });
        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Scene scene = new Scene(new View(new Controller(makeModel()),"E:\\PSG\\sem3\\java\\package\\final\\demo1\\src\\main\\java\\com\\example\\javadigitalsteg\\railway.jpg"));
                primarystage.setScene(scene);
            }
        });
        Scene s1=new Scene(layout,700,700);
        layout.getChildren().addAll(b1,b2,b3);
        primarystage.setScene(s1);
        primarystage.setTitle("Digital Steganography");
        primarystage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}