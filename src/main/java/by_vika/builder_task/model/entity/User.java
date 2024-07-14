package by_vika.builder_task.model.entity;

public class User {
    private Long id;
    private String login;
    private StringBuilder password;
    private int age;

    private User(Long id, String login, StringBuilder password, int age){
        this.id = id;
        this.login = login;
        this.password = password;
        this.age = age;
    }
    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public StringBuilder getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }
    public static class Builder {
        private Long id;
        private String login;
        private StringBuilder password;
        private int age;

        public Builder setId(Long id){
            this.id = id;
            return this;
        }
        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder setPassword(StringBuilder password) {
            this.password = password;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }
        public User build(){
            return new User(id, login, password, age);
        }
    }
    @Override
    public String toString(){
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password=" + password +
                ", age=" + age +
                '}';
    }

}
