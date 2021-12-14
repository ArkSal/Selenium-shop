package models;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private static List<User> usersList;

    public UserDatabase() {
        this.usersList = new ArrayList<>();
        usersList.add(new User.Builder().title(SocialTitle.Mr)
                .firstName("Arek")
                .lastName("Sale")
                .email("randommailexisting@mail.com")
                .password("RandomPassword1")
                .builder());
    }

    public void addUserToDatabase(User user){
        usersList.add(user);
    }

    public User getExistingUser(){
        return usersList.get(0);
    }
}
