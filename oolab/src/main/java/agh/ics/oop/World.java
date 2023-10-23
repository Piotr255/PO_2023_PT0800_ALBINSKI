package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {

    public static void run(MoveDirection[] params){
        for (MoveDirection param : params) {
            switch (param) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case RIGHT -> System.out.println("Zwierzak idzie w prawo");
                case LEFT -> System.out.println("Zwierzak idzie w lewo");
            }
        }
    }
    public static void main(String[] args){
        System.out.println("start");
        run(OptionsParser.convert(args));
        System.out.println("stop");
    }
}


