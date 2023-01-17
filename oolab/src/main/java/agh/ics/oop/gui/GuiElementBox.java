package agh.ics.oop.gui;

import agh.ics.oop.AbstractWorldMapElement;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import javax.swing.text.Position;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox extends VBox {

    public GuiElementBox(AbstractWorldMapElement mapElement) throws FileNotFoundException {
        super();
        if( mapElement == null ) {
            return;
        }
        System.out.println(new File("src/main/resources/"+mapElement.fileName()).getAbsolutePath());
        Image image = new Image(new FileInputStream("src/main/resources/"+mapElement.fileName()));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        this.getChildren().add(imageView);
        var l = new Label(mapElement.getLocation().toString());
        this.getChildren().add(l);
        this.setAlignment(Pos.TOP_CENTER);
    }
}
