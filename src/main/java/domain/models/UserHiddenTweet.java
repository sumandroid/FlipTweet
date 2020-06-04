package domain.models;

import java.util.UUID;

public class UserHiddenTweet {

    private UUID tweetId;
    private User user;

    public UserHiddenTweet(UUID tweetId, User user) {
        this.tweetId = tweetId;
        this.user = user;
    }

    public UUID getTweetId() {
        return tweetId;
    }

    public User getUser() {
        return user;
    }
}
