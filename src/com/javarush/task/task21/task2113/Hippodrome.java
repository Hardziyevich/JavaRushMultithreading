package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();

    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    void run() {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void move() {
        for (Horse horse :
                horses) {
            horse.move();
        }
    }

    void print() {
        for (Horse horse :
                horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public Horse getWinner() {
        Horse result = new Horse("",0.0,0.0);
        for (Horse horse:
             horses) {
            if(result.getDistance() < horse.getDistance())
                result = horse;
        }
        return result;
    }

    public void printWinner() {
        System.out.println(String.format("Winner is %s!",getWinner().getName()));
    }

    public static void main(String[] args) {
        Horse first = new Horse("first", 3, 0);
        Horse second = new Horse("second", 3, 0);
        Horse third = new Horse("third", 3, 0);
        List<Horse> horses = new ArrayList<>();
        horses.add(first);
        horses.add(second);
        horses.add(third);
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}
