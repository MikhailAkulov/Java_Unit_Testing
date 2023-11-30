package main.java.ru.gb.examples.Example_3.Seminar.tdd;

public class MoodAnalyser {

    public String analyseMood(String message) {
        if (message.contains("хорошее")) {
            return "happy";
        } else if (message.contains("плох")) {
            return "sad";
        }
        return "So so";
    }

}