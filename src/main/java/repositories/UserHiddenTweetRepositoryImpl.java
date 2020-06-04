package repositories;


import domain.models.User;
import domain.models.UserHiddenTweet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UserHiddenTweetRepositoryImpl implements UserHiddenTweetRepository {

    private static final HashMap<User, Set<UUID>> userToTweetIdMap = new HashMap<>();

    @Override
    public void save(UserHiddenTweet userHiddenTweet) {
        if(!userToTweetIdMap.containsKey(userHiddenTweet.getUser())){
            userToTweetIdMap.put(userHiddenTweet.getUser(), new HashSet<>());
        }
        userToTweetIdMap.get(userHiddenTweet.getUser()).add(userHiddenTweet.getTweetId());
    }

    @Override
    public Set<UUID> getTweetIdHiddenForUser(User user){
        Set<UUID> uids =  userToTweetIdMap.get(user);
        if(uids == null){
            return new HashSet<>();
        }
        return uids;
    }
}
