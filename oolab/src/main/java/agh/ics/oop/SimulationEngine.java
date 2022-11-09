package agh.ics.oop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;

public class SimulationEngine implements IEngine {

    private final IWorldMap map;
    private final List<MoveDirection> moves = new LinkedList<>();
    private final List<Animal> animals = new ArrayList<>();
    private int currentAnimal;

    public SimulationEngine(MoveDirection[] dir, IWorldMap m, Vector2d[] p) {
        map = m;
        Collections.addAll(moves, dir);
        for (Vector2d pos : p) {
            var a = new Animal(map, pos);
            if (map.place(a)) {
                animals.add(a);
            }
        }
    }


    @Override
    public void run( ) throws InterruptedException {
        this.run(true);
    }

    public void run( boolean gui ) throws InterruptedException {
        JFrame frame = new JFrame("World");
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JTextArea label = new JTextArea(map.toString());
        label.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        label.setEditable(false);
        panel.add(label);
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if( gui ) {
            frame.setVisible(true);
        }

        System.out.println(moves);
        System.out.println(map);
        for (MoveDirection m : moves) {
            System.out.println(currentAnimal);
            System.out.println(m);
            animals.get(currentAnimal).move(m);
            currentAnimal = ++currentAnimal % animals.size();
            System.out.println(map);
            label.setText(map.toString().trim());
            if( gui )
                sleep(400);
        }

    }
}
