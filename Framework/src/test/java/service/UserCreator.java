package service;

import model.User;

public class UserCreator {
    public static final String TEST_DATA_USER_NAME = "testdata.user.name";
    public static final String TEST_DATA_USER_LASTNAME = "testdata.user.lastName";
    public static final String TEST_DATA_USER_EMAIL = "testdata.user.registrationEmail";
    public static final String TEST_DATA_USER_PASSWORD = "testdata.user.password";

    public static User WithLowLimitSymbols(){
        return new User( TestDataReader.getTestData(TEST_DATA_USER_NAME),
                TestDataReader.getTestData(TEST_DATA_USER_LASTNAME),
                TestDataReader.getTestData(TEST_DATA_USER_EMAIL),
                TestDataReader.getTestData(TEST_DATA_USER_PASSWORD));
    }

    public static User InvalidPassword(){
    return new User(TestDataReader.getTestData(TEST_DATA_USER_EMAIL), TestDataReader.getTestData(TEST_DATA_USER_PASSWORD));
    }

}
