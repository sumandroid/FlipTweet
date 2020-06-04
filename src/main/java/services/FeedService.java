package services;

import domain.models.Tweet;
import domain.models.User;

import java.util.List;
import java.util.UUID;

public interface FeedService {

    List<Tweet> getUserFeedByName(String userName);

    void hideTweetForUser(UUID tweetId, String userName);
}
