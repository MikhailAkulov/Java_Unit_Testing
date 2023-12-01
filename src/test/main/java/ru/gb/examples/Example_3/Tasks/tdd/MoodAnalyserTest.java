package main.java.ru.gb.examples.Example_3.Tasks.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoodAnalyserTest {

    MoodAnalyser moodAnalyser;

    @BeforeEach
    void setUp() {
        moodAnalyser = new MoodAnalyser();
    }

    // 3.5.
    @Test
    void testPositiveMood() {
        String check = moodAnalyser.analyseMood("у меня сегодня хорошее настроение");
        assertThat(check).isEqualTo("happy");
    }

    @Test
    void testNegativeMood() {
        String check = moodAnalyser.analyseMood("у меня сегодня плохое настроение");
        assertThat(check).isEqualTo("sad");
    }

    @Test
    void testIndifferentMood() {
        String check = moodAnalyser.analyseMood("не спрашивай");
        assertThat(check).isEqualTo("So so");
    }
}
