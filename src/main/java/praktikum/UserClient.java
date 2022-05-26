package praktikum;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends MainClient {
    public static final String REGISTER_PATH = BASE_URL + "register";
    public static final String LOGIN_PATH = BASE_URL + "login";
    public static final String PROFILE_PATH = BASE_URL + "account";
    public static final String FORGOT_PASSWORD_PATH = BASE_URL + "forgot-password";

    private static final String AUTH_PATH = "auth/";

    @Step("Create user {userRegister} api request")
    public ValidatableResponse create(UserData userData) {
        return given()
                .spec(getBaseSpec())
                .body(userData)
                .when()
                .post(AUTH_PATH + "register")
                .then();
    }

    @Step("Login user {userRegister} api request")
    public ValidatableResponse login(UserData userData) {
        return given()
                .spec(getBaseSpec())
                .body(userData)
                .when()
                .post(AUTH_PATH + "login")
                .then();
    }

    @Step("Delete user {accessToken} api request")
    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .spec(getBaseSpec())
                .header("Authorization", accessToken)
                .when()
                .delete(AUTH_PATH + "user")
                .then();
    }
}