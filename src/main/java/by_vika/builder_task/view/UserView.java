package by_vika.builder_task.view;
import by_vika.builder_task.model.entity.User;

import java.util.List;
import java.util.stream.Stream;

public class UserView {
    public void printUsers(List<User> users) {
        users.forEach(System.out::println);
    }

    public void printUsers(Stream<User> users) {
        users.forEach(System.out::println);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

}
