package by_vika.builder_task.controller;
import by_vika.builder_task.model.entity.User;
import by_vika.builder_task.model.util.UserService;
import by_vika.builder_task.view.UserView;

import java.util.List;
import java.util.stream.Stream;

public class UserController {
    private UserService userService = new UserService();
    private UserView userView = new UserView();

    public Stream<User> initializeUsers(Stream<User.Builder> builderStream) {
        return userService.initializeUsers(builderStream);
    }

    public List<User> sortUsers(Stream<User> userStream) {
        return userService.sortUsers(userStream);
    }

    public Stream<User> filterEvenIdUsers(Stream<User> userStream) {
        return userService.filterEvenIdUsers(userStream);
    }

    public boolean hasUserWithAgeMatchingId(Stream<User> userStream) {
        return userService.hasUserWithAgeMatchingId(userStream);
    }

    public void printUsers(List<User> users) {
        userView.printUsers(users);
    }

    public void printUsers(Stream<User> users) {
        userView.printUsers(users);
    }

    public void printMessage(String message) {
        userView.printMessage(message);
    }
}
