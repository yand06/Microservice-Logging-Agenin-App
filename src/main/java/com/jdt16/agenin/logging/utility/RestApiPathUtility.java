package com.jdt16.agenin.logging.utility;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestApiPathUtility {
    public static final String API_PATH = "/api";
    public static final String API_VERSION = "/v1";
    public static final String API_PATH_USER = "/user";
    public static final String API_PATH_GET = "/get";
    public static final String API_PATH_USER_PAGINATION = "/page";
    public static final String API_PATH_BY_ID = "/{id}";
    public static final String API_PATH_CREATE = "/create";
    public static final String API_PATH_USER_MIN_DATE = "/min-date";
    public static final String API_PATH_USER_COUNT_NAME = "/count-name";
    public static final String API_PATH_MODULE_LOGIN = "/login";
    public static final String API_PATH_MODULE_PROFILE = "/profile";
    public static final String API_PATH_MODULE_CHANGE_EMAIL = "/change-email";
    public static final String API_PATH_MODULE_CHANGE_PASSWORD = "/change-password";


}
