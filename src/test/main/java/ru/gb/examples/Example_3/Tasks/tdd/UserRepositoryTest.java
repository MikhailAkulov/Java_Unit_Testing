package main.java.ru.gb.examples.Example_3.Tasks.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {
    UserRepository userRepository;
    User userAdmin;
    User userSimple;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        userAdmin = new User("Onotole", "12345", true);
        userSimple = new User("Vasya", "qwerty", false);
    }

    // 1.
    @Test
    void testAddUserNullData() {
        this.userRepository.data = null;
        assertThatThrownBy(() -> userRepository.addUser(userSimple)).isInstanceOf(NullPointerException.class)
                .hasMessage("List of users is null");
    }

    @Test
    void testAddUserEmptyRepository() {
        this.userRepository = new UserRepository();
        assertTrue(userRepository.data.isEmpty());
    }

    @Test
    void testAddUserNotEmptyRepository() {
        userSimple.authenticate("Vasya", "qwerty");
        userRepository.addUser(userSimple);
        assertFalse(userRepository.data.isEmpty());
    }

    @Test
    void testAddUserRepositorySize() {
        userSimple.authenticate("Vasya", "qwerty");
        userRepository.addUser(userSimple);
        assertEquals(1, userRepository.data.size());
    }

    @Test
    void testAddUserAlreadyExist() {
        userSimple.authenticate("Vasya", "qwerty");
        userRepository.addUser(userSimple);
        assertThatThrownBy(() -> userRepository.addUser(userSimple)).isInstanceOf(IllegalStateException.class)
                .hasMessage("User already exist");
    }

    @Test
    void testAddUserNotAuthenticate() {
        this.userRepository = new UserRepository();
        assertThatThrownBy(() -> userRepository.addUser(userSimple)).isInstanceOf(IllegalStateException.class)
                .hasMessage("User was not authenticated");
    }

    @Test
    void testAddUserHaveName() {
        userSimple.authenticate("Vasya", "qwerty");
        userRepository.addUser(userSimple);
        assertEquals("Vasya", userRepository.data.get(0).getName());
    }

    @Test
    void testAddUserHavePassword() {
        userSimple.authenticate("Vasya", "qwerty");
        userRepository.addUser(userSimple);
        assertEquals("qwerty", userRepository.data.get(0).getPassword());
    }

    // 2.
    @Test
    void testFindByNamePositive() {
        userAdmin.authenticate("Onotole", "12345");
        userSimple.authenticate("Vasya", "qwerty");
        userRepository.addUser(userAdmin);
        userRepository.addUser(userSimple);
        assertTrue(userRepository.findByName("Vasya"));
    }

    @Test
    void testFindByNameNegative() {
        userAdmin.authenticate("Onotole", "12345");
        userSimple.authenticate("Vasya", "qwerty");
        userRepository.addUser(userAdmin);
        userRepository.addUser(userSimple);
        assertFalse(userRepository.findByName("Petya"));
    }

    // 3.
    @Test
    void testLogOutWithEmptyRepository() {
        assertThatThrownBy(() -> userRepository.logOutUsersExceptAdmins()).isInstanceOf(NullPointerException.class)
                .hasMessage("List of users is empty");
    }

    @Test
    void testLogOutExceptAdmins() {
        userAdmin.authenticate("Onotole", "12345");
        userSimple.authenticate("Vasya", "qwerty");
        userRepository.addUser(userAdmin);
        userRepository.addUser(userSimple);
        userRepository.logOutUsersExceptAdmins();
        assertEquals(1, userRepository.data.size());
    }
}
