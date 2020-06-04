package repositories;

import domain.models.Tweet;
import domain.models.User;

import java.util.List;
import java.util.UUID;

public interface TweetRepository {

    List<Tweet> getAllTweetsByUser(String userName);

    Tweet save(Tweet tweet);

    List<Tweet> findByUser(User user);

    void delete(UUID id);
}
