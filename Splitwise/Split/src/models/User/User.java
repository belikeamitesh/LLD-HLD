package models.User;

import models.Balance.UserBalanceSheet;

public class User {
    String userId;
    String userName;
    UserBalanceSheet userBalanceSheet;
    public User(String userName,String id){
        this.userName=userName;
        this.userId=id;
        userBalanceSheet = new UserBalanceSheet();
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public UserBalanceSheet getUserBalanceSheet() {
        return userBalanceSheet;
    }
}
