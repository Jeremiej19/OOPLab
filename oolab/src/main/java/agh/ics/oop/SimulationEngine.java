package agh.ics.oop;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.sleep;

public class SimulationEngine implements IEngine {

    private final IWorldMap map;
    private final IPositionChangeObserver mapBoundary;
    private final List<MoveDirection> moves = new LinkedList<>();
    private final List<Animal> animals;
    private int currentAnimal;

    public SimulationEngine(MoveDirection[] dir, AbstractWorldMap m, Vector2d[] p, MapBoundary mb) {
        map = m;
        mapBoundary = mb;
        Collections.addAll(moves, dir);
        for (Vector2d pos : p) {
            var a = new Animal(map, pos, m);
            a.addObserver(mapBoundary);
            map.place(a);
        }
        animals = map.getAnimals().values().stream().toList();
    }


    @Override
    public void run() throws InterruptedException {
        this.run(true);
    }

    public void run(boolean gui) throws InterruptedException {
        JFrame frame = new JFrame("World");

        JTextArea label = new JTextArea(map.toString());
        label.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        label.setEditable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(40, 40, 40, 40);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(label, constraints);
        frame.add(panel);

//        frame.setSize(1000, 1000);
        frame.setMaximumSize(new Dimension(1000, 1000));
        frame.setMinimumSize((new Dimension(300, 300)));
//        frame.setPreferredSize(new Dimension(500,500));

//        frame.setLocationRelativeTo(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2 - 200, dim.height / 2 - frame.getSize().height / 2 - 200);
        //
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        if (gui) {
            frame.setVisible(true);
        }

        System.out.println(moves);
        System.out.println(map);
        for (MoveDirection m : moves) {
            System.out.println(currentAnimal);
            System.out.println(m);

            animals.get(currentAnimal).move(m);
            currentAnimal = ++currentAnimal % animals.size();


            System.out.println("--");
            System.out.println(map);
            System.out.println("---");
            label.setText(map.toString().trim());
            frame.pack();
            if (gui)
                sleep(350);
        }

    }
}
