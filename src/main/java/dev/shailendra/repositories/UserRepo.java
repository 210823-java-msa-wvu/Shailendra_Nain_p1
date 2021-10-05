package dev.shailendra.repositories;


import dev.shailendra.models.User;


import java.util.List;

public interface UserRepo extends CrudRepository<User> {
    @Override
    User add(User user);
    @Override
    User getById(Integer id);

    User getByEmail(String email);

    @Override
    List<User> getAll();

    @Override
    void update(User user);

    @Override
    void delete(Integer id);
}
