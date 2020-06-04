package services.impl;

import domain.models.Tweet;
import domain.models.User;
import domain.models.UserHiddenTweet;
import repositories.TweetRepository;
import services.TweetService;
import services.UserService;

import java.util.List;
import java.util.UUID;

public class TweetServiceImpl implements TweetService {

    private TweetRepository tweetRepository;
    private UserService userService;

    public TweetServiceImpl(TweetRepository tweetRepository, UserService userService){
        this.tweetRepository = tweetRepository;
        this.userService = userService;
    }


    @Override
    public Tweet create(String message, String userName) {
        User user = userService.getBYName(userName);
        Tweet tweet = new Tweet(message, user);
        tweetRepository.save(tweet);
        System.out.println(tweet.getMessage() + "," + tweet.getId().toString());
        return tweet;
    }

    @Override
    public List<Tweet> getTweetsByUserName(String userName) {
        User user = userService.getBYName(userName);
        return tweetRepository.findByUser(user);
    }

    @Override
    public void delete(UUID id) {
        tweetRepository.delete(id);
    }
}
