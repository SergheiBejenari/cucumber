package tests;

import model.User;
import service.UserCreator;

public class Test {

    public static boolean isPositiveBillUser1() {
        if (UserCreator.USER_1_AMOUNT > 0) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isPositiveBillUser2() {
        if (UserCreator.USER_2_AMOUNT > 0) {
            return true;
        } else {
            return false;
        }
    }
}