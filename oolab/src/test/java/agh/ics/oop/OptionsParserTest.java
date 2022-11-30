package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parse() {
        assertArrayEquals(new MoveDirection[]{MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT},
                OptionsParser.parse("l f b r".split(" ")));

        assertArrayEquals(new MoveDirection[]{MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.BACKWARD},
                OptionsParser.parse("left right forward backward".split(" ")));

        assertThrowsExactly(IllegalArgumentException.class,
                    () -> OptionsParser.parse("l froward r j r backward rigthleft fdsgfffsdr forward".split(" ")));

        assertThrowsExactly(IllegalArgumentException.class,
                    () -> OptionsParser.parse("sdfdsf dsfsdf ff".split(" ")));

        assertArrayEquals(new MoveDirection[]{}, OptionsParser.parse(new String[]{}));
    }
}