package praktikum;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public static UserData getRandom() {
        String name = RandomStringUtils.randomAlphabetic(10);
        String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(6);
        return new UserData(name, email, password);
    }
}