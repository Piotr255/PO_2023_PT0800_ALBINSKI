package agh.ics.oop;

public class World {

    public static void run(String[] params){
        for (String param : params) {
            switch (param) {
                case "f" -> System.out.println("Zwierzak idzie do przodu");
                case "b" -> System.out.println("Zwierzak idzie do tyłu");
                case "r" -> System.out.println("Zwierzak idzie w prawo");
                case "l" -> System.out.println("Zwierzak idzie w lewo");
            }
        }
    }
    public static void main(String[] args){
        System.out.println("start");
        run(args);
        System.out.println("stop");
    }
}


