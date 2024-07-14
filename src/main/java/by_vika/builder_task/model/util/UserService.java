package by_vika.builder_task.model.util;
import by_vika.builder_task.model.entity.User;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserService {
    private  static final Random RANDOM = new Random();
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public Stream<User> initializeUsers(Stream<User.Builder> builderStream){
        return builderStream.map(builder -> builder
                .setId((long) (RANDOM.nextInt(1000)))
                .setLogin(generateRandomString())
                .setPassword(new StringBuilder(generateRandomString()))
                .setAge(RANDOM.nextInt(100))
                .build());

    }
    private String generateRandomString(){
        int length = 5+ RANDOM.nextInt(16);
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i<length;i++){
            sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }
    public List<User> sortUsers(Stream<User> userStream) {
        return userStream.sorted((u1, u2) -> Long.compare(u2.getId(), u1.getId()))
                .collect(Collectors.toList());
    }

    public Stream<User> filterEvenIdUsers(Stream<User> userStream) {
        return userStream.filter(user -> user.getId() % 2 == 0);
    }

    public boolean hasUserWithAgeMatchingId(Stream<User> userStream) {
        return userStream.anyMatch(user -> user.getAge() == user.getId());
    }

}
