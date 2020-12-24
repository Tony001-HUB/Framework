package service;

import model.User;

public class UserCreator {
    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_LASTNAME = "testdata.user.lastName";
    public static final String TESTDATA_USER_REGISTRATIONEMAIL = "testdata.user.registrationEmail";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

    public static User WithLowLimitSymbols(){
        return new User( TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_LASTNAME),
                TestDataReader.getTestData(TESTDATA_USER_REGISTRATIONEMAIL),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public static User InvalidPassword(){
    return new User(TestDataReader.getTestData(TESTDATA_USER_REGISTRATIONEMAIL), TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }
}
