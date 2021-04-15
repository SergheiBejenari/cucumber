package service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreator {
    public static final String USER_LOGIN_ID_1 = "User1";
    public static final String USER_PASSWORD_1 = "qwerty1234";
    public static Double USER_1_AMOUNT = 0.0;
    public static Double USER_1_AMOUNT_AFTER_TRANSFER = USER_1_AMOUNT - 50.0;
    public static Double USER_1_CURRENT_AMOUNT_AFTER_TRANSFER = 0.0;

    public static final String USER_LOGIN_ID_2 = "User2";
    public static final String USER_PASSWORD_2 = "qwerty12345";
    public static Double USER_2_AMOUNT = 0.0;
    public static Double USER_2_AMOUNT_AFTER_TRANSFER = USER_2_AMOUNT + 50.0;
    public static Double USER_2_CURRENT_AMOUNT_AFTER_TRANSFER = 0.0;
}