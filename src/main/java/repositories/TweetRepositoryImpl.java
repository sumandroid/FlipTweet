package repositories;

import domain.models.Tweet;
import domain.models.User;
import exceptions.EntityNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class TweetRepositoryImpl implements TweetRepository{

    private static final Set<Tweet> tweets = new HashSet<>();

    @Override
    public List<Tweet> getAllTweetsByUser(String userName) {
        return null;
    }

    @Override
    public Tweet save(Tweet tweet) {
        tweets.add(tweet);
        return tweet;
    }

    @Override
    public List<Tweet> findByUser(User user) {
        return tweets.stream().filter(tweet -> tweet.getUser().equals(user)).collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {
        Optional<Tweet> tweetOptional = tweets.stream().filter(tweet -> tweet.getId().equals(id)).findFirst();
        if(!tweetOptional.isPresent()){
            throw new EntityNotFoundException("tweet not found with id :" + id);
        }
        tweets.remove(tweetOptional.get());
    }


}
