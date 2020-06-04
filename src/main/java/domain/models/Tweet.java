package domain.models;

import java.util.Objects;
import java.util.UUID;

public class Tweet {

    private UUID id;
    private String message;
    private User user;

    public UUID getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public Tweet(String message, User user) {
        this.message = message;
        this.user = user;
        this.id = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tweet)) return false;
        Tweet tweet = (Tweet) o;
        return getId().equals(tweet.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
