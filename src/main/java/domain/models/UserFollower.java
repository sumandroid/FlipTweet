package domain.models;

import java.util.Objects;

public class UserFollower {

    private User user;
    private User follower;

    public User getUser() {
        return user;
    }

    public User getFollower() {
        return follower;
    }

    public UserFollower(User user, User follower) {
        this.user = user;
        this.follower = follower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserFollower)) return false;
        UserFollower that = (UserFollower) o;
        return Objects.equals(getUser(), that.getUser()) &&
                Objects.equals(getFollower(), that.getFollower());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getFollower());
    }
}
