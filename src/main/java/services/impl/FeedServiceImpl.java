package services.impl;

import domain.models.Tweet;
import domain.models.User;
import domain.models.UserHiddenTweet;
import repositories.UserHiddenTweetRepository;
import services.FeedService;
import services.TweetService;
import services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class FeedServiceImpl implements FeedService {

    private UserService userService;
    private TweetService tweetService;
    private UserHiddenTweetRepository userHiddenTweetRepository;

    public FeedServiceImpl(UserService userService, TweetService tweetService,
                           UserHiddenTweetRepository userHiddenTweetRepository){
        this.userService = userService;
        this.tweetService = tweetService;
        this.userHiddenTweetRepository = userHiddenTweetRepository;
    }

    @Override
    public List<Tweet> getUserFeedByName(String userName) {
        User user = userService.getBYName(userName);
        List<User> followedByUser = userService.getFollowedByUser(user);
        List<Tweet> tweets = new ArrayList<>();
        Set<UUID> hiddenTweetsIds = userHiddenTweetRepository.getTweetIdHiddenForUser(user);
        for(User u : followedByUser){
            List<Tweet> userTweets  = tweetService.getTweetsByUserName(u.getName());
            for(Tweet userTweet : userTweets){
                if(!hiddenTweetsIds.contains(userTweet.getId())){
                    tweets.add(userTweet);
                }
            }
        }
        return tweets;
    }

    @Override
    public void hideTweetForUser(UUID tweetId, String userName) {
        User user = userService.getBYName(userName);
        UserHiddenTweet userHiddenTweet = new UserHiddenTweet(tweetId, user);
        userHiddenTweetRepository.save(userHiddenTweet);
    }
}
