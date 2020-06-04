package domain.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

    private String name;

    public String getName() {
        return name;
    }

    public User(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getName().equals(user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
