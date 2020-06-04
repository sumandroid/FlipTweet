package services.impl;

import domain.models.Tweet;
import domain.models.User;
import domain.models.UserFollower;
import exceptions.FollowersAlreadyAddedException;
import repositories.UserFollowerRepository;
import repositories.UserRepository;
import services.TweetService;
import services.UserService;

import java.util.*;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserFollowerRepository userFollowerRepository;

    public UserServiceImpl(UserRepository userRepository, UserFollowerRepository userFollowerRepository){
        this.userRepository = userRepository;
        this.userFollowerRepository = userFollowerRepository;
    }

    @Override
    public void save(User user) {
         userRepository.save(user);
    }

    @Override
    public void addFollowers(User user, List<String> userFollowersName) {
        List<UserFollower> userFollowers = userFollowerRepository.getUserFollowers(user);
        if(userFollowers.size() > 0){
            throw new FollowersAlreadyAddedException("followers already added for user: " + user.getName());
        }
        List<User> followers = new ArrayList<>();
        for(String userName : userFollowersName){
            User follower = userRepository.findByName(userName);
            followers.add(follower);
        }
        for(User u : followers){
            UserFollower userFollower = new UserFollower(user, u);
            userFollowerRepository.save(userFollower);
        }
    }

    @Override
    public User getBYName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> getFollowedByUser(User user) {
        List<UserFollower> followedByUser = userFollowerRepository.getFollowedByUser(user);
        List<User> followedByUserList = new ArrayList<>();
        for(UserFollower userFollower : followedByUser){
            followedByUserList.add(userFollower.getUser());
        }
        return followedByUserList;
    }

}
