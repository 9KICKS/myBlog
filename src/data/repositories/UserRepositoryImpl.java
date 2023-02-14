package data.repositories;

import data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private int count;
    private List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        boolean userHasNotBeenSaved = user.getId() == 0;
        if(userHasNotBeenSaved) {
            saveNew(user);
        }
        return user;
    }

    private void saveNew(User user) {
        user.setId(generateUserid());
        users.add(user);
        count++;
    }

    private int generateUserid() {
        return count + 1;
    }

    @Override
    public User findById(int id) {
        for(User user : users) {
            if(user.getId() == id)
                return user;
        }
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void deleteByUser(User user) {
        for (User user1 : users) {
            if(user.equals(user1)) {
                users.remove(user);
                count--;
                break;
            }
        }
    }

    @Override
    public void deleteById(int id) {
        for(User user : users) {
            if(user.getId() == id) {
                users.remove(user);
                count--;
                break;
            }
        }
    }

    @Override
    public void deleteAll() {
        users.removeAll(users);
        count = users.size();
    }
}
