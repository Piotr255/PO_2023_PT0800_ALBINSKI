package agh.ics.oop;

public class World {

    public static void run(String[] params){

        System.out.println("Zwierzak idzie do przodu");
        int n = params.length;
        for(int i = 0 ; i < n ; i+=1 ){
            if (i != n-1){
                System.out.print(params[i] + ",");
            }
            else {
                System.out.println(params[i]);
            }
        }
    }
    public static void main(String[] args){
        System.out.println("system wystartował");
        run(args);
        System.out.println("system zakończył działanie");
    }
}


