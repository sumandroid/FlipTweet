package repositories;

import domain.models.User;
import domain.models.UserHiddenTweet;

import java.util.Set;
import java.util.UUID;

public interface UserHiddenTweetRepository {

    void save(UserHiddenTweet userHiddenTweet);

    Set<UUID> getTweetIdHiddenForUser(User user);
}
