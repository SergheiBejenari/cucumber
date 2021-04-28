package service;

import model.User;

public class UserCreator {

    public static User createFirstUser() {
        User user = new User("User1", "qwerty1234");
        user.setCardNumber("1234567890123456");
        user.setExpirationMonth("3");
        user.setExpirationYear("2021");
        return user;
    }

    public static User createSecondUser() {
        User user = new User("User2", "qwerty1234");
        user.setCardNumber("1234567890123456");
        user.setFirstName("Serghei");
        user.setLastName("CardHolder");
        return user;
    }
}
