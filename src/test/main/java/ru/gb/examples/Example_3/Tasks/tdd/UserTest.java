package main.java.ru.gb.examples.Example_3.Tasks.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Objects;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User userAdmin;
    User userSimple;

    @BeforeEach
    void setUp() {
        userAdmin = new User("Onotole", "12345", true);
        userSimple = new User("Vasya", "qwerty", false);
    }

    // 1.
    @Test
    void authenticateTest() {
        userAdmin.isAuthenticate();
//        assertThrows(IllegalArgumentException.class, () -> assertFalse(userAdmin.authenticate("Onotole", ""))
//                ,"null or empty string during authentication");
//        assertThatThrownBy(() -> userAdmin.authenticate("Onotole", ""))
//                .isInstanceOf(IllegalArgumentException.class).hasMessage("null or empty string during authentication");
        assertThatThrownBy(() -> userAdmin.authenticate("Onotole", ""))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("null or empty string during authentication");
    }


    // 2.
    @Test
    void testGetNamePositive() {
        assertEquals("Vasya", userSimple.getName());
    }

    @Test
    void testGetNameNegative() {
        assertNotEquals("Vasya", userAdmin.getName());
    }

    // 3.
    @Test
    void testGetPasswordPositive() {
        assertEquals("qwerty", userSimple.getPassword());
    }

    @Test
    void testGetPasswordNegative() {
        assertNotEquals("qwerty", userAdmin.getPassword());
    }

    // 4.
    @Test
    void testUserIsAdminPositive() {
        assertTrue(userAdmin.isAdmin());
    }

    @Test
    void testUserIsAdminNegative() {
        assertFalse(userSimple.isAdmin());
    }

    // 5.
    @Test
    void testIsAuthenticateWithRightData() {
        userAdmin.authenticate("Onotole", "12345");
        assertTrue(userAdmin.isAuthenticate());
    }

    @ParameterizedTest
    @CsvSource({"Petya, 00000, false", ",,false"})
    void testIsAuthenticateWithWrongDataOrEmpty(String name, String password, boolean result) {
        assertThat(userSimple.authenticate(name, password)).isEqualTo(result);
    }

    // 6.
    @Test
    void testLogOut() {
        userAdmin.authenticate(userAdmin.getName(), userAdmin.getPassword());
        userAdmin.logOut();
        assertFalse(userAdmin.isAuthenticate());
    }

    // 7.
    @Test
    void testEqualsPositive() {
        User userAdminTest = new User("Onotole", "12345", true);
        assertEquals(userAdmin, userAdminTest);
    }

    @Test
    void testEqualsNegative() {
        User userAdminTest = new User("Onotole", "12345", true);
        assertNotEquals(userSimple, userAdminTest);
    }

    // 8.
    @Test
    void testHashCode() {
        assertEquals(Objects.hash("Vasya", "qwerty", false), userSimple.hashCode());
    }
}