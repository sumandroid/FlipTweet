package services;

import domain.models.Tweet;
import domain.models.User;

import java.util.List;
import java.util.UUID;

public interface TweetService {

    Tweet create(String message, String userName);

    List<Tweet> getTweetsByUserName(String userName);

    void delete(UUID id);
}
