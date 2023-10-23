package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionsParser{
    public static MoveDirection[] convert(String[] tab){
        int n  = tab.length;
        int j = 0;
        MoveDirection[] notable;
        notable = new MoveDirection[n];
        for (String s : tab) {
            switch (s) {
                case "f" -> {
                    notable[j] = MoveDirection.FORWARD;
                    j += 1;
                }
                case "b" -> {
                    notable[j] = MoveDirection.BACKWARD;
                    j += 1;
                }
                case "l" -> {
                    notable[j] = MoveDirection.LEFT;
                    j += 1;
                }
                case "r" -> {
                    notable[j] = MoveDirection.RIGHT;
                    j += 1;
                }
            }
        }
        return Arrays.copyOfRange(notable,0,j);
    }

        }