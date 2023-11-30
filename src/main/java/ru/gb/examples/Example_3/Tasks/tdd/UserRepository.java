package main.java.ru.gb.examples.Example_3.Tasks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
       if (data == null) {
           throw new NullPointerException("List of users is null");
       } else if (data.contains(user)) {
           throw new IllegalStateException("User already exist");
       } else if (!user.isAuthenticate) {
           throw new IllegalStateException("User was not authenticated");
       } else {
           data.add(user);
       }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void logOutUsersExceptAdmins() {
        if (data.isEmpty()) {
            throw new NullPointerException("List of users is empty");
        } else {
            data.forEach(user -> {
                if (!user.isAdmin()) {
                    user.logOut();
                }
            });
        }
        data = data.stream()
                .filter(User::isAdmin).collect(Collectors.toUnmodifiableList());
    }
}
