package com.example.javadigitalsteg;

//import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
public class View extends Pane{
    private Controller controller;
    public View(Controller controller,String url){
        this.controller = controller;

        setPrefSize(500*2 , 400);
        Image image=new Image(url);
        ImageView originalView = new ImageView(image);
        ImageView modifiedView = new ImageView();
        modifiedView.setTranslateX(500);

        TextField field = new TextField("Enter message");
        field.setTranslateY(350);
        field.setOnAction(e-> controller.onEncode());

        Button btnDecode = new Button("DECODE");
        btnDecode.setTranslateX(500);
        btnDecode.setTranslateY(350);
        btnDecode.setOnAction(e->controller.onDecode());

        controller.injectUI(originalView, modifiedView, field);

        getChildren().addAll(originalView,modifiedView, field, btnDecode);
    }
}
