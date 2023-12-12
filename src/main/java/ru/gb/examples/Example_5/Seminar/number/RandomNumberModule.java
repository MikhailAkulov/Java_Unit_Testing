package main.java.ru.gb.examples.Example_5.Seminar.number;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumberModule {
    public ArrayList<Integer> getList(int i) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            array.add(new Random().nextInt(100));
        }
        return array;
    }
}
