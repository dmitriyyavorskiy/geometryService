package com.somepackage.controller.advice;

public class ValidationConstants {

    public static final int MINIMAL_USER_AGE = 16;

    public static final int MAXIMUM_USER_AGE = 120;

    public static final String MINIMAL_USER_AGE_MESSAGE = "User age too small";

    public static final String MAXIMUM_USER_AGE_MESSAGE = "User age too big";

    public static final String INCORRECT_TOKEN = "Incorrect token";

    public static final String INCORRECT_LOGIN = "Incorrect login";

    public static final String LINK_IS_BROKEN = "Link is broken";

    // public static final String PHONE_PATTERN =  "^[\\+]?([0-9]{1,2})?[-\\s]?[(]?[0-9]{3}[)]?[-\\s]?[0-9]{3}[-\\s]?[0-9]{2,4}[-\\s]?[0-9]{0,2}$";

    public static final String PHONE_PATTERN =  "^[\\+]?([0-9]{1,2})?[-\\s]?[(]?[0-9]{3}[)]?[-\\s]?[0-9]{3}[-\\s]?[0-9]{2,4}[-\\s]?[0-9]{0,2}$";

    public static final String USER_ID_MESSAGE = "Required";

    public static final String USER_PHONE_MESSAGE = "Min 7 characters (digits - and +)";

    public static final String USER_LAST_NAME_MESSAGE = "Min 3 character";

    public static final String USER_FIRST_NAME_MESSAGE = "Min 3 character";

    public static final String USER_LOGIN_MESSAGE = "Incorrect login";

    public static final String USER_LOGIN_REQUIRED_MESSAGE = "Incorrect login";

    public static final String USER_EMAIL_MESSAGE = "Incorrect email";

    public static final String USER_EMAIL_REQUIRED_MESSAGE = "Incorrect email";

    public static final String USER_PASSWORD_MESSAGE = "Min 5 characters";

    public static final String USER_PASSWORD_REQUIRED_MESSAGE = "Required";

    public static final String USER_OLD_PASSWORD_MATCH_MESSAGE = "The old password is not correct";

    public static final String USER_PASSWORD_NOT_CORRECT_MESSAGE = "Incorrect password";

    public static final String USER_DOES_NOT_EXIST_MESSAGE = "User does not exist";

    public static final String ORGANIZATION_NAME_MESSAGE = "Min 2 characters";

    public static final String ORGANIZATION_POSITION_MESSAGE = "Min 2 characters";

    public static final String ORGANIZATION_EMAIL_MESSAGE = "Incorrect email";

    public static final String ORGANIZATION_DOES_NOT_EXISTS_MESSAGE = "Incorrect email";

    public static final String ORGANIZATION_PHONE_MESSAGE = "Min 7 characters (digits - and +)";

    public static final String ORGANIZATION_DEPARTMENT_MESSAGE = "Min 2 characters";

    public static final String CITY_MESSAGE = "Required";

    public static final String ADDRESS_MESSAGE = "Required";

    public static final String STREET_MESSAGE = "Required";

    public static final String NUMBER_MESSAGE = "Required";

    public static final String STATE_MESSAGE = "Required";

    public static final String ZIP_CODE_MESSAGE = "Required";

    public static final String COUNTRY_MESSAGE = "Required";

    public static final String LOGIN_INCORRECT = "The account or password is incorrect. Please try again";

    public static final String POLYGON_SIZE = "Incorrect polygon size";

    public static final String PRESENT_OR_FUTURE_MESSAGE = "Should be present or future";

    public static final String IN_THE_PAST_MESSAGE = "Should be in the past";

    public static final String AFTN_MESSAGE = "AFTN must be 8 digits";

    public static final String BANNED_EMAIL_SERVICE_MESSAGE = "Banned email service";

    public static final String MAXIMUM_UPLOAD_SIZE_EXCEEDED_MESSAGE = "File size exceeded. Maximum upload size is 5Mb.";

    public static final String SEARCH_ID_MESSAGE = "Identificator should be numeric";

    public static final String DSS_CLIENT_CLIENT_NAME = "DssClient name should be not empty";

    public static final String DSS_CLIENT_BASE_URL = "DssClient base url should be correct";

    public static final String DSS_CLIENT_ALLOWED_SCOPES = "DssClient allowed scopes should be not empty";
}
