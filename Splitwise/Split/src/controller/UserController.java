package controller;

import models.User.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    List<User>users;
    public UserController(){
        this.users = new ArrayList<>();
    }
    public  void addUser(User user){
        users.add(user);
    }
    public User getUserById(String id){
        for (User user : users) {
            if (user.getUserId().equals(id)) {
                return user;
            }
        }
        return null;
    }
    public List<User> getAllUsers(){
        return  this.users;
    }
}
