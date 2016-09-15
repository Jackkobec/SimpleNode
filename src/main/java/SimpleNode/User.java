package SimpleNode;

import java.io.Serializable;

/**
 * Usec class
 */
public class User implements Serializable {

    private String age;
    private String name;

    public User() {
    }


    public User(String age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age='" + age + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

