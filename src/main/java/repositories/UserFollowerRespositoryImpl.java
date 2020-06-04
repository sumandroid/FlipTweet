package repositories;

import domain.models.User;
import domain.models.UserFollower;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserFollowerRespositoryImpl implements UserFollowerRepository {

    private static final Set<UserFollower> UserFollowers = new HashSet<>();


    @Override
    public UserFollower save(UserFollower userFollower) {
        UserFollowers.add(userFollower);
        return userFollower;
    }

    @Override
    public List<UserFollower> getUserFollowers(User user) {
        List<UserFollower> userFollowers = UserFollowers.stream()
                .filter(userFollower -> userFollower.getUser().equals(user)).collect(Collectors.toList());
        return userFollowers;
    }

    @Override
    public List<UserFollower> getFollowedByUser(User user) {
        List<UserFollower> userFollowers = UserFollowers.stream()
                .filter(userFollower -> userFollower.getFollower().equals(user)).collect(Collectors.toList());
        return userFollowers;
    }
}
