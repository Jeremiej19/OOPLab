package agh.ics.oop;

import java.util.Arrays;

public class World {

    public static void main(String[] args) {

        MoveDirection[] movesList = OptionsParser.parse(args);
        System.out.println(Arrays.toString(movesList));

        Animal animal1 = new Animal();
        System.out.println(animal1);
        animal1.move(MoveDirection.RIGHT);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        animal1.move(MoveDirection.FORWARD);
        System.out.println(animal1);

        System.out.println("----------");

        Animal animal2 = new Animal();
        System.out.println(animal2);
        for (MoveDirection I : movesList) {
            animal2.move(I);
        }
        System.out.println(animal2);
    }

}