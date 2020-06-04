package repositories;

import domain.models.User;

public interface UserRepository {

    void save(User user);

    User findByName(String userName);
}
