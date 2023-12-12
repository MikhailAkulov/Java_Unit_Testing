package main.java.ru.gb.examples.Example_5.Seminar.number;

import java.util.ArrayList;

public class MaxNumberModule {
    public Integer getMaxValue(ArrayList<Integer> array) {
        Integer max = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            if (max < array.get(i)) {
                max = array.get(i);
            }
        }
        return max;
    }
}
