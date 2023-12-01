package main.java.ru.gb.examples.Example_3.Tasks.tdd;

import java.util.Objects;

/**
 * Разработайте класс User с методом аутентификации по логину и паролю.
 * Метод должен возвращать true, если введенные логин и пароль корректны, иначе false.
 * Протестируйте все методы
 *
 * Добавьте функцию в класс UserRepository, которая разлогинивает всех пользователей, кроме администраторов.
 * Для этого, вам потребуется расширить класс User новым свойством,
 * указывающим, обладает ли пользователь админскими правами.
 * Протестируйте данную функцию.
 */
public class User {

    private String name;
    private String password;
    Boolean isAdmin;
    boolean isAuthenticate = false;

    public User(String name, String password, Boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //3.6.
    public boolean authenticate(String name, String password) {
        if (name != null && !name.isEmpty() && password != null && !password.isEmpty()) {
            if (!isAuthenticate) {
                if (name.equals(this.name) && password.equals(this.password)) {
                    isAuthenticate = true;
                    return true;
                }
            } else {
                throw new IllegalArgumentException("null or empty string during authentication");
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isAuthenticate() {
        return isAuthenticate;
    }

    public void logOut() {
        if (isAuthenticate()) {
            this.isAuthenticate = false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(isAdmin, user.isAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPassword(), isAdmin);
    }
}