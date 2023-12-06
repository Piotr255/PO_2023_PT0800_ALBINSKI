package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    //z wyjątkiem
    void convert() {
        String[] testtab1 = {"h","f", "b", "u" ,"l", "r", "h"};
        List<MoveDirection> expectedtab1 = List.of(MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.LEFT,
                MoveDirection.RIGHT);
        assertEquals(expectedtab1,OptionsParser.convert(testtab1));
    }

    @Test
    //bez wyjątkiem
    void convert1() {
        String[] testtab1 = {"f", "b","l", "r"};
        List<MoveDirection> expectedtab1 = List.of(MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.LEFT,
                MoveDirection.RIGHT);
        assertEquals(expectedtab1,OptionsParser.convert(testtab1));
    }
}