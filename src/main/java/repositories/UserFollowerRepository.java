package repositories;

import domain.models.User;
import domain.models.UserFollower;

import java.util.List;

public interface UserFollowerRepository {

    UserFollower save(UserFollower userFollower);

    List<UserFollower> getUserFollowers(User user);

    List<UserFollower> getFollowedByUser(User user);
}
