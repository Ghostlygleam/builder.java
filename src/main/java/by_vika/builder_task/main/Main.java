package by_vika.builder_task.main;
import by_vika.builder_task.model.entity.User;
import by_vika.builder_task.controller.UserController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<User.Builder> builders = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            builders.add(new User.Builder());
        }

        UserController controller = new UserController();

        // Initialize users
        Stream<User> userStream = controller.initializeUsers(builders.stream());

        // Sort users
        List<User> sortedUsers = controller.sortUsers(userStream);
        controller.printUsers(sortedUsers);

        // Filter users with even IDs
        Stream<User> evenIdUsers = controller.filterEvenIdUsers(sortedUsers.stream());
        controller.printUsers(evenIdUsers);

        // Check if there is a user with age matching their ID
        boolean hasMatchingAgeAndId = controller.hasUserWithAgeMatchingId(sortedUsers.stream());
        if (!hasMatchingAgeAndId) {
            throw new RuntimeException("No user with age matching their id found!");
        } else {
            controller.printMessage("There is a user with age matching their id.");
        }
    }
}
