package com.niksan.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static Integer id = 0;

    static {
        users.add(new User(++id, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++id, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++id, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findUserById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
//        for(User user: users){
//
//            if(user.getId() == id){
//                return user;
//            }
//        }
//        return new User();
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }

    public User save(User user){
        user.setId(++id);
        users.add(user);
        return  user;
    }
}
