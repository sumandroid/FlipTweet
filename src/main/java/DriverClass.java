import domain.models.Tweet;
import domain.models.User;
import domain.models.UserFollower;
import repositories.*;
import services.FeedService;
import services.TweetService;
import services.UserService;
import services.impl.FeedServiceImpl;
import services.impl.TweetServiceImpl;
import services.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class DriverClass {

    public static void main(String []args){

        User gopal = new User("Gopal");
        User madhav = new User("Madhav");
        User lucky = new User("Lucky");
        User laxman = new User("Laxman");

        UserRepository userRepository = new UserRepositoryImpl();
        UserFollowerRepository userFollowerRepository = new UserFollowerRespositoryImpl();
        UserService userService = new UserServiceImpl(userRepository, userFollowerRepository);

        userService.save(gopal);
        userService.save(madhav);
        userService.save(lucky);
        userService.save(laxman);

        List<String> gopalFollowers = new ArrayList<>(Arrays.asList("Madhav", "Laxman", "Lucky"));
        List<String> luckyFollowers = new ArrayList<>(Arrays.asList("Laxman"));

        userService.addFollowers(gopal, gopalFollowers);
        userService.addFollowers(lucky, luckyFollowers);

        TweetRepository tweetRepository = new TweetRepositoryImpl();
        TweetService tweetService = new TweetServiceImpl(tweetRepository, userService);

        tweetService.create("goodmorning", gopal.getName());

        Tweet createdTweetByGopal = tweetService.create("bonjour", gopal.getName());

        Tweet luckyTweet = tweetService.create("goodnight", lucky.getName());

        List<Tweet> tweets = tweetService.getTweetsByUserName(gopal.getName());

        if(tweets.size() == 0) {
            System.out.println("No tweet found for user" + gopal.getName());
        }else{
            tweets.forEach(System.out::println);
        }

        UserHiddenTweetRepository userHiddenTweetRepository = new UserHiddenTweetRepositoryImpl();
        FeedService feedService = new FeedServiceImpl(userService, tweetService, userHiddenTweetRepository);
        feedService.hideTweetForUser(luckyTweet.getId(), laxman.getName());
        List<Tweet> feed = feedService.getUserFeedByName(laxman.getName());
        System.out.println("printing feed of laxman: ");
        for(Tweet tweet : feed){
            System.out.println(tweet);
        }

        tweetService.delete(createdTweetByGopal.getId());

        System.out.println("printing tweets of gopal: ");
        List<Tweet> gopalTweets = tweetService.getTweetsByUserName(gopal.getName());
        gopalTweets.forEach(System.out::println);










    }
}
