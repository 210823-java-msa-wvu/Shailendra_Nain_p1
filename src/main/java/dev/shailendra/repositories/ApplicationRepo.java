package dev.shailendra.repositories;

import dev.shailendra.models.Application;

import java.util.List;

public interface ApplicationRepo extends CrudRepository<Application>{
    @Override
    default Application add(Application application) {
        return null;
    }

    @Override
    default Application getById(Integer id) {
        return null;
    }

    @Override
    default List<Application> getAll() {
        return null;
    }

    @Override
    default void update(Application application) {

    }

    @Override
    default void delete(Integer id) {

    }
}
