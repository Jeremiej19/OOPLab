package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Collections;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        MapBoundary mapBoundary = new MapBoundary();
        AbstractWorldMap map = new GrassField(10, mapBoundary);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        MoveDirection[] directions = OptionsParser.parse(args);
        SimulationEngine engine = new SimulationEngine(directions, map, positions, mapBoundary);
        engine.run(false);
        System.out.println((Arrays.toString(map.toString().split(System.lineSeparator()))));
        var tmp =  (map.toString().split(System.lineSeparator()));
        var rows = Arrays.copyOfRange( tmp,  1,  tmp.length);
//        Collections.reverse(Arrays.asList(rows));
//        rows = Arrays.asList(rows).toArray(new String[]{});

        var cStart = mapBoundary.getBoundaries().lowerPoint.getX();
        var rStart = mapBoundary.getBoundaries().lowerPoint.getY();
//        var cStart = mapBoundary.getBoundaries().lowerPoint.getY();
//        var rStart = mapBoundary.getBoundaries().lowerPoint.getX();
        int nRows = rows[1].length();
        int nCols = rows.length;
        System.out.println(nRows);
        System.out.println(nCols);
        System.out.println(rStart);
        System.out.println(cStart);
        System.out.println(mapBoundary.getBoundaries().lowerPoint);
        GridPane gridPane = new GridPane();
        for (int i=0 ; i<= nCols; ++i) {
            gridPane.getRowConstraints().add(new RowConstraints(30));
        }
        for (int i=0 ; i<= nRows ; ++i) {
            gridPane.getColumnConstraints().add(new ColumnConstraints(30));
        }
        gridPane.setGridLinesVisible(true);
        for( int i = 0 ; i <= nRows ; ++i ) {
            var l1 = new Label(Integer.toString(i));
            GridPane.setHalignment(l1, HPos.CENTER);
            gridPane.add(l1,i,0);
        }
        for( int i = 0 ; i <= nCols ; ++i ) {
            var l2 = new Label(Integer.toString(i));
            GridPane.setHalignment(l2, HPos.CENTER);
            gridPane.add(l2,0,i);
        }
        for( int i = 0 ; i < nRows ; ++i ) {
            for( int j = nCols-1 ; j >= 0 ; --j ) {
                var loc = new Vector2d(i+cStart,j+rStart);
                var text = map.objectAt(loc) == null ? " " : map.objectAt(loc).toString();
                var l = new Label(text);
                GridPane.setHalignment(l, HPos.CENTER);
                gridPane.add(l,i+1,nCols-j);
            }
        }
        Scene scene = new Scene(gridPane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
