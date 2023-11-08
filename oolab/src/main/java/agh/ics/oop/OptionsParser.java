package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class OptionsParser{
    public static List<MoveDirection> convert(String[] tab){
        List<MoveDirection> notable = new LinkedList<>();
        for (String s : tab) {
            switch (s) {
                case "f" -> {
                    notable.add(MoveDirection.FORWARD);
                }
                case "b" -> {
                    notable.add(MoveDirection.BACKWARD);
                }
                case "l" -> {
                    notable.add(MoveDirection.LEFT);
                }
                case "r" -> {
                    notable.add(MoveDirection.RIGHT);
                }
            }
        }
        return notable;
    }

}