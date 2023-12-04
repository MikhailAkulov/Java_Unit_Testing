package main.java.ru.gb.examples.Example_4.Lecture;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Dummy (объект-заглушка)
 * Stub (заглушка)
 * Mock (имитация)
 * Spy (шпионы)
 * Fake (подделки)
 * Mocking Frameworks
 */

public class Mockito {
    public static void main(String[] args) {
        List mockedList = mock(List.class);     // создали заглушку

        mockedList.add("one");
        System.out.println(mockedList.get(0));
        mockedList.clear();
    }
}
