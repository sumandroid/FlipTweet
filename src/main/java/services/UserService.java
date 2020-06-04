package services;

import domain.models.Tweet;
import domain.models.User;

import java.util.List;

public interface UserService {

    void save(User user);

    void addFollowers(User gopal, List<String> gopalFollowers);

    User getBYName(String name);

    List<User> getFollowedByUser(User user);
}
