package repositories;

import domain.models.User;
import exceptions.EntityNotFoundException;
import exceptions.UserAlreadyExistsException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserRepositoryImpl implements UserRepository {

    private static final Set<User> users = new HashSet<>();

    @Override
    public void save(User user) {
        if(users.contains(user)){
            throw new UserAlreadyExistsException("user with name " + user.getName() + " already exists");
        }
        users.add(user);
    }

    @Override
    public User findByName(String userName){
        Optional<User> userOptional = users.stream().filter(user -> user.getName().equals(userName)).findFirst();
        if(!userOptional.isPresent()) throw new EntityNotFoundException("user not found with name: " + userName);
        return userOptional.get();
    }
}
