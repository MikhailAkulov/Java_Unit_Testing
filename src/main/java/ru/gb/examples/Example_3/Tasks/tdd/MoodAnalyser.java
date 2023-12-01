package main.java.ru.gb.examples.Example_3.Tasks.tdd;

public class MoodAnalyser {

    // 3.5. Примените подход TDD для создания нового класса MoodAnalyser,
    // который оценивает настроение выраженное во фразах.
    public String analyseMood(String message) {
        if (message.contains("хорош")) {
            return "happy";
        } else if (message.contains("плох")) {
            return "sad";
        }
        return "So so";
    }
}